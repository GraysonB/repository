package fxapp;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Profile;

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


    /**
     * lmao?
     * @param primaryStage
     * @throws IOException
     */
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
        //loadRegisterScene(new Profile());
        //loadMainInApplication();
    }

    /**
     * displays welcome screen
     */
    public void displayWelcomeScene() {
        window.setScene(welcomeScene);
        window.show();
    }

    /**
     * loads login scene
     * @throws IOException
     */
    private void loadLoginScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Login_Screen.fxml"));
        AnchorPane loginScreenLayout = loader.load();

        // Give the controller access to the main app.
        Login_Controller controller = loader.getController();
        controller.setMainApp(this);

        loginScene = new Scene(loginScreenLayout);
    }

    /**
     * displays login scene
     */
    public void displayLoginScene() {
        window.setScene(loginScene);
        window.show();
    }

    /**
     * loads a register scene
     * @param profile profile to be manipulated
     * @return true if submit button was clicked, otherwise false
     * @throws IOException thrown if file not found
     */
    public boolean loadRegisterScene(Profile profile) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Register_Screen.fxml"));
        AnchorPane registerScreenLayout = loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add Profile");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(window);
        Scene scene = new Scene(registerScreenLayout);
        dialogStage.setScene(scene);

        // Set the person into the controller.
        Register_Controller controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setProfile(profile);
        controller.setMainApp(this);

        dialogStage.showAndWait();

        return controller.isSubmitClicked();
    }

        // default stuff
//        // Give the controller access to the main app.
//        Register_Controller controller = loader.getController();
//        controller.setMainApp(this);
//        registerScene = new Scene(registerScreenLayout);
//        window.setScene(registerScene);
//
//        controller.setProfile(profile);
//        window.show();

//    public void displayRegisterScene(Profile profile) throws IOException {
//        loadRegisterScene(profile);
//        window.setScene(registerScene);
//        window.show();
//    }

    /**
     * loads the main page of the main application
     * @param profile profile that is logged in
     * @throws IOException thrown when file not found
     */
    public void loadMainInApplication(Profile profile) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Main_InApplication_Screen.fxml"));
        AnchorPane mainInApplicationScreenLayout = loader.load();

        // Give the controller access to the main app.
        Main_InApplication_Controller controller = loader.getController();
        controller.setMainApp(this);
        controller.setProfile(profile);
        mainInApplicationScene = new Scene(mainInApplicationScreenLayout);
        window.setScene(mainInApplicationScene);
        window.show();

    }

    /**
     * shows the profile edit dialog
     * @param profile profile to be manipulated
     * @return true if okay button is pressed
     */
    public boolean showProfileEditDialog(Profile profile) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/ProfileEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Profile");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(window);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the profile into the controller.
            ProfileEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProfile(profile);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public void displayMainInApplicationScene() {
//        window.setScene(mainInApplicationScene);
//        window.show();
//    }
}