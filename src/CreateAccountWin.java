import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CreateAccountWin extends JPanel {
    private JButton CreateAccButton;
    private JTextField EnterPasswordBox;
    private JTextField EnterUsernameBox;
    private JLabel EnterUserTitle;
    private JLabel EnterPTitle;

    public CreateAccountWin() {
        //construct components
        CreateAccButton = new JButton ("Create Account");
        EnterPasswordBox = new JTextField (5);
        EnterUsernameBox = new JTextField (5);
        EnterUserTitle = new JLabel ("Enter Username");
        EnterPTitle = new JLabel ("Enter Password");

        //adjust size and set layout
        setPreferredSize (new Dimension (446, 126));
        setLayout (null);

        //add components
        add (CreateAccButton);
        add (EnterPasswordBox);
        add (EnterUsernameBox);
        add (EnterUserTitle);
        add (EnterPTitle);

        //set component bounds (only needed by Absolute Positioning)
        CreateAccButton.setBounds (145, 95, 140, 20);
        EnterPasswordBox.setBounds (130, 65, 170, 25);
        EnterUsernameBox.setBounds (130, 25, 170, 25);
        EnterUserTitle.setBounds (20, 25, 100, 25);
        EnterPTitle.setBounds (20, 60, 100, 25);

        CreateAccButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = EnterUsernameBox.getText();
                String password = EnterPasswordBox.getText();

                // Call the addUser method from UserDetails class
                UserDetails.addUser(username, password);

                // Show a message dialog indicating the account has been added
                JOptionPane.showMessageDialog(CreateAccountWin.this, "Account Added!");

                // Clear the text fields
                EnterUsernameBox.setText("");
                EnterPasswordBox.setText("");
            }
        });
    }




    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new CreateAccountWin());
        frame.pack();
        frame.setVisible (true);
    }
}
