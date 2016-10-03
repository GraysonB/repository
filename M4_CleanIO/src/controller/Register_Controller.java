package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AccountType;
import model.Model;
import model.Profile;

public class Register_Controller {

    private Main mainApplication;

    /** the student whose data is being manipulated*/
    private Profile _profile;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<AccountType> accountTypes;

    private boolean _submitClicked = false;
    
    private Stage _dialogStage;

    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    @FXML
    private void initialize() {
        accountTypes.getItems().setAll(AccountType.values());
        accountTypes.setValue(AccountType.USER);
    }

    @FXML
    public void goToLoginScreen() {
        _dialogStage.close();
        mainApplication.displayLoginScene();
    }

    @FXML
    private void goToWelcomeScreen() {
        _dialogStage.close();
        mainApplication.displayWelcomeScene();
    }
    
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }
    
    public void setProfile(Profile profile) {
        //remember the current profile
        _profile = profile;

        if (_profile == null)
            System.out.println("Profile was null");
        
    }
    
    public boolean isSubmitClicked() {
        return _submitClicked;
    }

    /**
     * Button handler for add profile
     */
    @FXML
    public void submitProfilePressed() {
        _profile.setUsername(usernameField.getText());
        _profile.setPassword(passwordField.getText());
        _profile.setAccountType(accountTypes.getSelectionModel().getSelectedItem());
        //signal success and close this dialog window.
        _submitClicked = true;
        _dialogStage.close();
    }

}
