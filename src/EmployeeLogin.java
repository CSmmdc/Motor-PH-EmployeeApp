import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EmployeeLogin extends JPanel {
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
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new EmployeeLogin());
        frame.pack();
        frame.setVisible (true);
    }
}




