// import java.beans.Statement;
import java.sql.*;

import javax.swing.JOptionPane;
public class connection {

    Connection cn;
    PreparedStatement stmt;
    // Statement res;
    connection(String query) {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "Dhruvil@23");
            stmt = cn.prepareStatement(query);
        } catch (Exception e) { 
            System.out.println("Error in connecting to the database." + e);
            JOptionPane.showMessageDialog(null,"Rjau");
        }
    }
    // connection() {
    //     try {
    //         cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "Sosa@2004");
    //         res = cn.createStatement();
    //     } catch (Exception e) { 
    //         System.out.println("Error in connecting to the database." + e);
    //     }
    // }
    public static void main(String[] args) {
        new connection("");
    }
}
