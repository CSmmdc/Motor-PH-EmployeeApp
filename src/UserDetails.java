import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.List;

public class UserDetails {
    public static final String FILE_PATH = System.getProperty("user.dir") + File.separator + "UserDetails.csv";

    public static void addUser(String username, String password) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, true));
            String[] record = {username, password};
            writer.writeNext(record);
            System.out.println("Account Added!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUser(String username, String password) {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
                List<String[]> records = reader.readAll();
                for (String[] record : records) {
                    if (record[0].equals(username) && record[1].equals(password)) {
                        reader.close();
                        return true;
                    }
                }
                reader.close();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return false;
    }
}