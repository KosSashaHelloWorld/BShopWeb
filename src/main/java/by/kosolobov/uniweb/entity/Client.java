package by.kosolobov.uniweb.entity;

public class Client extends User {
    private final String firstName;
    private final String secondName;
    private final String serName;
    private final String description;

    public Client(int userId, String username, String password, String firstName, String secondName, String serName, String description) {
        super(userId, username, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.serName = serName;
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSerName() {
        return serName;
    }

    public String getDescription() {
        return description;
    }
}
