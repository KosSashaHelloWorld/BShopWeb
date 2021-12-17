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

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        List<Map<String, String>> userMaps = BShopConnector.getAllEntityFromTable(USER_TABLE);

        for (Map<String, String> userMap : userMaps) {
            int userId = Integer.parseInt(userMap.get(USER_ID));
            String username = userMap.get(USERNAME);
            String password = userMap.get(PASSWORD);
            users.add(new User(userId, username, password));
        }

        return users;
    }
}
