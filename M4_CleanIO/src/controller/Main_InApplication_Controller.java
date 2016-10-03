package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import model.Profile;

import java.io.IOException;


public class Main_InApplication_Controller {

    private Main mainApplication;

    private Profile profile;

    @FXML
    private Label welcomeUser;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    /**
     * sets the profile that is logged in
     * @param profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
        welcomeUser.setText("Welcome " + profile.getUsername());
    }

    /**
     * called when the user clicks edit profile
     */
    @FXML
    private void handleEditProfilePressed() throws IOException {
        Profile selectedProfile = profile;
        if (selectedProfile != null) {
            boolean okClicked = mainApplication.showProfileEditDialog(selectedProfile);
            if (okClicked) {
                mainApplication.loadMainInApplication(selectedProfile);
            }
        }
    }

    /**
     * called when the user clicks logout
     */
    @FXML
    public void handleLogoutPressed() {
        mainApplication.displayWelcomeScene();
    }
}
