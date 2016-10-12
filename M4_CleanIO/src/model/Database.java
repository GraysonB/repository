package model;

import java.util.ArrayList;

public class Database {

    /** the list of all registered profiles */
    private final ArrayList<Profile> _profiles;

    /**
     * makes a new server
     */
    public Database() {
        _profiles = new ArrayList<>();
        System.out.println("Database made");
    }

    /**
     * list of profiles in the server
     * @return list of profiles in the server
     */
    public ArrayList<Profile> getProfiles() {
        return _profiles;
    }

    /**
     * adds the requested profile
     * @param profile the profile to add to the server
     * @return true if success, false if profile already in the server
     */
    public boolean addProfile(Profile profile) {
        for (Profile p : _profiles) {
            if (p.getUsername().equals(profile.getUsername())) {
                // found duplicate username
                return false;
            }
        }
        //never found the profile so safe to add it
        _profiles.add(profile);
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
        for (Profile p : _profiles) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                // found duplicate name
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
        for (Profile p : _profiles) {
            if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                // found duplicate username
                return p;
            }
        }

        return null;
    }
}
