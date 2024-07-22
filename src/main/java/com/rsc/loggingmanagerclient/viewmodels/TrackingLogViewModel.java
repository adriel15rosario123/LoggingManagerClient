package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.PaginatedBaseDto;
import com.rsc.loggingmanagerclient.dtos.TrackingLogDto;
import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.models.TrackingLogModel;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class TrackingLogViewModel extends BaseViewModel{
    private ObservableList<TrackingLogModel> trackingLogs;
    private ISystemService systemService;
    private int totalPages;
    private int systemId;

    public TrackingLogViewModel(ISystemService systemService, int systemId, String systemName) {
        this.systemService = systemService;
        this.systemId = systemId;
        this.trackingLogs = FXCollections.observableArrayList();
        loadPage(1); // Load the first page initially
        TrackingLogModel.setSystemName(systemName);
    }

    public void loadPage(int pageNumber) {
        PaginatedBaseDto<List<TrackingLogDto>> response = this.systemService.getTrackingLogs(systemId, 1, pageNumber);
        if (response != null) {
            List<TrackingLogModel> listOfTrackingLogs = convertToTrackingLogModels(response.getData());
            this.trackingLogs.setAll(listOfTrackingLogs);
            this.totalPages = response.getTotalPages();
        } else {
            this.trackingLogs.clear();
            this.totalPages = 0;
        }
    }

    private List<TrackingLogModel> convertToTrackingLogModels(List<TrackingLogDto> trackingLogs) {
        return trackingLogs.stream().map(this::convertToTrackingLogModel).collect(Collectors.toList());
    }

    private TrackingLogModel convertToTrackingLogModel(TrackingLogDto trackingLogDto) {
        return new TrackingLogModel(
                trackingLogDto.getLogId(),
                trackingLogDto.getLoggingDate(),
                trackingLogDto.getMethodName() == null ? "" :trackingLogDto.getMethodName(),
                trackingLogDto.getMethodInput() == null ? "":trackingLogDto.getMethodInput(),
                trackingLogDto.getMethodOutput() == null ? "":trackingLogDto.getMethodOutput(),
                trackingLogDto.getLogType(),
                trackingLogDto.getMessage() == null ? "":trackingLogDto.getMessage()
        );
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void logout(){
        viewHandler.openModal(Views.LOGOUT_MODAL);
    }

    public ObservableList<TrackingLogModel> getTrackingLogs() {
        return trackingLogs;
    }

    public StringProperty systemName(){
        return TrackingLogModel.systemNameProperty();
    }

    public void goToPrevView(){
        viewHandler.goToPrevView();
    }
}
