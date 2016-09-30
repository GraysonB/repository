package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by edwinvillatoro on 9/29/16.
 */
public class Profile {

    private final StringProperty _name = new SimpleStringProperty();
    private final StringProperty _password = new SimpleStringProperty();
    private final ObjectProperty<AccountType> _accountType = new SimpleObjectProperty<>();



}
