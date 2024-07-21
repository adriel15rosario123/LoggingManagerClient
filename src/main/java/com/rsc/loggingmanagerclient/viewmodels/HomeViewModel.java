package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.SystemDto;
import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.models.SystemModel;
import com.rsc.loggingmanagerclient.models.UpdateSystemModel;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class HomeViewModel extends BaseViewModel{

    private ObservableList<SystemModel> systems;
    private ISystemService systemService;

    public HomeViewModel(ISystemService systemService) {
        this.systemService = systemService;

        List<SystemDto> fetchedSystems = this.systemService.getAll();
        List<SystemModel> listOfSystems = convertToSystemModels(fetchedSystems);

        this.systems = FXCollections.observableList(listOfSystems);
        SystemModel.setNumberOfSystems(fetchedSystems.size());
    }

    private List<SystemModel> convertToSystemModels(List<SystemDto> systems) {
        return systems.stream().map(this::convertToSystemModel).collect(Collectors.toList());
    }

    private SystemModel convertToSystemModel(SystemDto systemDto) {
        return new SystemModel(
                systemDto.getSystemId(),
                systemDto.getSystemName(),
                systemDto.getEnrolledDate().toString(),
                systemDto.getLastUpdatedDate() == null ? "" : systemDto.getLastUpdatedDate().toString(),
                systemDto.getErrorLogs(),
                systemDto.getTrackingLogs(),
                systemDto.getSystemUsername(),
                systemDto.getSystemPassword()
        );
    }

    public void logout(){
        viewHandler.openModal(Views.LOGOUT_MODAL);
    }

    public void enrollSystem(){
        viewHandler.openView(Views.ENROLL_SYSTEM);
    }

    public ObservableList<SystemModel> getSystems() {
        return systems;
    }

    public StringProperty numberOfSystemsProperty() {
        return SystemModel.numberOfSystemsProperty();
    }

    public void openEditView(UpdateSystemModel updateSystemModel){
        viewHandler.openUpdateSystemView(updateSystemModel);
    }

    public void openErrorLogs(int systemId, String systemName){
        viewHandler.openErrorLogsView(systemId,systemName);
    }

}
