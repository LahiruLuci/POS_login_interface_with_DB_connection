
package Controller;

import Model.DBConnection;
import Model.DBSearch;
import View.Login;
import View.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LoginController {
         public static void login(String usName, String pass) {
       try {
            String username = null; // initial value of the username
            String password = null; // initial value of the password
            ResultSet rs = new DBSearch().searchLogin(usName);
//Process the Query
            while (rs.next()) {
                username = rs.getString("username"); 
                password = rs.getString("password"); 
            }
        if (username != null && password != null) {
            if (password.equals(pass)) {
                JOptionPane.showMessageDialog(null,"Login Successfull!"); 
                Login.getFrames()[0].dispose();
                new View.Main().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please check the credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please check the Credentials", "Error", JOptionPane.ERROR_MESSAGE);
 }
    DBConnection.closeCon();
            } catch (SQLException ex) { 
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
}
