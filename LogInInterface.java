import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeLogIn extends JPanel {
    private static JButton LogInButton;
    private static JLabel EmployeeTitle;
    private static JLabel EmailTitle;
    private static JLabel PasswordTitle;
    private static JTextField EmailField;
    private static AbstractButton loginButton;
    private static String email;
    private static String[] args;
    private static JPasswordField passwordField;
    private static Label statusLabel;


    public EmployeeLogIn() {
        //construct components
        LogInButton = new JButton("Log In");
        EmployeeTitle = new JLabel("EMPLOYEE LOG-IN");
        EmailTitle = new JLabel("Email");
        PasswordTitle = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(5);
        EmailField = new JTextField(5);

        //adjust size and set layout
        setPreferredSize(new Dimension(752, 425));
        setLayout(null);

        //add components
        add(LogInButton);
        add(EmployeeTitle);
        add(EmailTitle);
        add(PasswordTitle);
        add(passwordField);
        add(EmailField);

        //set component bounds (only needed by Absolute Positioning)
        LogInButton.setBounds(115, 175, 100, 20);
        EmployeeTitle.setBounds(105, 10, 120, 25);
        EmailTitle.setBounds(15, 75, 45, 30);
        PasswordTitle.setBounds(15, 120, 65, 30);
        passwordField.setBounds(90, 120, 155, 25);
        EmailField.setBounds(90, 70, 155, 25);
    }

    public static void main(String[] args) {
        EmployeeLogIn.args = args;
        JFrame frame = new JFrame("EMPLOYEE LOG-IN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new EmployeeLogIn());
        frame.pack();
        frame.setVisible(true);


        loginButton.addActionListener(e -> {
            String Email = EmailField.getText();
            String password = String.valueOf(passwordField.getPassword());
            boolean validated = validateUser(Email, password);
            if (validated) {
                statusLabel.setText("Login successful!");
            } else {
                statusLabel.setText("Invalid email or password.");
            }
        });
    }

    private static boolean validateUser(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("./employeeLogInInfo.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = ",".split(line);
                if (parts[0].equals(email) && parts[1].equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    public static void setLoginButton(AbstractButton loginButton) {
        EmployeeLogIn.loginButton = loginButton;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        EmployeeLogIn.email = email;
    }

    public static String[] getArgs() {
        return args;
    }

    public static void setPasswordField(JPasswordField passwordField) {
        EmployeeLogIn.passwordField = passwordField;
    }

    public static void setStatusLabel(Label statusLabel) {
        EmployeeLogIn.statusLabel = statusLabel;
    }
}


