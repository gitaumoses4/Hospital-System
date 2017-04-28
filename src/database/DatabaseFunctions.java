package database;

import hospitalsystem.Strings;
import hospitalsystem.User;
import java.sql.ResultSet;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DatabaseFunctions {

    private static final DatabaseConnection db = new DatabaseConnection(Strings.DATABAES_NAME);

    public static boolean addUser(User user) {
        String query = "INSERT INTO " + Strings.USERS_TABLE_NAME + " VALUES ("
                + user.getStaffId() + ","
                + user.getFirstName() + ","
                + user.getLastName() + ","
                + user.getEmail() + ","
                + user.getDesignation() + ","
                + user.getUsername() + ","
                + user.getPassword() + ");";
        return db.execute(query);
    }

    public static boolean userExists(String staffId) {
        return getUser(staffId) != null;
    }

    public static User getUser(String staffId) {
        String query = "SELECT * FROM " + Strings.USERS_TABLE_NAME + " WHERE " + Strings.STAFF_ID + " = '" + staffId + "';";
        ResultSet values = db.executeQuery(query);
        if (values == null) {
            return null;
        } else {
            try {
                User user = new User();
                while (values.next()) {
                    user.setStaffId(values.getString(Strings.STAFF_ID));
                    user.setFirstName(values.getString(Strings.FIRST_NAME));
                    user.setLastName(values.getString(Strings.LAST_NAME));
                    user.setEmail(values.getString(Strings.EMAIL));
                    user.setDesignation(values.getString(Strings.DESIGNATION));
                    user.setUsername(values.getString(Strings.USERNAME));
                    user.setPassword(values.getString(Strings.PASSWORD));
                    return user;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static void printAllUsers() {
        String sql = "SELECT " + Strings.STAFF_ID + " FROM " + Strings.USERS_TABLE_NAME + ";";
        ResultSet result = db.executeQuery(sql);
        if (result != null) {
            try {
                while (result.next()) {
                    System.out.println(getUser(result.getString(1)));
                }
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        printAllUsers();
    }
}
