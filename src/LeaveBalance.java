import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import com.opencsv.CSVReader;

import javax.swing.*;

public class LeaveBalance {
    public static HashMap<String, HashMap<String, Integer>> countLeaves() {
        HashMap<String, HashMap<String, Integer>> leaveBalance = new HashMap<String, HashMap<String, Integer>>();

        try {
            String directory = System.getProperty("user.dir");
            String filePath = directory + File.separator + "LeaveFileRecord.csv";
            File file = new File(filePath);
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] header = csvReader.readNext(); // read header

            String[] row;
            while ((row = csvReader.readNext()) != null) {
                String date = row[0];
                String empNum = row[1];
                String leaveType = row[2];

                if (!leaveBalance.containsKey(empNum)) {
                    leaveBalance.put(empNum, new HashMap<String, Integer>());
                    leaveBalance.get(empNum).put("SICK", 5);
                    leaveBalance.get(empNum).put("VACATION", 10);
                    leaveBalance.get(empNum).put("EMERGENCY", 5);
                }

                int count = leaveBalance.get(empNum).get(leaveType);
                leaveBalance.get(empNum).put(leaveType, count - 1);

                if (leaveBalance.get(empNum).get(leaveType) < 0) {
                    String message = "Employee " + empNum + " has exceeded their " + leaveType.toLowerCase() + " leave balance.";
                    JOptionPane.showMessageDialog(null, message);
                }
            }

            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.opencsv.exceptions.CsvValidationException e) {
            e.printStackTrace();
        }

        return leaveBalance;
    }
}
