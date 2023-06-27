import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginWindow() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                boolean loginSuccessful = UserDetails.checkUser(username, password);
                if (loginSuccessful) {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Login successful!");
                    dispose(); // Close the window
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Invalid username or password!");
                }
            }
        });

        JButton addAccountButton = new JButton("Add Account");
        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                UserDetails.addUser(username, password);
                JOptionPane.showMessageDialog(LoginWindow.this, "Account created successfully!");
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(loginButton);
        buttonPanel.add(addAccountButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Check if UserDetails.csv file already exists

        File file = new File(UserDetails.FILE_PATH);
        if (!file.exists()) {
            // Create a new UserDetails.csv file if it doesn't exist
            UserDetails.addUser("admin", "password");
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
            }
        });
    }
}