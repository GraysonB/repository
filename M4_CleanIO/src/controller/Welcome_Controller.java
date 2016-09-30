package controller;

/**
 * Created by Edwin on 9/26/2016.
 */

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Welcome_Controller {
    private Main mainApplication;

    @FXML
    Button loginButton;

    @FXML
    Button registerButton;

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
    public void goToRegisterScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Register_Screen.fxml"));
        AnchorPane registerScreenLayout = loader.load();
        Stage stage = mainApplication.getWindow();
        // Give the controller access to the main app.
        Register_Controller controller = loader.getController();
        controller.setMainApp(mainApplication);
        Scene scene = new Scene(registerScreenLayout);
        stage.setScene(scene);
        stage.show();
    }

    public void setMainApp(Main mainFXApplication) {

        mainApplication = mainFXApplication;
    }
}

