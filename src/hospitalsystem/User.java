package hospitalsystem;

/**
 *
 * @author Moses Muigai Gitau
 */
public class User {

    private String staff_id;
    private String firstName;
    private String lastName;
    private String email;
    private String designation;
    private String username;
    private String password;

    public User() {

    }

    public User(String staff_id, String firstName, String lastName, String email, String designation, String username, String password) {
        this.designation = designation;
        this.username = username;
        this.password = password;
        this.staff_id = staff_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getStaffId() {
        return staff_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDesignation() {
        return designation;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setStaffId(String staffId) {
        this.staff_id = staffId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "(" + Strings.STAFF_ID + " : " + staff_id + " , "
                + Strings.FIRST_NAME + " : " + firstName + " , "
                + Strings.LAST_NAME + " : " + lastName + " , "
                + Strings.EMAIL + " : " + email + " , "
                + Strings.DESIGNATION + " : " + designation + " , "
                + Strings.USERNAME + " : " + username + " , "
                + Strings.PASSWORD + " : " + password + ")";
    }

    public static enum Type {

        ADMINISTRATOR,
        IMPATIENT_STAFF,
        OUTPATIENT_STAFF,
        CASHIER,
        RECEPTIONIST
    }
}
