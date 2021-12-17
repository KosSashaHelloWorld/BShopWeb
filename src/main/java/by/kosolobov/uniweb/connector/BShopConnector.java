package by.kosolobov.uniweb.connector;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import static by.kosolobov.uniweb.container.DataBaseStringContainer.*;

public class BShopConnector {
    private static final Logger log = LogManager.getLogger(BShopConnector.class);

    private static final ReentrantLock locker = new ReentrantLock();

    private static Connection connection;
    private static Statement statement;
    private static ResultSet columns;
    private static ResultSet result;

    private BShopConnector() {
    }

    public static List<Map<String, String>> getAllEntityFromTable(String tableName) {
        locker.lock();

        List<Map<String, String>> entities = new ArrayList<>();
        Map<String, String> entityMap = new HashMap<>();
        List<String> columnNames = new ArrayList<>();

        String columnsQuery = """
                SELECT COLUMN_NAME
                FROM INFORMATION_SCHEMA.COLUMNS
                WHERE TABLE_NAME = '%s';""".formatted(tableName);

        String mainQuery = """
                SELECT *
                FROM %s;""".formatted(tableName);

        try {
            connection = DriverManager.getConnection(ROOT_URL, ROOT_USER, ROOT_PASSWORD);
            statement = connection.createStatement();

            statement.executeQuery("USE %s".formatted(DBNAME));

            columns = statement.executeQuery(columnsQuery);

            while (columns.next()) {
                columnNames.add(columns.getString(1));
            }

            result = statement.executeQuery(mainQuery);

            while (result.next()) {
                for (int i = 0; i < columnNames.size(); i++) {
                    entityMap.put(columnNames.get(i), result.getString(i + 1));
                }
                entities.add(entityMap);
            }
        } catch (SQLException e) {
            log.log(Level.ERROR, "Error executing query: {}", e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                columns.close();
                result.close();
            } catch (SQLException e) {
                log.log(Level.ERROR, "Impossible to close connection: {}", e.getMessage());
            }

        }

        locker.unlock();
        return entities;
    }
}