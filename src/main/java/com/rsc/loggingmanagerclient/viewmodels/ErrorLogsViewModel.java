package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.ErrorLogDto;
import com.rsc.loggingmanagerclient.dtos.PaginatedBaseDto;
import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.models.ErrorLogModel;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorLogsViewModel extends BaseViewModel {

    private ObservableList<ErrorLogModel> errorLogs;
    private ISystemService systemService;
    private int totalPages;
    private int systemId;

    public ErrorLogsViewModel(ISystemService systemService, int systemId, String systemName) {
        this.systemService = systemService;
        this.systemId = systemId;
        this.errorLogs = FXCollections.observableArrayList();
        loadPage(1); // Load the first page initially
        ErrorLogModel.setSystemName(systemName);
    }

    public void loadPage(int pageNumber) {
        PaginatedBaseDto<List<ErrorLogDto>> response = this.systemService.getErrorLogs(systemId, 12, pageNumber);
        if (response != null) {
            List<ErrorLogModel> listOfErrorLogs = convertToErrorLogModels(response.getData());
            this.errorLogs.setAll(listOfErrorLogs);
            this.totalPages = response.getTotalPages();
        } else {
            this.errorLogs.clear();
            this.totalPages = 0;
        }
    }

    private List<ErrorLogModel> convertToErrorLogModels(List<ErrorLogDto> errorLogs) {
        return errorLogs.stream().map(this::convertToErrorLogModel).collect(Collectors.toList());
    }

    private ErrorLogModel convertToErrorLogModel(ErrorLogDto errorLogDto) {
        return new ErrorLogModel(
                errorLogDto.getLogId(),
                errorLogDto.getLoggingDate(),
                errorLogDto.getMethodName() == null ? "" :errorLogDto.getMethodName(),
                errorLogDto.getMethodInput() == null ? "":errorLogDto.getMethodInput(),
                errorLogDto.getMethodOutput() == null ? "":errorLogDto.getMethodOutput(),
                errorLogDto.getLogType(),
                errorLogDto.getMessage() == null ? "":errorLogDto.getMessage()
        );
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void logout(){
        viewHandler.openModal(Views.LOGOUT_MODAL);
    }

    public ObservableList<ErrorLogModel> getErrorLogs() {
        return errorLogs;
    }

    public StringProperty systemName(){
        return ErrorLogModel.systemNameProperty();
    }

    public void goToPrevView(){
        viewHandler.goToPrevView();
    }
}
