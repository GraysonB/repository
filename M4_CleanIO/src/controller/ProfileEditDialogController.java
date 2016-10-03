package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Profile;

/**
 * dialog to edit details of a profile
 */
public class ProfileEditDialogController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField accountTypeField;


    private Stage dialogStage;
    private Profile profile;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the profile to be edited in the dialog.
     *
     * @param profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;

        firstNameField.setText(profile.getFirstName());
        lastNameField.setText(profile.getLastName());
        passwordField.setText(profile.getPassword());

//        streetField.setText(profile.getStreet());
//        postalCodeField.setText(Integer.toString(profile.getPostalCode()));
//        cityField.setText(profile.getCity());
        accountTypeField.setText(profile.getAccountType().toString());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        //if (isInputValid()) {
            profile.setFirstName(firstNameField.getText());
            profile.setLastName(lastNameField.getText());
            profile.setPassword(passwordField.getText());
            //profile.setStreet(streetField.getText());
            //profile.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            //profile.setCity(cityField.getText());
            //Set a default USER type
            //profile.setAccountType(AccountType.USER);

            okClicked = true;
            dialogStage.close();
        //}
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
//    private boolean isInputValid() {
//        String errorMessage = "";
//
//        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
//            errorMessage += "No valid first name!\n";
//        }
//        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
//            errorMessage += "No valid last name!\n";
//        }
//        if (streetField.getText() == null || streetField.getText().length() == 0) {
//            errorMessage += "No valid street!\n";
//        }
//
//        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//            errorMessage += "No valid postal code!\n";
//        } else {
//            // try to parse the postal code into an int.
//            try {
//                Integer.parseInt(postalCodeField.getText());
//            } catch (NumberFormatException e) {
//                errorMessage += "No valid postal code (must be an integer)!\n";
//            }
//        }
//
//        if (cityField.getText() == null || cityField.getText().length() == 0) {
//            errorMessage += "No valid city!\n";
//        }
//
//        if (accountTypeField.getText() == null || accountTypeField.getText().length() == 0) {
//            errorMessage += "No valid account type!\n";
//        }
//
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            // Show the error message.
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.initOwner(dialogStage);
//            alert.setTitle("Invalid Fields");
//            alert.setHeaderText("Please correct invalid fields");
//            alert.setContentText(errorMessage);
//
//            alert.showAndWait();
//
//            return false;
//        }
//    }
}