package controller;

import fxapp.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by edwinvillatoro on 9/29/16.
 */
public class Register_Controller {
    private Main mainApplication;

    @FXML
    private Button sign_in_button;

    @FXML
    private Button register_cancel_button;

    @FXML
    public void goToLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Login_Screen.fxml"));
        AnchorPane loginScreenLayout = loader.load();
        Stage stage = mainApplication.getWindow();
        // Give the controller access to the main app.
        Login_Controller controller = loader.getController();
        controller.setMainApp(mainApplication);
        Scene scene = new Scene(loginScreenLayout);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToWelcomeScreen() throws IOException {
        mainApplication.start(mainApplication.getWindow());
    }


    public void setMainApp(Main mainFXApplication) {

        mainApplication = mainFXApplication;
    }
}
