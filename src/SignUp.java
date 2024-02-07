import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp extends JFrame  implements ActionListener{
 
    JButton sn , back;
    ButtonGroup group;
    JTextField t1 ,t2, t3 ;
    JPasswordField  pass;
    JRadioButton male, female;
    JLabel  userName, firstName , lastName, gender , password;
    SignUp(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Sign Up Page");
        setSize(600 ,400);
        setLocation(400, 100);
        setVisible(true);
        setLayout(null);

        JLabel info = new JLabel("Enter your Details ");
        info.setFont(new Font("Arial" , Font.BOLD , 25));
        info.setBounds(180 , 10 , 250 , 50);
        add(info);

        userName = new JLabel("User Name : ");
        userName.setFont(new Font("times new roman" , Font.BOLD, 15));
        userName.setBounds(100, 70, 100, 20);
        add(userName);
        t1 = new JTextField();
        t1.setBounds(210, 72, 180 , 17);
        add(t1);

        firstName = new JLabel("First Name : ");
        firstName.setFont(new Font("times new roman" , Font.BOLD, 15));
        firstName.setBounds(100, 100, 100, 20);
        add(firstName);
        t2 = new JTextField();
        t2.setBounds(210, 102, 180 , 17);
        add(t2);

        lastName = new JLabel("Last Name : ");
        lastName.setFont(new Font("times new roman" , Font.BOLD, 15));
        lastName.setBounds(100 , 130 , 100 , 20);
        add(lastName);
        t3 = new JTextField();
        t3.setBounds(210, 132, 180 , 17);
        add(t3);

        

        gender = new JLabel("Gender : ");
        gender.setFont(new Font("times new roman" , Font.BOLD, 15));
        gender.setBounds(100 , 160 , 100 , 20);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setFont(new Font("times new roman" , Font.BOLD, 15));
        male.setBounds(210 , 162 , 80 , 17);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("times new roman" , Font.BOLD, 15));
        female.setBounds(300 , 162 , 80 , 17);
        female.setBackground(Color.white);
        add(female);
        
        group = new ButtonGroup();
        group.add(male);
        group.add(female);

        password = new JLabel("Password : ");
        password.setFont(new Font("times new roman" , Font.BOLD, 15));
        password.setBounds(100 , 190 , 100 , 20);
        add(password);

         pass = new JPasswordField();
        pass.setBounds(210 , 192 , 180 , 17);
        add(pass);

        sn = new JButton("SIGN UP");
        sn.setBounds(210 , 260 , 90 , 25);
        sn.addActionListener(this);
        sn.setBackground(Color.BLACK);
        sn.setForeground(Color.WHITE);
        add(sn);

        back = new JButton("BACK");
        back.setBounds(320 , 260 , 90 , 25);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
    }
    String q = "insert into signup values (? , ? , ? , ? , ? )";
    String q2 = " insert into signin values (? , ?)";
    public void actionPerformed(ActionEvent ae ){
        if( ae.getSource() == sn){
           connection obj = new connection(q);
           connection obj2 = new connection(q2);
           try {
            obj.stmt.setString(1, t1.getText());
            obj.stmt.setString(2, t2.getText());
            obj.stmt.setString(3, t3.getText());
                if( male.isSelected()) obj.stmt.setString(4,male.getText() );
                else obj.stmt.setString(4,female.getText());
            char[] arr = pass.getPassword();
            String t5 = new String(arr);
            obj.stmt.setString(5,t5 );
            obj.stmt.executeUpdate();
            System.out.println("Inserted Successfully ! ");
            obj.stmt.close();
            obj.cn.close();

            // For saving userName and password to signIn table -->
            obj2.stmt.setString(1, t1.getText());
            obj2.stmt.setString(2, t5);
            obj2.stmt.executeUpdate();
            System.out.println("Data saved in signIn successfully");
            obj2.stmt.close();
            obj2.cn.close();

            JOptionPane.showMessageDialog(null,"Sign Up Successful");
            setVisible(false);
            new LoginPage();

            } catch (SQLException e) {
                 System.out.println("User with that username already Exist !");
                 JOptionPane.showMessageDialog(null,"User with that username already Exist !");
                 t1.setText("");
                 t2.setText("");
                 t3.setText("");
                 group.clearSelection();
                 pass.setText("");
            }
        }
        else if( ae.getSource() == back ){
            new LoginPage();
        }
    }
    public static void main(String[] args) {
        new SignUp();
    }
}
