import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;


public class EmployeeLeaveApp {

    private static String employeeName;
    private static String filePath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int leaveLimit = 20; // Maximum leave limit

        System.out.print("Enter the number of leaves you want to apply for: ");
        int requestedLeaves = scanner.nextInt();
        int remainingLeaves = leaveLimit - requestedLeaves;
        if (remainingLeaves >= 0) {
            System.out.println("Leave application approved for " + employeeName);
            System.out.println("Remaining leave balance: " + remainingLeaves);
        } else {
            System.out.println("Insufficient leave balance. Leave application rejected.");
            System.out.println("Leave balance: " + leaveLimit);
        }
        scanner.close();
    }
    public static void readCSVFile(String filePath) throws CsvValidationException {
        EmployeeLeaveApp.filePath = filePath;
        try (CSVReader reader = new CSVReader(new FileReader("leavefile.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Process each line of the CSV file
                for (String value : nextLine) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}