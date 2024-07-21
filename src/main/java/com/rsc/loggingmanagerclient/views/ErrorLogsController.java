package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.models.ErrorLogModel;
import com.rsc.loggingmanagerclient.viewmodels.ErrorLogsViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ErrorLogsController {

    @FXML
    private TableView<ErrorLogModel> errorLogsTv;

    @FXML
    private TableColumn<ErrorLogModel, String> LoggingDateTc;

    @FXML
    private TableColumn<ErrorLogModel, String> MessageTc;

    @FXML
    private TableColumn<ErrorLogModel, String> MethodInputTc;

    @FXML
    private TableColumn<ErrorLogModel, String> MethodNameTc;

    @FXML
    private TableColumn<ErrorLogModel, String> MethodOutputTc;

    @FXML
    private Pagination errorLogsPg;

    @FXML
    private TableColumn<ErrorLogModel, Void> OperationsTc;


    @FXML
    private Label SystemNameLb;

    private ErrorLogsViewModel errorLogsViewModel;

    public void init(ErrorLogsViewModel errorLogsViewModel){
        this.errorLogsViewModel = errorLogsViewModel;

        this.SystemNameLb.textProperty().bindBidirectional(errorLogsViewModel.systemName());

        this.LoggingDateTc.setCellValueFactory(new PropertyValueFactory<>("loggingDate"));
        this.MethodNameTc.setCellValueFactory(new PropertyValueFactory<>("methodName"));
        this.MethodInputTc.setCellValueFactory(new PropertyValueFactory<>("methodInput"));
        this.MethodOutputTc.setCellValueFactory(new PropertyValueFactory<>("MethodOutput"));
        this.MessageTc.setCellValueFactory(new PropertyValueFactory<>("message"));

        this.errorLogsTv.setItems(errorLogsViewModel.getErrorLogs());

        // Setup pagination
        updatePagination();
        this.errorLogsPg.setPageFactory(this::createPage);
    }

    private void updatePagination() {
        int totalPages = errorLogsViewModel.getTotalPages();
        if (totalPages > 0) {
            this.errorLogsPg.setPageCount(totalPages);
        } else {
            this.errorLogsPg.setPageCount(1);
            this.errorLogsPg.setCurrentPageIndex(0);
            this.errorLogsTv.setItems(FXCollections.observableArrayList());
        }
    }

    private Node createPage(int pageIndex) {
        errorLogsViewModel.loadPage(pageIndex + 1); // Page index starts from 0, so increment by 1
        return errorLogsTv;
    }

    public void onLogoutClick(){
        this.errorLogsViewModel.logout();
    }

    public void goToPrevView(){
        this.errorLogsViewModel.goToPrevView();
    }
}
