package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Profile {

    private final StringProperty _firstName = new SimpleStringProperty();
    private final StringProperty _username = new SimpleStringProperty();
    private final StringProperty _lastName = new SimpleStringProperty();
    private final StringProperty _password = new SimpleStringProperty();
    private final ObjectProperty<AccountType> _accountType = new SimpleObjectProperty<>();

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
     * @param username profile's username
     * @param password profile's password
     * @param accountType profile's account type
     */
    public Profile (String username, String password, AccountType accountType) {
        _username.set(username);
        _password.set(password);
        _accountType.set(accountType);
    }

    public Profile() {

    }

    public String toString() {
        return _username.get() + " " + _password.get() + " " + _accountType.get();
    }
}
