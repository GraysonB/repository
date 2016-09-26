package controller;

import fxapp.Main;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by Edwin on 9/26/2016.
 */
public class Main_InApplication_Controller {

    private Main mainApplication;

    public void setMainApp(Main mainFXApplication) {

        mainApplication = mainFXApplication;
    }

    @FXML
    public void logoutOfApplication() throws IOException{
        mainApplication.start(mainApplication.getWindow());
    }
}
