package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Model {

    private static final Model instance = new Model();
    public static Model getInstance() {
        return instance;
    }

    /** Server of project*/
    private Database server;

    /** a list of all the profiles in the server*/
    private final ArrayList<Profile> profiles = new ArrayList<>();

    /** a list of all the water source reports*/
    private final ObservableList<WaterSourceReport> waterSourceReports = FXCollections.observableArrayList();

    /** Null Object pattern, returned when no profile is found */
    private final Profile theNullProfile = new Profile("No Such Profile", "9999", AccountType.USER);


    public ObservableList<WaterSourceReport> getWaterSourceReports() {
        return waterSourceReports;
    }

    private Model () {
        server = new Database();
        // default user to use to test
        server.getProfiles().add(new Profile("user", "password", AccountType.USER));
    }

    /**
     * add a profile to the server
     *
     * @param profile the profile to add
     * @return true if profile added, false if not added
     */
    public boolean addProfile(Profile profile) {
        return server != null && server.addProfile(profile);
    }

    public Database getServer() {
        return server;
    }

    public void setServer(Database newServer) {
        server = newServer;
    }
}
