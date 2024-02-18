
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp2  extends  JFrame implements ActionListener {
    @SuppressWarnings("rawtypes")

    JButton submit;
    JTextField tf1,  tf3 , tf4, tf5;
    JComboBox c1 ,c2 , c3 , c4 ;
    String user , fname , lname , gen ,pas ;

    // static String user;
    
    public SignUp2(String uname , String firstName , String lastName , String gender , String passString ){

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sign Up 2Page");
        setSize(700 ,600);
        setLocation(400, 100);
        setVisible(true);
        setLayout(null);
        setLayout(null);


        user = new String( uname);
        System.out.println(uname);
        fname = firstName;
        System.out.println(firstName);
        lname = lastName;
        gen = gender;
        pas = passString;

        JLabel Title = new JLabel(" Academic Details : ");
        Title.setFont( new Font("Arial" , Font.BOLD , 25));
        Title.setBounds(220 , 40 , 250 , 30);
        add(Title);

        JLabel Roll = new JLabel("Enrollment No. :");
        Roll.setFont( new Font("Arial" , Font.BOLD , 15));
        Roll.setBounds(120 , 110 , 150 , 30);
        add(Roll);
        tf1 = new JTextField();
        tf1.setBounds(270 , 115 , 220 , 20 );
        add(tf1);

        JLabel Branch = new JLabel("Branch :");
        Branch.setFont( new Font("Arial" , Font.BOLD , 15));
        Branch.setBounds(120 , 150 , 200 , 30);
        add(Branch);
        String[] Abranch = {"Computer" , "Electrical" , "Mechanical" , "Civil" };
        c4 = new JComboBox(Abranch);
        c4.setBounds(270 ,155 , 220 , 20);
        add(c4);

        JLabel Sem = new JLabel("Semester :");
        Sem.setFont( new Font("Arial" , Font.BOLD , 15));
        Sem.setBounds(120 , 190 , 200 , 30);
        add(Sem);
        String[] Asem = {"SEM 1 " , "SEM 2" , "SEM 3" , "SEM 4" , "SEM 5" , "SEM 6" , "SEM 7" , "SEM 8"  };
        c1 = new JComboBox<>(Asem);
        c1.setBounds(270 , 197 , 220 , 20 );
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel Div = new JLabel("Division :");
        Div.setFont( new Font("Arial" , Font.BOLD , 15));
        Div.setBounds(120 , 230 , 200 , 30);
        add(Div);
        String[] Adiv = {"Div A" , "Div B" , "Div C" , "Div D" , "Div E"};
        c2 = new JComboBox<>(Adiv);
        c2.setBounds(270 , 237 , 220 , 20 );
        c2.setBackground(Color.WHITE);
        add(c2);

        JLabel Gyear = new JLabel("Graduation Year :");
        Gyear.setFont( new Font("Arial" , Font.BOLD , 15));
        Gyear.setBounds(120 , 270 , 200 , 30);
        add(Gyear);
        String[] Ayear = {"2021", "2022", "2023" , "2024" ,"2025" , "2026"  , "2027" , "2028" ,"2029" , "2030"};
        c3 = new JComboBox<>(Ayear);
        c3.setBounds(270 , 277 , 220 , 20 );
        c3.setBackground(Color.WHITE);
        add(c3);

        JLabel Mno = new JLabel("Mobile No. :");
        Mno.setFont( new Font("Arial" , Font.BOLD , 15));
        Mno.setBounds(120 , 310 , 200 , 30);
        add(Mno);
        tf3 = new JTextField(10);
        tf3.setBounds(270 , 317 , 220 , 20 );
        add(tf3);
        
        JLabel Email = new JLabel("Email ID :");
        Email.setFont( new Font("Arial" , Font.BOLD , 15));
        Email.setBounds(120 , 350 , 200 , 30);
        add(Email);
        tf4 = new JTextField();
        tf4.setBounds(270 , 357 , 220 , 20 );
        add(tf4);

        JLabel Cgpa = new JLabel("CGPA :");
        Cgpa.setFont( new Font("Arial" , Font.BOLD , 15));
        Cgpa.setBounds(120 , 390 , 200 , 30);
        add(Cgpa);
        tf5 = new JTextField();
        tf5.setBounds(270 , 397 , 220 , 20 );
        add(tf5);

        submit = new JButton("SUBMIT");
        submit.setBounds(330 , 470 , 90 , 25);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);


        // user =  uname;
    }
    String q4 = "insert into signup values ( ? ,? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,? , ?)";
    String q5 = " insert into signin values( ? , ?)";
    public void actionPerformed(java.awt.event.ActionEvent ae) {
        if( ae.getSource() == submit){

            try {
                connection cn2 = new connection(q4);
                connection cn3 = new connection(q5);
                cn2.stmt.setString(1, user);
                cn2.stmt.setString(2, fname);
                cn2.stmt.setString(3, lname);
                cn2.stmt.setString(4, gen);
                cn2.stmt.setString(5, pas);
                cn2.stmt.setString(6, tf1.getText());
                cn2.stmt.setString(7, c4.getSelectedItem().toString());
                cn2.stmt.setString(8, c1.getSelectedItem().toString());
                cn2.stmt.setString(9, c2.getSelectedItem().toString());
                cn2.stmt.setString(10,c3.getSelectedItem().toString());
                cn2.stmt.setString(11, tf3.getText());
                cn2.stmt.setString(12, tf4.getText());
                cn2.stmt.setString(13, tf5.getText());
                cn2.stmt.executeUpdate();
                cn2.stmt.close();
                cn2.stmt.close();
                JOptionPane.showMessageDialog(null,"Sign Up Successful");

                // For saving userName and password to signIn table -->
                cn3.stmt.setString(1, user);
                cn3.stmt.setString(2, pas);
                cn3.stmt.executeUpdate();
                setVisible(false);
                new LoginPage();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null ,"Enter valid details ! ");
                tf1.setText("");
                tf5.setText("");
                tf3.setText("");
                tf4.setText("");
            }
            // System.out.println(user);

        }
        
    }
    public static void main(String[] args) {
        
        // System.out.println(user);
    }
    
}
