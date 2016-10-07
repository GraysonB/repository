package model;

public enum AccountType {
    USER("User"),
    WORKER("Worker"),
    MANAGER("Manager"),
    ADMIN("Admin");

    private final String type;

    AccountType (String s) {
        type = s;
    }

    public String toString() {
        return type;
    }
}
