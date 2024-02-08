import java.sql.*;
import java.util.ArrayList;
public class temp {
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String q = " select username from signin where password=?";
        String pword =  "jay";
        connection cn = new connection(q);
        try {
            // System.out.println("gkjsfd");
            // cn.stmt.setString(1, "Bhautik007");
            String uname = "bhautik0013";
            cn.stmt.setString(1, pword);
            ResultSet rs = cn.stmt.executeQuery();
            int flag = 0;
            // int size = 0;
            // while( newSet.next()) size++;
            // System.out.println(size) ;
            while( rs.next() ){
                res.add( rs.getString("username"));
                if( rs.getString("username").equals(uname)){
                    System.out.println(uname);
                    break;
                }else flag++;
            }
            if( flag == res.size()) System.out.println("Noob ");
            System.out.println(flag);
            System.out.println(res);
            
            // if( flag >= rs.getFetchSize() ) System.out.println("raju andewala");
        } catch (SQLException e) {
            System.out.println("Raju andewala");
        }
    }
}
