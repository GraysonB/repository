package model;

import java.util.ArrayList;

public class Model {

    private static final Model instance = new Model();
    public static Model getInstance() {
        return instance;
    }

    /** Server of project*/
    private Server server;

    /** a list of all the profiles in the server*/
    private final ArrayList<Profile> profiles = new ArrayList<>();

    /** Null Object pattern, returned when no profile is found */
    private final Profile theNullProfile = new Profile("No Such Profile", "9999", AccountType.USER);


    private Model () {
        server = new Server();
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

    public Server getServer() {
        return server;
    }

    public void setServer(Server newServer) {
        server = newServer;
    }
}
