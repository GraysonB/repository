package fxapp;

import controller.Login_Controller;
import controller.Main_InApplication_Controller;
import controller.Register_Controller;
import controller.Welcome_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage window;

    private Scene welcomeScene;

    private Scene loginScene;

    private Scene registerScene;

    private Scene mainInApplicationScene;

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getWindow() {
        return window;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        primaryStage.setTitle("Clean.IO");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Welcome_Screen.fxml"));
        BorderPane welcomeScreenLayout = loader.load();

        // Give the controller access to the main app.
        Welcome_Controller controller = loader.getController();
        controller.setMainApp(this);

        welcomeScene = new Scene(welcomeScreenLayout);
        displayWelcomeScene();
        loadLoginScene();
        loadRegisterScene();
        loadMainInApplication();
    }

    public void displayWelcomeScene() {
        window.setScene(welcomeScene);
        window.show();
    }

    private void loadLoginScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Login_Screen.fxml"));
        AnchorPane loginScreenLayout = loader.load();

        // Give the controller access to the main app.
        Login_Controller controller = loader.getController();
        controller.setMainApp(this);

        loginScene = new Scene(loginScreenLayout);
    }

    public void displayLoginScene() {
        window.setScene(loginScene);
        window.show();
    }

    private void loadRegisterScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Register_Screen.fxml"));
        AnchorPane registerScreenLayout = loader.load();

        // Give the controller access to the main app.
        Register_Controller controller = loader.getController();
        controller.setMainApp(this);

        registerScene = new Scene(registerScreenLayout);
    }

    public void displayRegisterScene() {
        window.setScene(registerScene);
        window.show();
    }

    private void loadMainInApplication() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Main_InApplication_Screen.fxml"));
        AnchorPane mainInApplicationScreenLayout = loader.load();

        // Give the controller access to the main app.
        Main_InApplication_Controller controller = loader.getController();
        controller.setMainApp(this);
        mainInApplicationScene = new Scene(mainInApplicationScreenLayout);
    }

    public void displayMainInApplicationScene() {
        window.setScene(mainInApplicationScene);
        window.show();
    }
}