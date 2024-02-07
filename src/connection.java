// import java.beans.Statement;
import java.sql.*;
public class connection {

    Connection cn;
    PreparedStatement stmt;
    connection(String query) {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "Sosa@2004");
            stmt = cn.prepareStatement(query);
        } catch (Exception e) { 
            System.out.println("Error in connecting to the database." + e);
        }
    }
}
