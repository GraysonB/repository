package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Edwin on 9/21/2016.
 */
public class Login_Controller {
    private Main mainApplication;

    @FXML
    private TextField username_log;

    @FXML
    private PasswordField password_log;

    @FXML
    private Button login_CleanIO;

    @FXML
    public void goBackToWelcome() throws IOException {
        mainApplication.start(mainApplication.getWindow());
    }

    @FXML
    public void loginCleanIOPressed() throws IOException{
        if (username_log.getText().equals("user") && password_log.getText().equals("password")) {
            username_log.clear();
            password_log.clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/Main_InApplication_Screen.fxml"));
            AnchorPane mainInApplicationScreenLayout = loader.load();
            Stage stage = mainApplication.getWindow();
            // Give the controller access to the main app.
            Main_InApplication_Controller controller = loader.getController();
            controller.setMainApp(mainApplication);
            Scene scene = new Scene(mainInApplicationScreenLayout);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            Stage stage =(Stage) login_CleanIO.getScene().getWindow();
            alert.initOwner(stage);
            alert.setTitle("Error");
            alert.setHeaderText("wrong username or password");
            //alert.setContentText("wrong username or password");

            alert.showAndWait();
        }
    }

    public void setMainApp(Main mainFXApplication) {

        mainApplication = mainFXApplication;
    }
}