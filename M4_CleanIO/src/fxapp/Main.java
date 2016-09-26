package fxapp;

import controller.Welcome_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage window;

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

        Scene scene = new Scene(welcomeScreenLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
