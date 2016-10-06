package model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by edwinvillatoro on 9/29/16.
 */
public class Profile {

    private final StringProperty _firstName = new SimpleStringProperty();
    private final StringProperty _username = new SimpleStringProperty();
    private final StringProperty _lastName = new SimpleStringProperty();
    private final StringProperty _password = new SimpleStringProperty();
    private final ObjectProperty<AccountType> _accountType = new SimpleObjectProperty<>();

    public static ObservableList<AccountType> getAccountTypes() {
        ObservableList<AccountType> list = FXCollections.observableArrayList(AccountType.values());
        return list;
    }


    public String getUsername() {
        return _username.get();
    }

    public void setUsername(String username) {
        _username.set(username);
    }

    public String getFirstName() {
        return _firstName.get();
    }

    public void setFirstName(String name) {
        _firstName.set(name);
    }

    public String getLastName() {
        return _lastName.get();
    }

    public void setLastName(String lastName) {
        _lastName.set(lastName);
    }

    public String getPassword() {
        return _password.get();
    }

    public void setPassword(String password) {
        _password.set(password);
    }

    public AccountType getAccountType() {
        return _accountType.get();
    }

    public void setAccountType(AccountType accountType) {
        _accountType.set(accountType);
    }

    /**
     * makes a new profile
     * @param username username of profile
     * @param password password of profile
     * @param accountType account type of profile
     */
    public Profile (String username, String password, AccountType accountType) {
        _username.set(username);
        _password.set(password);
        _accountType.set(accountType);
    }

    /**
     * makes an empty profile
     */
    public Profile() {

    }

    /**
     * returns a string representation of Profile
     * @return string representation of Profile
     */
    public String toString() {
        return _username.get() + " " + _password.get() + " " + _accountType.get();
    }
}
