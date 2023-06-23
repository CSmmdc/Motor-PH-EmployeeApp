import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeFileReader {
    private InputMemory input;

    public static void EmpFileRead(String inputnum, String inputmo) {
        Employee emp = new Employee();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./EmpData.csv"));
        } catch (FileNotFoundException ex1) {
            throw new RuntimeException(ex1);
        }
        // File reader Employee.csv
        try {
            int inputmonth = Integer.parseInt(inputmo);
            String headerline = reader.readLine();
            System.out.println(headerline);
            String row = ",";
            while ((row = reader.readLine()) != null) {
                String[] EmpData = row.split(",");
                if (EmpData[0].equals(inputnum)) {
                    emp.EmpNum = EmpData[0];
                    emp.LastName = EmpData[1];
                    emp.FirstName = EmpData[2];
                    emp.Birth = EmpData[3];
                    emp.Address = EmpData[4];
                    emp.PhoneNum = EmpData[5];
                    emp.SSS = EmpData[6];
                    emp.PhilHealth = EmpData[7];
                    emp.TIN = EmpData[8];
                    emp.Pagibig = EmpData[9];
                    emp.Status = EmpData[10];
                    emp.Position = EmpData[11];
                    emp.Supervisor = EmpData[12];
                    //                     emp.BasicSalary = Double.parseDouble(EmpData[13]);
                    emp.Rice = Float.parseFloat(EmpData[14]);
                    emp.PhoneMoney = Float.parseFloat(EmpData[15]);
                    emp.Clothes = Float.parseFloat(EmpData[16]);
                    emp.MonthlyRate = Float.parseFloat(EmpData[17]);
//                            emp.HourlyRate = Double.parseDouble(EmpData[18]);

                    /** Used setter to set the hour rate of the employee from the CSV */
                    //emp.setHourlyRate(Double.parseDouble((EmpData[18])));
                    //emp.setBasicSalary(Double.parseDouble(EmpData[13]));


                    //Enter here text display button for the left side
                    LNBox.setText(emp.LastName);
                    FNBox.setText(emp.FirstName);
                    BirthdateBox.setText(emp.Birth);
                    PNBox.setText(emp.PhoneNum);
                    AddressBox.setText(emp.Address);
                    PositionBox.setText(emp.Position);
                    StatusBox.setText(emp.Status);
                    SuperBox.setText(emp.Supervisor);
                    TINBox.setText(emp.TIN);
                    SSSBox.setText(emp.SSS);
                    PHHBox.setText(emp.PhilHealth);
                    PIBox.setText(emp.Pagibig);






                }
            }
        } catch (IOException ex2) {
            throw new RuntimeException(ex2);
        }
    }
}
