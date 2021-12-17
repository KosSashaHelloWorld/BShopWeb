package by.kosolobov.uniweb.entity;

import java.util.List;

public class Barber extends User{
    private final String firstName;
    private final String secondName;
    private final String serName;
    private final String description;
    private final List<Service> services;

    public Barber(int userId,
                  String username,
                  String password,
                  String firstName,
                  String secondName,
                  String serName,
                  String description,
                  List<Service> services) {
        super(userId, username, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.serName = serName;
        this.description = description;
        this.services = services;
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

    public List<Service> getServices() {
        return services;
    }
}
