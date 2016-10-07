package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.ConditionOfWater;
import model.TypeOfWater;
import model.WaterSourceReport;

public class Water_Source_Report_Controller {
    /** a link back to the main application class */
    private Main mainApplication;

    /** the water source report whose data is being manipulated*/
    private WaterSourceReport _waterSourceReport;

    @FXML
    private TextField dataField;

    @FXML
    private TextField timeField;

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

    /**
     * called when the user clicks edit profile
     */
    @FXML
    private void handleCancelPressed() {
        mainApplication.displayMainInApplicationScene();
    }
}
