
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dashboard extends JFrame implements  ActionListener {

    JButton allSet;
    String fn , ln , gen , enr ,brn , sm, dv , gyr ,cgp ,  eml;

    String qry = "select *from signup where username = ?";
    Dashboard(String user){
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        connection con = new connection(qry);
        try {
            
            con.stmt.setString(1, user);
            ResultSet rs = con.stmt.executeQuery();
            while (rs.next()) {
                fn = rs.getString("fname");
                ln = rs.getString("lname");
                gen = rs.getString("gender");
                enr = rs.getString("enrollment");
                brn = rs.getString("branch");
                sm = rs.getString("sem");
                dv = rs.getString("div");
                gyr = rs.getString("graduation");
                cgp = rs.getString("cgpa");
                eml = rs.getString("email");
            }
            System.out.println(fn);
            con.stmt.close();
            con.cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JLabel head = new JLabel("Details ");
        head.setFont(new Font("Arial" , Font.BOLD , 20));
        head.setBounds(300 , 5 , 400 , 20);
        add(head);

        
        JLabel fname = new JLabel(" First fname : ");
        fname.setFont(new Font("Arial" , Font.BOLD , 14));
        fname.setBounds(100 , 50 , 100 , 20);
        add(fname);
        JLabel lbl1 = new JLabel(fn);
        lbl1.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl1.setBounds(210 , 50 , 100 , 20);
        add(lbl1);

        JLabel lname = new JLabel(" Last fname : ");
        lname.setFont(new Font("Arial" , Font.BOLD , 14));
        lname.setBounds(400 , 50 , 100 , 20);
        add(lname);
        JLabel lbl2 = new JLabel(ln);
        lbl2.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl2.setBounds(510 , 50 , 100 , 20);
        add(lbl2);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Arial" , Font.BOLD , 14));
        gender.setBounds(100 , 90 , 100 , 20);
        add(gender);
        JLabel lbl3 = new JLabel(gen);
        lbl3.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl3.setBounds(210 , 90 , 100 , 20);
        add(lbl3);

        JLabel enroll = new JLabel("Enrollment : ");
        enroll.setFont(new Font("Arial" , Font.BOLD , 14));
        enroll.setBounds(400 , 90 , 100 , 20);
        add(enroll);
        JLabel lbl4 = new JLabel(enr);
        lbl4.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl4.setBounds(510 , 90 , 100 , 20);
        add(lbl4);

        JLabel branch = new JLabel("branch : ");
        branch.setFont(new Font("Arial" , Font.BOLD , 14));
        branch.setBounds(100 , 130 , 100 , 20);
        add(branch);
        JLabel lbl5 = new JLabel(brn);
        lbl5.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl5.setBounds(210 , 130 , 100 , 20);
        add(lbl5);

        JLabel sem = new JLabel("sem : ");
        sem.setFont(new Font("Arial" , Font.BOLD , 14));
        sem.setBounds(400 , 130 , 100 , 20);
        add(sem);
        JLabel lbl6 = new JLabel(sm);
        lbl6.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl6.setBounds(510 , 130 , 100 , 20);
        add(lbl6);

        JLabel div = new JLabel("division : ");
        div.setFont(new Font("Arial" , Font.BOLD , 14));
        div.setBounds(100 , 170 , 100 , 20);
        add(div);
        JLabel lbl7 = new JLabel(dv);
        lbl7.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl7.setBounds(210 , 170 , 100 , 20);
        add(lbl7);

        JLabel gyear = new JLabel("Graduation year : ");
        gyear.setFont(new Font("Arial" , Font.BOLD , 14));
        gyear.setBounds(400 , 170 , 100 , 20);
        add(gyear);
        JLabel lbl8 = new JLabel(gyr);
        lbl8.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl8.setBounds(510 , 170 , 100 , 20);
        add(lbl8);

        JLabel cgpa = new JLabel("CGPA : ");
        cgpa.setFont(new Font("Arial" , Font.BOLD , 14));
        cgpa.setBounds(100 , 210 , 100 , 20);
        add(cgpa);
        JLabel lbl9 = new JLabel(cgp);
        lbl9.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl9.setBounds(210 , 210 , 100 , 20);
        add(lbl9);

        JLabel email = new JLabel("Email id : ");
        email.setFont(new Font("Arial" , Font.BOLD , 14));
        email.setBounds(400 , 210 , 100 , 20);
        add(email);
        JLabel lbl10 = new JLabel(eml);
        lbl10.setFont(new Font("Arial" , Font.PLAIN , 14));
        lbl10.setBounds(510 , 210 , 400 , 20);
        add(lbl10);

        allSet = new JButton("All Set");
        allSet.setBounds(280 , 270 , 90 , 25);
        allSet.addActionListener(this);
        allSet.setBackground(Color.BLACK);
        allSet.setForeground(Color.white);
        add(allSet);
         
        setTitle("Login Page");
        setSize(700 ,400);
        setLocation(400 , 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == allSet){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboard("bhai");
    }
}
