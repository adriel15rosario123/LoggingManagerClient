package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.models.TrackingLogModel;
import com.rsc.loggingmanagerclient.viewmodels.ErrorLogsViewModel;
import com.rsc.loggingmanagerclient.viewmodels.TrackingLogViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TrackingLogsController {

    @FXML
    private TableView<TrackingLogModel> TrackingLogsTv;

    @FXML
    private TableColumn<TrackingLogModel, String> LoggingDateTc;

    @FXML
    private TableColumn<TrackingLogModel, String> MessageTc;

    @FXML
    private TableColumn<TrackingLogModel, String> MethodInputTc;

    @FXML
    private TableColumn<TrackingLogModel, String> MethodNameTc;

    @FXML
    private TableColumn<TrackingLogModel, String> MethodOutputTc;

    @FXML
    private TableColumn<TrackingLogModel, Void> OptionsTc;

    @FXML
    private Label systemNameLb;

    @FXML
    private Pagination trackingLogsPg;


    private TrackingLogViewModel trackingLogViewModel;

    public void init(TrackingLogViewModel trackingLogViewModel){
        this.trackingLogViewModel = trackingLogViewModel;

        this.systemNameLb.textProperty().bindBidirectional(trackingLogViewModel.systemName());

        this.LoggingDateTc.setCellValueFactory(new PropertyValueFactory<>("loggingDate"));
        this.MethodNameTc.setCellValueFactory(new PropertyValueFactory<>("methodName"));
        this.MethodInputTc.setCellValueFactory(new PropertyValueFactory<>("methodInput"));
        this.MethodOutputTc.setCellValueFactory(new PropertyValueFactory<>("MethodOutput"));
        this.MessageTc.setCellValueFactory(new PropertyValueFactory<>("message"));

        this.TrackingLogsTv.setItems(trackingLogViewModel.getTrackingLogs());

        // Setup pagination
        updatePagination();
        this.trackingLogsPg.setPageFactory(this::createPage);
    }

    private void updatePagination() {
        int totalPages = trackingLogViewModel.getTotalPages();
        if (totalPages > 0) {
            this.trackingLogsPg.setPageCount(totalPages);
        } else {
            this.trackingLogsPg.setPageCount(1);
            this.trackingLogsPg.setCurrentPageIndex(0);
            this.TrackingLogsTv.setItems(FXCollections.observableArrayList());
        }
    }

    private Node createPage(int pageIndex) {
        trackingLogViewModel.loadPage(pageIndex + 1); // Page index starts from 0, so increment by 1
        return TrackingLogsTv;
    }

    public void onLogoutClick(){
        this.trackingLogViewModel.logout();
    }

    public void goToPrevView(){
        this.trackingLogViewModel.goToPrevView();
    }
}
