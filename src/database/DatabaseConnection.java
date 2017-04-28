package database;

import hospitalsystem.Strings;
import hospitalsystem.Tools;
import hospitalsystem.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DatabaseConnection {

    private final String databaseName;
    private Connection connection;
    private Statement statement;
    private boolean connected;

    public DatabaseConnection(String databaseName) {
        this.databaseName = databaseName;
        createConnection();
    }

    private void createConnection() {
        try {
            Class.forName(Strings.DATABASE_CONNECTION);
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            connected = false;
            Tools.error("Could not connect to database!");
        }
        connected = true;
        createUserTables();
    }

    private void createUserTables() {
        if (connected) {
            String sql1 = "CREATE TABLE IF NOT EXISTS " + Strings.USERS_TABLE_NAME + " ("
                    + Strings.STAFF_ID + " VARCHAR(100) PRIMARY KEY,"
                    + Strings.FIRST_NAME + " TEXT,"
                    + Strings.LAST_NAME + " TEXT,"
                    + Strings.EMAIL + " TEXT,"
                    + Strings.DESIGNATION + " TEXT,"
                    + Strings.USERNAME + " TEXT,"
                    + Strings.PASSWORD + " TEXT);";
            execute(sql1);

            if (getRowCount(Strings.USERS_TABLE_NAME) == 0) {
                createDefaultAdmin();
            }
        }
    }

    private void createDefaultAdmin() {
        String sql = "INSERT INTO " + Strings.USERS_TABLE_NAME + " VALUES ("
                + "'admin',"
                + "'admin',"
                + "'admin',"
                + "'admin@admin.com',"
                + "'" + User.Type.ADMINISTRATOR.toString() + "',"
                + "'admin',"
                + "'admin');";
        execute(sql);
    }

    public boolean execute(String sql, String errorMessage) {
        try {
            statement.execute(sql);
            return true;
        } catch (Exception e) {
            Tools.error(errorMessage);
            return false;
        }
    }

    public boolean execute(String sql) {
        try {
            statement.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ResultSet executeQuery(String sql, String errorMessage) {
        try {
            return statement.executeQuery(sql);
        } catch (Exception e) {
            Tools.error(errorMessage);
            return null;
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public int getRowCount(String table) {
        String sql = "SELECT COUNT(*) FROM " + table + ";";
        ResultSet set = executeQuery(sql);
        try {
            if (set.next()) {
                return set.getInt(1);
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}
