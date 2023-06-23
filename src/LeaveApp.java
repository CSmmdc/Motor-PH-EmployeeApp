import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import java.util.Arrays;
import java.util.List;
public class LeaveApp {
    private static EmployeeMemoryFile EmpMem;

    public static void LeaveApp(String DateInput, String EmpNumInput, String ReasonInput, EmployeeMemoryFile EmpMem) {
        try {
            String directory = System.getProperty("user.dir");
            String filePath = directory + File.separator + "LeaveFileRecord.csv";
            File file = new File(filePath);
            boolean fileExists = file.exists();

            FileWriter writer = new FileWriter(file, true); // true to append data to the existing file
            CSVWriter csvWriter = new CSVWriter(writer);

            // Set user input
            EmpMem.SetEmpNumInput(EmpNumInput);
            EmpMem.SetDateInput(DateInput);
            EmpMem.SetReasonInput(ReasonInput);

            // Read existing data (if any)
            CSVReader csvReader = new CSVReader(new FileReader(file));
            List<String[]> existingData = csvReader.readAll();
            csvReader.close();

            // Check for duplicates
            String[] newData = new String[]{EmpMem.GetDateInput(), EmpMem.GetEmpNumInput(), EmpMem.GetReasonInput()};
            boolean isDuplicate = false;

            for (String[] row : existingData) {
                if (Arrays.equals(newData, row)) {
                    isDuplicate = true;
                    break;
                }
            }

            // Write to CSV file if not a duplicate
            if (!isDuplicate) {
                csvWriter.writeNext(newData);
                System.out.println("Data added to the CSV file.");
            } else {
                System.out.println("Duplicate data. Skipping addition to the CSV file.");
            }

            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.opencsv.exceptions.CsvException e) {
            e.printStackTrace();
        }
    }
}
