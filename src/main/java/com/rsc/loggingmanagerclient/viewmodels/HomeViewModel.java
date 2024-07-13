package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.EnrollSystem;
import com.rsc.loggingmanagerclient.enums.ViewEnum;
import com.rsc.loggingmanagerclient.models.SystemEnrollModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class HomeViewModel extends BaseViewModel{

    private ObservableList<SystemEnrollModel> systems;

    private StringProperty numberOfSystems;

    private ISystemService systemService;

    public HomeViewModel(ISystemService systemService) {
        this.systemService = systemService;

        //REFACTOR THIS CODE!!
        List<EnrollSystem> fetchedSystems = this.systemService.getAll();

        List<SystemEnrollModel> listOfSystems =  new ArrayList<>();

        for (EnrollSystem enrollSystem:fetchedSystems){

            SystemEnrollModel newSystem = new SystemEnrollModel(
                    enrollSystem.getEnrolledSystemId(),
                    enrollSystem.getSystemName(),
                    enrollSystem.getEnrolledDate().toString(),
                    enrollSystem.getLastUpdatedDate() == null? "":enrollSystem.getLastUpdatedDate().toString(),
                    enrollSystem.getErrorLogs(),
                    enrollSystem.getTrackingLogs()
            );

            listOfSystems.add(newSystem);
        }

        this.systems = FXCollections.observableList(listOfSystems);

        this.numberOfSystems = new SimpleStringProperty(String.valueOf(fetchedSystems.size()));
    }

    public void logout(){
        try {
            viewHandler.openModal(ViewEnum.LOGOUT_MODAL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<SystemEnrollModel> getSystems() {
        return systems;
    }

    public StringProperty numberOfSystemsProperty() {
        return numberOfSystems;
    }

}
