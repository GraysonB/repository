package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {

    /** the list of all registered profiles for this database */
    private final ObservableList<Profile> profiles = FXCollections.observableArrayList();

    /** a list of all the water source reports*/
    private final ObservableList<WaterSourceReport> waterSourceReports = FXCollections.observableArrayList();

    /** a list of all the water purity reports*/
    private final ObservableList<WaterPurityReport> waterPurityReports = FXCollections.observableArrayList();

    /**
     * makes a new server
     */
    public Database() {
        System.out.println("Database made");
    }

    /**
     * adds the requested profile
     * @param profile the profile to add to the database
     * @return true if success, false if profile already in the database
     */
    public boolean addProfile(Profile profile) {
        for (Profile p : profiles) {
            if (p.getUsername().equals(profile.getUsername())) {
                // found duplicate username
                return false;
            }
        }
        //never found the profile so safe to add it
        profiles.add(profile);
        //return the success signal
        return true;
    }

    /**
     * adds the requested water source report
     * @param waterSourceReport the water source report to add to the database
     * @return true if success, false if water source report already in the database
     */
    public boolean addWaterSourceReport(WaterSourceReport waterSourceReport) {
        for (WaterSourceReport p : waterSourceReports) {
            if (p.getLatitude().equals(waterSourceReport.getLatitude()) && p.getLongitude().equals(waterSourceReport.getLongitude())) {
                // found duplicate username
                return false;
            }
        }
        //never found the profile so safe to add it
        waterSourceReports.add(waterSourceReport);
        //return the success signal
        return true;
    }

    /**
     * adds the requested water purity report
     * @param waterPurityReport the water purity report to add to the database
     * @return true if success, false if profile already in the database
     */
    public boolean addWaterPurityReport(WaterPurityReport waterPurityReport) {
        for (WaterPurityReport p : waterPurityReports) {
            if (p.getLatitude().equals(waterPurityReport.getLatitude()) && p.getLongitude().equals(waterPurityReport.getLongitude())) {
                // found duplicate username
                return false;
            }
        }
        //never found the profile so safe to add it
        waterPurityReports.add(waterPurityReport);
        //return the success signal
        return true;
    }

    /**
     * looks for the requested profile with the matching username and password
     * used for login
     * @param username username of profile
     * @param password password of profile
     * @return true if profile is in server, false otherwise
     */
    public boolean searchProfile(String username, String password) {
        for (Profile p : profiles) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                // found duplicate name
                return true;
            }
        }
        //never found the profile in the server
        return false;
    }

    /**
     * looks for the requested profile with the matching username and password
     * used for login
     * @param username username of profile
     * @param password password of profile
     * @return true if profile is in server, false otherwise
     */
    public boolean removeProfile(String username, String password) {
        for (Profile p : profiles) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                // found duplicate name
                profiles.remove(p);
                return true;
            }
        }
        //never found the profile in the server
        return false;
    }

    /**
     * returns the profile with the same username and password
     * @param username username of profile
     * @param password password of profile
     * @return returns the profile if there is a matching username and password, false otherwise
     */
    public Profile getProfile(String username, String password) {
        for (Profile p : profiles) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                // found duplicate username
                return p;
            }
        }
        return null;
    }

    /**
     * list of profiles in the database
     * @return list of profiles in the database
     */
    public ObservableList<Profile> getProfiles() {
        return profiles;
    }

    public ObservableList<WaterSourceReport> getWaterSourceReports() {
        return waterSourceReports;
    }

    public ObservableList<WaterPurityReport> getWaterPurityReports() {
        return waterPurityReports;
    }

}
