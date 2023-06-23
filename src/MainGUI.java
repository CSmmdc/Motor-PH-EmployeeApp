import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;



public class MainGUI extends JPanel {
    private AttendanceFileReader attfile;
    private WeekMemory weekmem;
    private Employee emp;
    static InputMemory inputMemory = new InputMemory();
    private double netSalary;
    // GUI elements below
    private static JTextField EnterMonthField;
    private static JTextField EnterEMPNUMBField;
    private JLabel EnterMonthDisplay;
    private JLabel EnterEMPNumDisplay;
    private static JButton ConfirmButton;
    private static JTextField EmpFirstNameBox;
    private static JTextField BirthdayBox;
    private static JTextField PhoneNumBox;
    private static JTextField StatusBox;
    private static JTextField SSSBox;
    private static JTextField AddressBox;
    private static JTextField PositionBox;
    private static JTextField SupervisorBox;
    private static JTextField PhilHealthBox;
    private static JTextField PAGIBIGBox;
    private static JTextField TINBox;
    private JLabel BirthdayTitle;
    private JLabel PhoneNumTitle;
    private JLabel StatusTitle;
    private JLabel SSSTitle;
    private JLabel PAGIBIGTitle;
    private JLabel AddressTitle;
    private JLabel PositionTitle;
    private JLabel SupervisorTitle;
    private JLabel PhilHealthTitle;
    private JLabel TINTitle;
    private static JTextField EmpLastNameBox;
    private static JTextField MonthlyGrossBox;
    private static JTextField Week1Box;
    private static JTextField Week2Box;
    private static JTextField Week3Box;
    private static JTextField Week4Box;
    private static JTextField MonthlyNetBox;
    private JLabel Week1Title;
    private JLabel HoursWorkedTitle;
    private JLabel Week2Title;
    private JLabel Week3Title;
    private JLabel Week4Title;
    private JLabel MonthlyGCTitle;
    private JLabel MonthlyNCTitle;
    private JLabel Week5Title;
    private static JTextField Week5Box;
    private JButton LeaveAppButton;


    public MainGUI() {
        //construct components
        EnterMonthField = new JTextField (5);
        EnterEMPNUMBField = new JTextField (5);
        EnterMonthDisplay = new JLabel ("Enter Month:");
        EnterEMPNumDisplay = new JLabel ("Enter Employee Number:");
        ConfirmButton = new JButton ("Confirm");
        EmpFirstNameBox = new JTextField (1);
        BirthdayBox = new JTextField (1);
        PhoneNumBox = new JTextField (5);
        StatusBox = new JTextField (5);
        SSSBox = new JTextField (5);
        AddressBox = new JTextField (5);
        PositionBox = new JTextField (5);
        SupervisorBox = new JTextField (5);
        PhilHealthBox = new JTextField (5);
        PAGIBIGBox = new JTextField (5);
        TINBox = new JTextField (5);
        BirthdayTitle = new JLabel ("Birthday");
        PhoneNumTitle = new JLabel ("Phone Number");
        StatusTitle = new JLabel ("Status");
        SSSTitle = new JLabel ("SSS Number");
        PAGIBIGTitle = new JLabel ("PAG-IBIG");
        AddressTitle = new JLabel ("Address");
        PositionTitle = new JLabel ("Position");
        SupervisorTitle = new JLabel ("Supervisor");
        PhilHealthTitle = new JLabel ("Phil Heath");
        TINTitle = new JLabel ("TIN");
        EmpLastNameBox = new JTextField (5);
        MonthlyGrossBox = new JTextField (5);
        Week1Box = new JTextField (5);
        Week2Box = new JTextField (5);
        Week3Box = new JTextField (5);
        Week4Box = new JTextField (5);
        MonthlyNetBox = new JTextField (5);
        Week1Title = new JLabel ("Week 1");
        HoursWorkedTitle = new JLabel ("Hours Worked:");
        Week2Title = new JLabel ("Week 2");
        Week3Title = new JLabel ("Week 3");
        Week4Title = new JLabel ("Week 4");
        MonthlyGCTitle = new JLabel ("Monthly Gross Computation");
        MonthlyNCTitle = new JLabel ("Monthly Netpay Computation");
        LeaveAppButton = new JButton ("Leave App");
        Week5Title = new JLabel ("Week 5");
        Week5Box = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //add components
        add (EnterMonthField);
        add (EnterEMPNUMBField);
        add (EnterMonthDisplay);
        add (EnterEMPNumDisplay);
        add (ConfirmButton);
        add (EmpFirstNameBox);
        add (BirthdayBox);
        add (PhoneNumBox);
        add (StatusBox);
        add (SSSBox);
        add (AddressBox);
        add (PositionBox);
        add (SupervisorBox);
        add (PhilHealthBox);
        add (PAGIBIGBox);
        add (TINBox);
        add (BirthdayTitle);
        add (PhoneNumTitle);
        add (StatusTitle);
        add (SSSTitle);
        add (PAGIBIGTitle);
        add (AddressTitle);
        add (PositionTitle);
        add (SupervisorTitle);
        add (PhilHealthTitle);
        add (TINTitle);
        add (EmpLastNameBox);
        add (MonthlyGrossBox);
        add (Week1Box);
        add (Week2Box);
        add (Week3Box);
        add (Week4Box);
        add (MonthlyNetBox);
        add (Week1Title);
        add (HoursWorkedTitle);
        add (Week2Title);
        add (Week3Title);
        add (Week4Title);
        add (MonthlyGCTitle);
        add (MonthlyNCTitle);
        add (LeaveAppButton);
        add (Week5Title);
        add (Week5Box);

        //set component bounds (only needed by Absolute Positioning)
        EnterMonthField.setBounds (50, 420, 145, 30);
        EnterEMPNUMBField.setBounds (50, 480, 145, 35);
        EnterMonthDisplay.setBounds (50, 395, 100, 25);
        EnterEMPNumDisplay.setBounds (50, 455, 140, 25);
        ConfirmButton.setBounds (50, 525, 145, 45);
        EmpFirstNameBox.setBounds (35, 15, 130, 35);
        BirthdayBox.setBounds (35, 95, 130, 30);
        PhoneNumBox.setBounds (35, 150, 130, 30);
        StatusBox.setBounds (35, 205, 130, 30);
        SSSBox.setBounds (35, 255, 130, 30);
        AddressBox.setBounds (225, 95, 220, 30);
        PositionBox.setBounds (225, 150, 130, 30);
        SupervisorBox.setBounds (225, 205, 130, 30);
        PhilHealthBox.setBounds (225, 255, 130, 30);
        PAGIBIGBox.setBounds (35, 310, 130, 30);
        TINBox.setBounds (225, 310, 130, 30);
        BirthdayTitle.setBounds (35, 70, 100, 25);
        PhoneNumTitle.setBounds (40, 130, 100, 25);
        StatusTitle.setBounds (35, 180, 100, 25);
        SSSTitle.setBounds (35, 235, 100, 25);
        PAGIBIGTitle.setBounds (35, 285, 100, 25);
        AddressTitle.setBounds (225, 70, 100, 25);
        PositionTitle.setBounds (225, 125, 100, 25);
        SupervisorTitle.setBounds (225, 180, 100, 25);
        PhilHealthTitle.setBounds (225, 230, 100, 25);
        TINTitle.setBounds (225, 285, 100, 25);
        EmpLastNameBox.setBounds (225, 15, 130, 35);
        MonthlyGrossBox.setBounds (520, 475, 130, 45);
        Week1Box.setBounds (730, 160, 100, 25);
        Week2Box.setBounds (730, 220, 100, 25);
        Week3Box.setBounds (730, 280, 100, 25);
        Week4Box.setBounds (730, 340, 100, 25);
        MonthlyNetBox.setBounds (715, 480, 130, 45);
        Week1Title.setBounds (565, 160, 100, 25);
        HoursWorkedTitle.setBounds (565, 105, 100, 25);
        Week2Title.setBounds (565, 220, 100, 25);
        Week3Title.setBounds (565, 280, 100, 25);
        Week4Title.setBounds (565, 340, 100, 25);
        MonthlyGCTitle.setBounds (505, 445, 160, 25);
        MonthlyNCTitle.setBounds (710, 445, 165, 25);
        LeaveAppButton.setBounds (245, 450, 145, 45);
        Week5Title.setBounds (565, 400, 100, 25);
        Week5Box.setBounds (730, 400, 100, 25);

    }


    public static void main (String[] args) {
        JFrame frame = new JFrame("MotorPH");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainGUI());
        frame.pack();
        frame.setVisible(true);

        ConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String inputnum = EnterEMPNUMBField.getText();
                String inputmo = EnterMonthField.getText();
                inputMemory.setInputNum(inputnum);
                inputMemory.setInputMo(inputmo);
                Employee emp = EmployeeFileReader.EmpFileRead(inputnum, inputmo);
                EmployeeFileReader reader = new EmployeeFileReader();
                reader.EmpFileRead(inputnum, inputmo);
                Attendance attendance = new Attendance();
                AttendanceFileReader reader2 = new AttendanceFileReader();
                reader2.AttenFileRead(inputmo, inputnum, attendance);
                WeekMemory weekMemory = reader2.AttenFileRead(inputmo, inputnum, attendance);
                Calculation calculation = new Calculation();
                AttendanceMemoryFile attendancemem = new AttendanceMemoryFile(emp, attendance);
                Employee employee = new Employee();
                double netSalary = calculation.netsalary(attendancemem, employee);



                //Enter here text display button for the left side
                EmpLastNameBox.setText(emp.LastName);
                EmpFirstNameBox.setText(emp.FirstName);
                BirthdayBox.setText(emp.Birth);
                PhoneNumBox.setText(emp.PhoneNum);
                AddressBox.setText(emp.Address);
                PositionBox.setText(emp.Position);
                StatusBox.setText(emp.Status);
                SupervisorBox.setText(emp.Supervisor);
                TINBox.setText(emp.TIN);
                SSSBox.setText(emp.SSS);
                PhilHealthBox.setText(emp.PhilHealth);
                PAGIBIGBox.setText(emp.Pagibig);

                Week1Box.setText(weekMemory.getWeeklyhour1());
                Week2Box.setText(weekMemory.getWeeklyhour2());
                Week3Box.setText(weekMemory.getWeeklyhour3());
                Week4Box.setText(weekMemory.getWeeklyhour4());
                Week5Box.setText(weekMemory.getWeeklyhour5());

                MonthlyGrossBox.setText(String.valueOf(attendancemem.getStaticSalary()));
                MonthlyNetBox.setText(String.valueOf(calculation.getNetSalary()));




            }
        });

    }
    public double getNetSalary() {
        return netSalary;
    }
}

