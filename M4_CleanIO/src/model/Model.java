package model;

import java.util.ArrayList;

/**
 * Created by edwinvillatoro on 9/30/16.
 */
public class Model {

    private static final Model instance = new Model();
    public static Model getInstance() {
        return instance;
    }

    /** Server of project*/
    private Server server;

    /** a list of all the profiles in the server*/
    private final ArrayList<Profile> profiles = new ArrayList<>();

    /** Null Object pattern, returned when no course is found */
    private final Profile theNullProfile = new Profile("No Such Profile", "9999", AccountType.USER);


    /**
     * makes a model with a new server and set a default profile
     */
    private Model () {
        server = new Server();
        server.getProfiles().add(new Profile("user", "password", AccountType.USER));
    }

    /**
     * add a profile to the knows
     *
     * @param profile the profile to add
     * @return true if profile added, false if not added
     */
    public boolean addProfile(Profile profile) {
        return server != null && server.addProfile(profile);
    }

//    /**
//     * returns the server of the application
//     * @return server of application
//     */
    public Server getServer() {
        return server;
    }

    public void setServer(Server newServer) {
        server = newServer;
    }
}
