import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeaveFileReader {
    private static final String FILE_PATH = "./LeaveFileRecord.csv";

    public static int getLeaveHours(String inputNum, String inputMo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int leaveHours = 0;

            while ((line = reader.readLine()) != null) {
                String[] leaveData = line.split(",");
                String date = leaveData[0].replace("\"", "");
                String empNum = leaveData[1].replace("\"", "");

                if (empNum.equals(inputNum) && isSameMonth(date, inputMo)) {
                    leaveHours += 9; // Each leave day is considered as 9 hours
                }
            }

            return leaveHours;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static boolean isSameMonth(String date, String inputMo) {
        String[] dateParts = date.split("/");
        if (dateParts.length >= 2) {
            String month = dateParts[1];
            return month.equals(inputMo);
        }
        return false;
    }
}
