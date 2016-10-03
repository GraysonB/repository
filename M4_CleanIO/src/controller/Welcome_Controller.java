package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Model;
import model.Profile;

import java.io.IOException;

public class Welcome_Controller {

    /** a link back to the main application class */
    private Main mainApplication;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    /**
     * called when the user clicks login
     */
    @FXML
    private void handleLoginPressed() {
        mainApplication.displayLoginScene();
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
