import java.sql.*;
import java.util.ArrayList;
public class temp {
    static ArrayList<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String q = " select username from signin where password=?";
        String pword =  "Sosa@2004";
        connection cn = new connection(q);
        try {
            // System.out.println("gkjsfd");
            // cn.stmt.setString(1, "Bhautik007");
            cn.stmt.setString(1, pword);
            ResultSet rs = cn.stmt.executeQuery();
            while(rs.next()) {
                // if( !res.contains(rs.getString("username"))) System.out.println( rs.getString("username"));
                // res.add(rs.getString("username"));
                System.out.println( rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Raju andewala");
        }
    }
}
