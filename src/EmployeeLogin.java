import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EmployeeLogin extends JFrame {
    private JButton CreateAccountButton;
    private JButton LoginButton;
    private JLabel EmployeeLoginTittle;
    private JLabel UsernameTitle;
    private JLabel PasswordTitle;
    private JPasswordField PasswordBox;
    private JTextField UsernameBox;

    public EmployeeLogin() {
        //construct components
        CreateAccountButton = new JButton ("Create Account");
        LoginButton = new JButton ("Log in");
        EmployeeLoginTittle = new JLabel ("Employee Log in");
        UsernameTitle = new JLabel ("Username");
        PasswordTitle = new JLabel ("Password");
        PasswordBox = new JPasswordField (5);
        UsernameBox = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (321, 328));
        setLayout (null);

        //add components
        add (CreateAccountButton);
        add (LoginButton);
        add (EmployeeLoginTittle);
        add (UsernameTitle);
        add (PasswordTitle);
        add (PasswordBox);
        add (UsernameBox);

        //set component bounds (only needed by Absolute Positioning)
        CreateAccountButton.setBounds (25, 205, 125, 25);
        LoginButton.setBounds (200, 205, 100, 25);
        EmployeeLoginTittle.setBounds (115, 10, 100, 25);
        UsernameTitle.setBounds (15, 75, 60, 25);
        PasswordTitle.setBounds (15, 135, 65, 25);
        PasswordBox.setBounds (80, 130, 160, 25);
        UsernameBox.setBounds (80, 70, 160, 25);

        CreateAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create an instance of CreateAccountWin
                CreateAccountWin createAccountWin = new CreateAccountWin();

                // Set up a JFrame to contain the CreateAccountWin
                JFrame frame = new JFrame("Create Account");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(createAccountWin);
                frame.pack();
                frame.setVisible(true);
            }
        });
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = UsernameBox.getText();
                String password = PasswordBox.getText();

                if (UserDetails.checkUser(username, password)) {
                    JOptionPane.showMessageDialog(EmployeeLogin.this, "Login successful");
                    dispose();

                    // Open MainGUI
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            JFrame frame = new JFrame("MotorPH");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.getContentPane().add(new MainGUI());
                            frame.pack();
                            frame.setVisible(true);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(EmployeeLogin.this, "Invalid username or password");
                }
            }
        });
    }


    private boolean isLoginSuccessful() {
        String username = UsernameBox.getText();
        String password = PasswordBox.getText();

        // Check if the username and password are correct
        if (UserDetails.checkUser(username, password)) {
            return true; // Login successful
        } else {
            return false; // Login failed
        }
    }


    public static void main(String[] args) {
        EmployeeLogin loginWindow = new EmployeeLogin();
        loginWindow.setVisible(true);

        loginWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (loginWindow.isLoginSuccessful()) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            JFrame frame = new JFrame("MotorPH");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.getContentPane().add(new MainGUI());
                            frame.pack();
                            frame.setVisible(true);
                        }
                    });
                }
            }
        });
    }
}




