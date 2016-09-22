package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;

/**
 * Created by Edwin on 9/21/2016.
 */
public class Login_StartController {

    private MainFXApplication mainApplication;

    public void setMainApp(MainFXApplication mainFXApplication) {

        mainApplication = mainFXApplication;
    }

    @FXML
    public void loginCleanIOPressed() {
        mainApplication.showInputLoginInfo();
    }
}
