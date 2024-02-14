import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temp2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Email TextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        JTextField emailField = new JTextField(20); // Create JTextField with a width of 20 columns
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Do nothing when focus is gained
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Perform email validation when focus is lost
                String email = emailField.getText();
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(frame, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                    emailField.requestFocus();
                }
            }
        });

        panel.add(new JLabel("Email: "));
        panel.add(emailField);

        frame.setVisible(true);
    }

    // Basic email validation using regular expression
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
