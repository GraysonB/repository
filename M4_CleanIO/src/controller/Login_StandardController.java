package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;

/**
 * Created by Edwin on 9/21/2016.
 */
public class Login_StandardController {
    private MainFXApplication mainApplication;

    @FXML
    private TextField username_log;


    @FXML
    private PasswordField password_log;

    public void setMainApp(MainFXApplication mainFXApplication) {

        mainApplication = mainFXApplication;
    }

    @FXML
    public void loginCleanIOPressed() {
        if (username_log.getText().equals("user") && password_log.getText().equals("password")) {
            username_log.clear();
            password_log.clear();
            mainApplication.showInApplication_Standard();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApplication.getMainScreen());
            alert.setTitle("Error");
            alert.setHeaderText("wrong username or password");
            //alert.setContentText("wrong username or password");

            alert.showAndWait();
        }

    }



}
