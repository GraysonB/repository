package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login_Controller {

    private Main mainApplication;

    @FXML
    private TextField username_log;

    @FXML
    private PasswordField password_log;

    @FXML
    private Button login_CleanIO;

    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    @FXML
    public void goToWelcomeScene() {
        mainApplication.displayWelcomeScene();
    }

    @FXML
    public void loginCleanIOPressed() {
        if (username_log.getText().equals("user") && password_log.getText().equals("password")) {
            username_log.clear();
            password_log.clear();
            mainApplication.displayMainInApplicationScene();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            Stage stage = mainApplication.getWindow();
            alert.initOwner(stage);
            alert.setTitle("Error");
            alert.setHeaderText("wrong username or password");
            //alert.setContentText("wrong username or password");

            alert.showAndWait();
        }
    }
}
