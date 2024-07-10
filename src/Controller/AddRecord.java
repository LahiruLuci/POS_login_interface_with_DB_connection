
package Controller;

import Model.DBConnection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AddRecord {

    public static boolean addRecord(String name, String email, String phone, String username, String password, String cpassword) {
        if (isEmpty(name) || isEmpty(email) || isEmpty(phone) || isEmpty(username) || isEmpty(password) || isEmpty(cpassword)) {
            JOptionPane.showMessageDialog(null, "Empty fields detected. Please fill out all required information.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (!password.equals(cpassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match. Please re-enter password and confirm password.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        try {
            Statement stmt = DBConnection.getStatementConnection();
            stmt.executeUpdate("INSERT INTO register VALUES('" + name + "', '" + email + "', '" + phone + "', '" + username + "', '" + password + "', '" + cpassword + "')");
            stmt.close();
            return true; // Successful insertion
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}

