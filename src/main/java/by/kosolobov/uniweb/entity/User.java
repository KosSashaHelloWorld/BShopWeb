package by.kosolobov.uniweb.entity;

public class User {
    private final int userId;
    private final String username;
    private final String password;
    private final String firstName;
    private final String secondName;
    private final String serName;

    public User(int userId, String username, String password, String firstName, String secondName, String serName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.serName = serName;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("User{id:%d,username:%s,password:%s}", userId, username, password);
    }
}
