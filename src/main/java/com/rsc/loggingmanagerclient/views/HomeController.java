package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.models.SystemModel;
import com.rsc.loggingmanagerclient.models.UpdateSystemModel;
import com.rsc.loggingmanagerclient.viewmodels.HomeViewModel;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
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
    private TableView<SystemModel> EnrolledSystemsTv;

    @FXML
    private TableColumn<SystemModel, String> EnrolledDateTc;

    @FXML
    private TableColumn<SystemModel, Integer> ErrorLogsTc;

    @FXML
    private TableColumn<SystemModel, String> LastUpdateTc;

    @FXML
    private TableColumn<SystemModel, String> SystemNameTc;

    @FXML
    private TableColumn<SystemModel, Integer> TrackingLogsTc;

    @FXML
    private TableColumn<SystemModel, Void> OperationsTc;

    @FXML
    private BarChart<String, Number> systemBc;

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

        this.ErrorLogsTc.setCellFactory(new Callback<TableColumn<SystemModel, Integer>, TableCell<SystemModel, Integer>>() {
            @Override
            public TableCell<SystemModel, Integer> call(TableColumn<SystemModel, Integer> systemEnrollModelIntegerTableColumn) {

                return new TableCell<SystemModel,Integer>(){
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
                            SystemModel system = getTableView().getItems().get(getIndex());
                            homeViewModel.openErrorLogs(system.getEnrolledSystemId(),system.getSystemName());
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

        this.TrackingLogsTc.setCellFactory(new Callback<TableColumn<SystemModel, Integer>, TableCell<SystemModel, Integer>>() {
            @Override
            public TableCell<SystemModel, Integer> call(TableColumn<SystemModel, Integer> systemEnrollModelIntegerTableColumn) {

                return new TableCell<SystemModel,Integer>(){
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
                            SystemModel system = getTableView().getItems().get(getIndex());
                            homeViewModel.openTrackingLogs(system.getEnrolledSystemId(),system.getSystemName());
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
        this.OperationsTc.setCellFactory(new Callback<TableColumn<SystemModel, Void>, TableCell<SystemModel, Void>>() {
            @Override
            public TableCell<SystemModel, Void> call(final TableColumn<SystemModel, Void> param) {
                return new TableCell<SystemModel, Void>() {
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
                            SystemModel system = getTableView().getItems().get(getIndex());
                            homeViewModel.openDeleteModal(system.getEnrolledSystemId());
                        });

                        updateButton.setOnAction(event -> {
                            SystemModel system = getTableView().getItems().get(getIndex());
                            UpdateSystemModel updateSystemModel = new UpdateSystemModel(system.getEnrolledSystemId(),system.getSystemUsername(),system.getSystemPassword(),system.getSystemName());
                            homeViewModel.openEditView(updateSystemModel);
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

        initBarChart();
    }


    private void initBarChart() {
        systemBc.setTitle("Logs Summery");
        systemBc.getData().clear();

        XYChart.Series<String, Number> errorLogsSeries = new XYChart.Series<>();
        errorLogsSeries.setName("Error Logs");

        XYChart.Series<String, Number> trackingLogsSeries = new XYChart.Series<>();
        trackingLogsSeries.setName("Tracking Logs");

        for (SystemModel system : homeViewModel.getSystems()) {
            errorLogsSeries.getData().add(new XYChart.Data<>(system.getSystemName(), system.getErrorLogs()));
            trackingLogsSeries.getData().add(new XYChart.Data<>(system.getSystemName(), system.getTrackingLogs()));
        }

        systemBc.getData().addAll(errorLogsSeries, trackingLogsSeries);
    }

    public void onLogoutClick(){
        this.homeViewModel.logout();
    }

    public void onEnrollSystemClick(){
        this.homeViewModel.enrollSystem();
    }
}
