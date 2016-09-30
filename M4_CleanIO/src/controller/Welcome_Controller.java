package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Welcome_Controller {
    private Main mainApplication;

    @FXML
    Button loginButton;

    @FXML
    Button registerButton;

    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    @FXML
    private void goToLoginScreen() {
        mainApplication.displayLoginScene();
    }

    @FXML
    private void goToRegisterScreen() {
        mainApplication.displayRegisterScene();
    }
}
