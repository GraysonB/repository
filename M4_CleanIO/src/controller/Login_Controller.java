package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Model;
import model.Profile;

import java.io.IOException;

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
    public void handleLoginCleanIOPressed() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (Model.getInstance().getServer().searchProfile(username, password)) {
            Profile profile = Model.getInstance().getServer().getProfile(username, password);
            usernameField.clear();
            passwordField.clear();
            mainApplication.loadMainInApplication(profile);
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
    private void handleRegisterPressed() throws IOException {
        Profile tempProfile = new Profile();
        boolean submitClicked = mainApplication.loadRegisterScene(tempProfile);
        if (submitClicked) {
            if (!Model.getInstance().addProfile(tempProfile)) {
                //if the add fails, notify the user
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApplication.getWindow());
                alert.setTitle("Profile Not Added");
                alert.setHeaderText("Bad Profile Add");
                alert.setContentText("Profile was not added, check that they are not already in server!");

                alert.showAndWait();
            } else {
                System.out.println(tempProfile + " added to server");
                mainApplication.loadMainInApplication(tempProfile);
            }
        }
    }
}
