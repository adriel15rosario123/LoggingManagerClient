package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.SystemDto;
import com.rsc.loggingmanagerclient.enums.ViewEnum;
import com.rsc.loggingmanagerclient.models.SystemModel;
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
                systemDto.getEnrolledSystemId(),
                systemDto.getSystemName(),
                systemDto.getEnrolledDate().toString(),
                systemDto.getLastUpdatedDate() == null ? "" : systemDto.getLastUpdatedDate().toString(),
                systemDto.getErrorLogs(),
                systemDto.getTrackingLogs()
        );
    }

    public void logout(){
        try {
            viewHandler.openModal(ViewEnum.LOGOUT_MODAL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<SystemModel> getSystems() {
        return systems;
    }

    public StringProperty numberOfSystemsProperty() {
        return SystemModel.numberOfSystemsProperty();
    }

}
