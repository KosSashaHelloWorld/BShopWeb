package by.kosolobov.uniweb.service;

import by.kosolobov.uniweb.connector.BShopConnector;
import by.kosolobov.uniweb.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static by.kosolobov.uniweb.container.DataBaseStringContainer.USER_TABLE;

public class UserService {
    private static final String USER_ID = "user_id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first_name";
    private static final String SECOND_NAME = "second_name";
    private static final String SER_NAME = "ser_name";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        List<Map<String, String>> userMaps = BShopConnector.getAllEntityFromTable(USER_TABLE);

        for (Map<String, String> userMap : userMaps) {
            int userId = Integer.parseInt(userMap.get(USER_ID));
            String username = userMap.get(USERNAME);
            String password = userMap.get(PASSWORD);
            String firstName = userMap.get(FIRST_NAME);
            String secondName = userMap.get(SECOND_NAME);
            String serName = userMap.get(SER_NAME);
            users.add(new User(userId, username, password, firstName, secondName, serName));
        }

        return users;
    }
}
