package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Model;
import model.WaterSourceReport;

public class Water_Source_Report_Overview_Controller {

    /** a link back to the main application class */
    private Main mainApplication;

    @FXML
    private TableView<WaterSourceReport> waterSourceTable;

    @FXML
    private TableColumn<WaterSourceReport, String> reportNumberColumn;

    @FXML
    private Label dateLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label nameOfWorkerLabel;
    @FXML
    private Label locationOfWaterLabel;
    @FXML
    private Label typeOfWaterLabel;
    @FXML
    private Label conditionOfWaterLabel;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;

        waterSourceTable.setItems(Model.getInstance().getWaterSourceReports());
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the profile table with the two columns.
        reportNumberColumn.setCellValueFactory(
                cellData -> cellData.getValue().dateProperty());

        // Clear profile details.
        showWaterSourceReportDetails(null);

        // Listen for selection changes and show the profile details when changed.
        waterSourceTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showWaterSourceReportDetails(newValue));
    }

    /**
     * Fills all text fields to show details about the waterSourceReport.
     * If the specified waterSourceReport is null, all text fields are cleared.
     *
     * @param waterSourceReport the waterSourceReport or null
     */
    private void showWaterSourceReportDetails(WaterSourceReport waterSourceReport) {
        if (waterSourceReport != null) {
            // Fill the labels with info from the waterSourceReport object.
            dateLabel.setText(waterSourceReport.getDate());
            timeLabel.setText(waterSourceReport.getTime());
            nameOfWorkerLabel.setText(waterSourceReport.getNameOfReporter());
            locationOfWaterLabel.setText(waterSourceReport.getLocation());
            typeOfWaterLabel.setText(waterSourceReport.getTypeOfWater().toString());
            conditionOfWaterLabel.setText(waterSourceReport.getConditionOfWater().toString());
        } else {
            // Profile is null, remove all the text.
            dateLabel.setText("");
            timeLabel.setText("");
            nameOfWorkerLabel.setText("");
            locationOfWaterLabel.setText("");
            typeOfWaterLabel.setText("");
            conditionOfWaterLabel.setText("");
        }
    }

    @FXML
    private void handleNewReportPressed() {
        mainApplication.getWaterSourceReportController().setWaterSourceReport(new WaterSourceReport());
        //showWaterSourceReportDetails();
        //mainApplication.getWaterSourceReportController().setProfile();
        mainApplication.displayWaterSourceReportScene();
    }

    @FXML
    private void handleBackToMainMenuPressed() {
        mainApplication.displayMainInApplicationScene();
    }
}
