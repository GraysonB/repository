package controller;

import fxapp.Main;
import javafx.fxml.FXML;

public class Main_InApplication_Controller {

    private Main mainApplication;

    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    @FXML
    public void goToWelcomeScene() {
        mainApplication.displayWelcomeScene();
    }
}
