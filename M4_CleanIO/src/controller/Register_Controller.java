package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Register_Controller {
    private Main mainApplication;

    @FXML
    private Button sign_in_button;

    @FXML
    private Button register_cancel_button;

    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    @FXML
    public void goToLoginScreen() {
        mainApplication.displayLoginScene();
    }

    @FXML
    private void goToWelcomeScreen() {
        mainApplication.displayWelcomeScene();
    }
}
