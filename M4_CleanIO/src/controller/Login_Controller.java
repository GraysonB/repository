package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Model;
import model.Profile;

/**
 * controller for the login scene
 */
public class Login_Controller {

    /** a link back to the main application class */
    private Main mainApplication;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    /**
     * called when the user clicks cancel
     */
    @FXML
    public void handleCancelPressed() {
        mainApplication.displayWelcomeScene();
    }

    /**
     * called when the user clicks login
     */
    @FXML
    public void handleLoginCleanIOPressed() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (Model.getInstance().getServer().searchProfile(username, password)) {
            Profile profile = Model.getInstance().getServer().getProfile(username, password);
            usernameField.clear();
            passwordField.clear();
            mainApplication.getMainInApplicationController().setProfile(profile);
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

    /**
     * called when the user clicks register
     */
    @FXML
    private void handleRegisterPressed() {
        mainApplication.getRegisterController().setProfile(new Profile());
        mainApplication.displayRegisterScene();
    }
}
