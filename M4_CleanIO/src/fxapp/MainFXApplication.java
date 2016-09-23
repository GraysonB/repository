package fxapp;


import controller.InApplication_StandardController;
import controller.Login_StandardController;
import controller.Login_StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Main application class.  Some code reused from the code makery tutorial
 *
 * This class handles all the scene switching to reuse the main stage.
 *
 */
public class MainFXApplication extends Application {
    /**  the java logger for this class */
    private static final Logger LOGGER =Logger.getLogger("MainFXApplication");

    /** the main container for the application window */
    private Stage mainScreen;

    public Scene scene;

//    /** the main layout for the main window */
//    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        mainScreen = primaryStage;
        initRootLayout();
        //showCourseOverview(mainScreen);
    }

    /**
     * return a reference to the main window stage
     * @return reference to main stage
     * */
    public Stage getMainScreen() { return mainScreen;}


    /**
     * Initialize the main screen for the application.  Most other views will be shown in this screen.
     *
     */
    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/Login_Standard.fxml"));
            AnchorPane mainScreenLayout = loader.load();

            // Give the controller access to the main app.
            Login_StandardController controller = loader.getController();
            controller.setMainApp(this);

            // Set the Main App title
            mainScreen.setTitle("Clean IO");

            // Show the scene containing the root layout.
            Scene scene = new Scene(mainScreenLayout);
            this.scene = scene;
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for MainScreen!!");
            e.printStackTrace();
        }
    }


    public void showInApplication_Standard() {
        try {
            // Load course overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/InApplication_Standard.fxml"));
            AnchorPane courseOverview = loader.load();

            // Give the controller access to the main app.
            InApplication_StandardController controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(courseOverview);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for CourseOverview!!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
