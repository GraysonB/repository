package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Profile;
import model.WaterSourceReport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_InApplication_Controller {

    /** a link back to the main application class */
    private Main mainApplication;

    /** the profile whose data is being manipulated*/
    private Profile profile;

    @FXML
    private Label welcomeUser;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    /**
     * sets the profile that is logged in
     * @param profile profile that is logged in
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
        welcomeUser.setText("Welcome " + profile.getUsername());
    }


//    /**
//     * called when the user clicks submit water source report
//     */
//    @FXML
//    private void handleSubmitWaterSourceReportPressed() {
//        //mainApplication.getWaterSourceReportController().setProfile(profile);
//
////        mainApplication.getWaterSourceReportController().setWaterSourceReport(new WaterSourceReport());
////        mainApplication.displayWaterSourceReportScene();
//        mainApplication.getWaterSourceReportController().setProfile(profile);
//        mainApplication.displayWaterSourceReportOverviewScene();
//    }

    /**
     * called when the user clicks edit profile
     */
    @FXML
    private void handleEditProfilePressed() {
        mainApplication.getEditProfileController().setProfile(profile);
        mainApplication.displayEditProfileScene();
    }

    /**
     * called when the user clicks logout
     */
    @FXML
    private void handleLogoutPressed() {
        mainApplication.displayWelcomeScene();
    }

    /**
     * called when user clicks View Water Availability
     * should display google map when pressed
     */
    @FXML
    private void handleViewWaterAvailabilityPressed() {
        //TODO
    }

    @FXML
    private void handleSubmitWaterReportPressed() {
        Date yeah = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String date = dateFormatter.format(yeah);
        String time = timeFormatter.format(yeah);
        mainApplication.getWaterSourceReportController().setProfile(profile);
        mainApplication.getWaterSourceReportController().setWaterSourceReport(new WaterSourceReport(date, time));
        //showWaterSourceReportDetails();
        //mainApplication.getWaterSourceReportController().setProfile();
        mainApplication.displayWaterSourceReportScene();
    }

    @FXML
    private void handleViewWaterSourceReportsPressed(){
        mainApplication.displayWaterSourceReportOverviewScene();
    }
}
