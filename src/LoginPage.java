import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
public class LoginPage  extends JFrame implements ActionListener{

    JButton signIn , signUp , clear;
    JTextField userField ;
    JPasswordField passField;
    
    ResultSet rset = null;

    int flag =0;
    static ArrayList<String> list = new ArrayList<>();
    LoginPage(){
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login2.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(100, 30, 80, 80);
        add(l1);
        
        JLabel text = new JLabel("Yokoso watasi no Login Pagge");
        text.setFont(new Font("Arial" , Font.BOLD , 20));
        text.setBounds(180 , 30 , 400 , 80);
        add(text);

        JLabel useName = new JLabel("User Name : ");
        useName.setFont(new Font("Arial" , Font.BOLD , 15));
        useName.setBounds(180 , 120 , 100 , 50);
        add(useName);
        userField = new JTextField();
        userField.setBounds(290 ,135 , 200 , 25 );
        add(userField);
        
        JLabel pass = new JLabel("Password : ");
        pass.setFont(new Font("Arial" , Font.BOLD , 15));
        pass.setBounds(180 , 155 ,100 , 50);
        add(pass);
        passField = new JPasswordField();
        passField.setBounds(290 ,170 , 200 , 25 );
        add(passField);

        
        signIn = new JButton("SIGN IN");
        signIn.setBounds(290 , 220 , 80 , 25);
        signIn.addActionListener(this);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.white);
        add(signIn);
        
        clear = new JButton("CLEAR");
        clear.setBounds(410 , 220 , 80 , 25);
        clear.addActionListener(this);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(350 , 260 , 90 , 25);
        signUp.addActionListener(this);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        add(signUp);
        
        setTitle("Login Page");
        setSize(600,400);
        setLocation(400 , 100);
        setVisible(true);
    }
    public void actionPerformed( ActionEvent ae){
        if( ae.getSource() == clear ){
            userField.setText(" Lassi BKL");
            passField.setText(" Jaldi Wha se Hato");
        }
        else if( ae.getSource() == signUp ){
            new SignUp();
        } else if( ae.getSource() == signIn ){

            char[] arr = passField.getPassword();
            String epass = new String(arr);
            String q = "select username from  signin where password=?";
            connection obj3 = new connection(q);
            
            try {
                // System.out.println("kafndf");
                obj3.stmt.setString(1, epass);
                rset = obj3.stmt.executeQuery();
                while( rset.next() ) {
                    list.add(rset.getString("username"));
                    if( rset.getString("username").equals(userField.getText()) ){
                        JOptionPane.showMessageDialog(null , " You Got this man ! ");
                        break;
                    } else flag++;
                }
                
                if( flag == list.size()) {
                    JOptionPane.showMessageDialog(null , " Sign Up First ! ");
                    userField.setText(" Lassi BKL");
                    passField.setText(" Jaldi Wha se Hato");
                }
                obj3.stmt.close();
                obj3.cn.close();
                //passNext page
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Somethis went wrong !");
            }
        }

    }
    public static void main(String[] args) throws Exception  {
        new LoginPage();

    }
}