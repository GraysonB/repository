package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.AccountType;
import model.Model;
import model.Profile;

/**
 * controller for the register scene
 */
public class Register_Controller {

    /** a link back to the main application class */
    private Main mainApplication;

    /** the profile whose data is being manipulated*/
    private Profile _profile;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<AccountType> accountTypes;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    /**
     * sets the combobox with account types
     */
    @FXML
    private void initialize() {
        accountTypes.getItems().setAll(AccountType.values());
        accountTypes.setValue(AccountType.USER);
    }

    /**
     * called when the user clicks login
     */
    @FXML
    public void handleLoginPressed() {
        mainApplication.displayLoginScene();
    }

    /**
     * called when the user clicks cancel
     */
    @FXML
    private void handleCancelPressed() {
        mainApplication.displayWelcomeScene();
    }

    /**
     * sets the profile who will try to register
     * @param profile profile who will try to register
     */
    public void setProfile(Profile profile) {
        //remember the current profile
        _profile = profile;

        if (_profile == null)
            System.out.println("Profile was null");
        
    }

    /**
     * called when the user clicks submit
     */
    @FXML
    public void handleSubmitPressed() {
        _profile.setUsername(usernameField.getText());
        _profile.setPassword(passwordField.getText());
        _profile.setAccountType(accountTypes.getSelectionModel().getSelectedItem());

        if (!Model.getInstance().addProfile(_profile)) {
            //if the add fails, notify the user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApplication.getWindow());
            alert.setTitle("Profile Not Added");
            alert.setHeaderText("Bad Profile Add");
            alert.setContentText("Profile was not added, check that they are not already in server!");

            alert.showAndWait();
        } else {
            System.out.println(_profile + " added to server");
            mainApplication.getMainInApplicationController().setProfile(_profile);
            mainApplication.displayMainInApplicationScene();
        }
    }

}
