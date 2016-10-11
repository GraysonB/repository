package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.*;

public class Water_Source_Report_Controller {

    private static int reportNumber = 1;

    /** a link back to the main application class */
    private Main mainApplication;

    /** the water source report whose data is being manipulated*/
    private WaterSourceReport waterSourceReport;

    /** the profile who is submitting the report*/
    //private Profile profile;

    @FXML
    private TextField dateField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField reportNumberField;

    @FXML
    private TextField nameOfWorkerField;

    @FXML
    private TextField locationOfWaterField;

    @FXML
    private ComboBox<TypeOfWater> typeOfWaterBox;

    @FXML
    private ComboBox<ConditionOfWater> conditionOfWaterBox;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

//    /**
//     * sets the profile that is submitting the report
//     * @param profile profile that is logged in
//     */
//    public void setProfile(Profile profile) {
//        this.profile = profile;
//    }

    public void setWaterSourceReport(WaterSourceReport waterSourceReport) {
        this.waterSourceReport = waterSourceReport;
        waterSourceReport.setDate("10/10/2016");
        waterSourceReport.setTime("4:20 blaze it");
        //waterSourceReport.setNameOfReporter(profile.getUsername());
        waterSourceReport.setReportNumber(reportNumber);

        dateField.setText(waterSourceReport.getDate());
        timeField.setText(waterSourceReport.getTime());
        reportNumberField.setText(waterSourceReport.getReportNumber() + "");
        nameOfWorkerField.setText("name");
        locationOfWaterField.setText("");
    }

    /**
     * sets the combobox with account types
     */
    @FXML
    private void initialize() {
        typeOfWaterBox.getItems().setAll(TypeOfWater.values());
        typeOfWaterBox.setValue(TypeOfWater.Bottled);

        conditionOfWaterBox.getItems().setAll(ConditionOfWater.values());
        conditionOfWaterBox.setValue(ConditionOfWater.Potable);
    }

    /**
     * called when the user clicks submit
     */
    @FXML
    private void handleSubmitPressed() {
        waterSourceReport.setLocation(locationOfWaterField.getText());
        waterSourceReport.setTypeOfWater(typeOfWaterBox.getSelectionModel().getSelectedItem());
        waterSourceReport.setConditionOfWater(conditionOfWaterBox.getSelectionModel().getSelectedItem());
        Model.getInstance().getWaterSourceReports().add(waterSourceReport);
        reportNumber++;
        mainApplication.displayMainInApplicationScene();
    }

    /**
     * called when the user clicks edit profile
     */
    @FXML
    private void handleCancelPressed() {
        mainApplication.displayMainInApplicationScene();
    }
}
