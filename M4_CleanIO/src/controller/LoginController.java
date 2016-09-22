package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by Edwin on 9/21/2016.
 */
public class LoginController {

    private MainFXApplication mainApplication;

    @FXML
    private TextField username_log;

    @FXML
    private PasswordField password_log;

    public void setMainApp(MainFXApplication mainFXApplication) {

        mainApplication = mainFXApplication;
    }
}
