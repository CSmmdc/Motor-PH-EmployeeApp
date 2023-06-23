import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
public class LeaveAppWindow extends JPanel {



    private JLabel jcomp1;
    private static JTextField DateEntryBox;
    private static JTextField EmpNumEntryBox;
    private static JTextField ReasonEntryBox;
    private static JButton LeaveEnterButton;
    private JLabel DateEntryDisplay;
    private JLabel EmpNumLeaveDisplay;
    private JLabel ReasonDisplay;
    private JLabel FormatDisplay;

    private static EmployeeMemoryFile EmpMem = new EmployeeMemoryFile();

    public LeaveAppWindow() {
        //construct components
        jcomp1 = new JLabel("EMPLOYEE LEAVE FILE");
        DateEntryBox = new JTextField(5);
        EmpNumEntryBox = new JTextField(5);
        ReasonEntryBox = new JTextField(5);
        LeaveEnterButton = new JButton("Enter");
        DateEntryDisplay = new JLabel("Enter Date Here:");
        EmpNumLeaveDisplay = new JLabel("Employee Number:");
        ReasonDisplay = new JLabel("Reason:");
        FormatDisplay = new JLabel("Format: mm-dd-yyyy");

        //adjust size and set layout
        setPreferredSize(new Dimension(643, 223));
        setLayout(null);

        //add components
        add(jcomp1);
        add(DateEntryBox);
        add(EmpNumEntryBox);
        add(ReasonEntryBox);
        add(LeaveEnterButton);
        add(DateEntryDisplay);
        add(EmpNumLeaveDisplay);
        add(ReasonDisplay);
        add(FormatDisplay);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(240, 70, 200, 50);
        DateEntryBox.setBounds(90, 160, 100, 50);
        EmpNumEntryBox.setBounds(240, 160, 100, 50);
        ReasonEntryBox.setBounds(390, 160, 100, 50);
        LeaveEnterButton.setBounds(525, 160, 100, 25);
        DateEntryDisplay.setBounds(90, 135, 100, 25);
        EmpNumLeaveDisplay.setBounds(230, 135, 110, 25);
        ReasonDisplay.setBounds(390, 135, 100, 25);
        FormatDisplay.setBounds(85, 110, 120, 25);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("LeaveAppWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LeaveAppWindow());
        frame.pack();
        frame.setVisible(true);

        LeaveEnterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String DateInput = DateEntryBox.getText();
                String EmpNumInput = EmpNumEntryBox.getText();
                String ReasonInput = ReasonEntryBox.getText();
                LeaveApp.LeaveApp(DateInput, EmpNumInput, ReasonInput, EmpMem);
            }
        });
    }
}
