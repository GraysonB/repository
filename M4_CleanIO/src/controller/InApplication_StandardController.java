package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Created by Edwin on 9/23/2016.
 */
public class InApplication_StandardController {

    private MainFXApplication mainApplication;

    public void setMainApp(MainFXApplication mainFXApplication) {

        mainApplication = mainFXApplication;
    }

    @FXML
    public void logoutOfApplication() {
            mainApplication.getMainScreen().setScene(mainApplication.scene);
    }
}
