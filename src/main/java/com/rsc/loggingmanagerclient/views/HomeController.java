package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.models.SystemEnrollModel;
import com.rsc.loggingmanagerclient.viewmodels.HomeViewModel;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.Callback;

public class HomeController {

    @FXML
    private TableView<SystemEnrollModel> EnrolledSystemsTv;

    @FXML
    private TableColumn<SystemEnrollModel, String> EnrolledDateTc;

    @FXML
    private TableColumn<SystemEnrollModel, Integer> ErrorLogsTc;

    @FXML
    private TableColumn<SystemEnrollModel, String> LastUpdateTc;

    @FXML
    private TableColumn<SystemEnrollModel, String> SystemNameTc;

    @FXML
    private TableColumn<SystemEnrollModel, Integer> TrackingLogsTc;

    @FXML
    private TableColumn<SystemEnrollModel, Void> OperationsTc;

    @FXML
    private Button logoutBt;

    @FXML
    private Label NumOfSysLb;

    private HomeViewModel homeViewModel;

    public HomeController() {
    }

    public void init(HomeViewModel homeViewModel){
        this.homeViewModel = homeViewModel;

        this.NumOfSysLb.textProperty().bindBidirectional(this.homeViewModel.numberOfSystemsProperty());

        // Initialize the TableView columns
        this.SystemNameTc.setCellValueFactory(new PropertyValueFactory<>("systemName"));
        this.EnrolledDateTc.setCellValueFactory(new PropertyValueFactory<>("enrolledDate"));
        this.LastUpdateTc.setCellValueFactory(new PropertyValueFactory<>("lastUpdatedDate"));
        this.ErrorLogsTc.setCellValueFactory(new PropertyValueFactory<>("errorLogs"));
        this.TrackingLogsTc.setCellValueFactory(new PropertyValueFactory<>("trackingLogs"));

        this.ErrorLogsTc.setCellFactory(new Callback<TableColumn<SystemEnrollModel, Integer>, TableCell<SystemEnrollModel, Integer>>() {
            @Override
            public TableCell<SystemEnrollModel, Integer> call(TableColumn<SystemEnrollModel, Integer> systemEnrollModelIntegerTableColumn) {

                return new TableCell<SystemEnrollModel,Integer>(){
                    private Label errorLogCount = new Label();
                    private Button openErrorLogsBt = new Button();
                    private Region spacer = new Region();
                    private Image openImage = new Image(getClass().getResourceAsStream("/com/rsc/loggingmanagerclient/images/open-icon.png"));
                    private ImageView openIcon = new ImageView(openImage);

                    {
                        // Set the size of the buttons
                        double buttonSize = 24; // Set to your desired button size
                        openErrorLogsBt.setPrefSize(buttonSize, buttonSize);

                        // Configure ImageViews to fit the button size
                        openIcon.setPreserveRatio(true);
                        openIcon.setFitWidth(buttonSize);
                        openIcon.setFitHeight(buttonSize);

                        // Set ImageViews to buttons
                        openErrorLogsBt.setGraphic(openIcon);

                        // Remove padding and margin
                        openErrorLogsBt.setStyle("-fx-padding: 0; -fx-border-width: 0;");

                        openErrorLogsBt.setGraphic(openIcon);

                        openErrorLogsBt.setOnAction(event -> {
                            SystemEnrollModel system = getTableView().getItems().get(getIndex());
                            //homeViewModel.deleteSystem(system);
                        });
                    }

                    @Override
                    protected void updateItem(Integer errorCount, boolean empty) {
                        super.updateItem(errorCount, empty);
                        if (empty || errorCount == null) {
                            setGraphic(null);
                        } else {
                            errorLogCount.setText(String.valueOf(errorCount));
                            HBox container = new HBox(errorLogCount,spacer,openErrorLogsBt);
                            HBox.setHgrow(spacer, Priority.ALWAYS);
                            container.setAlignment(Pos.CENTER_LEFT);
                            setGraphic(container);
                        }
                    }
                };

            }
        });

        this.TrackingLogsTc.setCellFactory(new Callback<TableColumn<SystemEnrollModel, Integer>, TableCell<SystemEnrollModel, Integer>>() {
            @Override
            public TableCell<SystemEnrollModel, Integer> call(TableColumn<SystemEnrollModel, Integer> systemEnrollModelIntegerTableColumn) {

                return new TableCell<SystemEnrollModel,Integer>(){
                    private Label trackingLogCount = new Label();
                    private Button openTrackingLogsBt = new Button();
                    private Region spacer = new Region();
                    private Image openImage = new Image(getClass().getResourceAsStream("/com/rsc/loggingmanagerclient/images/open-icon.png"));
                    private ImageView openIcon = new ImageView(openImage);

                    {
                        // Set the size of the buttons
                        double buttonSize = 24; // Set to your desired button size
                        openTrackingLogsBt.setPrefSize(buttonSize, buttonSize);

                        // Configure ImageViews to fit the button size
                        openIcon.setPreserveRatio(true);
                        openIcon.setFitWidth(buttonSize);
                        openIcon.setFitHeight(buttonSize);

                        // Set ImageViews to buttons
                        openTrackingLogsBt.setGraphic(openIcon);

                        // Remove padding and margin
                        openTrackingLogsBt.setStyle("-fx-padding: 0; -fx-border-width: 0;");

                        openTrackingLogsBt.setGraphic(openIcon);

                        openTrackingLogsBt.setOnAction(event -> {
                            SystemEnrollModel system = getTableView().getItems().get(getIndex());
                            //homeViewModel.deleteSystem(system);
                        });
                    }

                    @Override
                    protected void updateItem(Integer errorCount, boolean empty) {
                        super.updateItem(errorCount, empty);
                        if (empty || errorCount == null) {
                            setGraphic(null);
                        } else {
                            trackingLogCount.setText(String.valueOf(errorCount));
                            HBox container = new HBox(trackingLogCount,spacer,openTrackingLogsBt);
                            HBox.setHgrow(spacer, Priority.ALWAYS);
                            container.setAlignment(Pos.CENTER_LEFT);
                            setGraphic(container);
                        }
                    }
                };

            }
        });

        // Initialize the Operations column with buttons
        this.OperationsTc.setCellFactory(new Callback<TableColumn<SystemEnrollModel, Void>, TableCell<SystemEnrollModel, Void>>() {
            @Override
            public TableCell<SystemEnrollModel, Void> call(final TableColumn<SystemEnrollModel, Void> param) {
                return new TableCell<SystemEnrollModel, Void>() {
                    private Button deleteButton = new Button();
                    private Button updateButton = new Button();

                    // Load images
                    private Image deleteImage = new Image(getClass().getResourceAsStream("/com/rsc/loggingmanagerclient/images/delete-icon.png"));
                    private Image updateImage = new Image(getClass().getResourceAsStream("/com/rsc/loggingmanagerclient/images/edit-icon.png"));

                    // Create ImageViews
                    private ImageView deleteIcon = new ImageView(deleteImage);
                    private ImageView updateIcon = new ImageView(updateImage);

                    {

                        // Set the size of the buttons
                        double buttonSize = 24; // Set to your desired button size
                        deleteButton.setPrefSize(buttonSize, buttonSize);
                        updateButton.setPrefSize(buttonSize, buttonSize);

                        // Configure ImageViews to fit the button size
                        deleteIcon.setPreserveRatio(true);
                        deleteIcon.setFitWidth(buttonSize);
                        deleteIcon.setFitHeight(buttonSize);

                        updateIcon.setPreserveRatio(true);
                        updateIcon.setFitWidth(buttonSize);
                        updateIcon.setFitHeight(buttonSize);

                        // Set ImageViews to buttons
                        deleteButton.setGraphic(deleteIcon);
                        updateButton.setGraphic(updateIcon);

                        // Remove padding and margin
                        deleteButton.setStyle("-fx-padding: 0; -fx-border-width: 0;");
                        updateButton.setStyle("-fx-padding: 0; -fx-border-width: 0;");

                        deleteButton.setGraphic(deleteIcon);
                        updateButton.setGraphic(updateIcon);

                        deleteButton.setOnAction(event -> {
                            SystemEnrollModel system = getTableView().getItems().get(getIndex());
                            //homeViewModel.deleteSystem(system);
                        });

                        updateButton.setOnAction(event -> {
                            SystemEnrollModel system = getTableView().getItems().get(getIndex());
                            //homeViewModel.updateSystem(system);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(new HBox(10, deleteButton, updateButton));
                        }
                    }
                };
            }
        });

        // Set the items for the TableView
        this.EnrolledSystemsTv.setItems(this.homeViewModel.getSystems());
    }

    public void onLogoutClick(){
        this.homeViewModel.logout();
    }

}
