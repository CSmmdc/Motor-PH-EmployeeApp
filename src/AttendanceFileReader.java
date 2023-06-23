import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.temporal.WeekFields;
import java.time.format.DateTimeParseException;

public class AttendanceFileReader {
    public static WeekMemory AttenFileRead(String inputmo, String inputnum, Attendance attendance) {
        ArrayList<Attendance> employeeAttendances = new ArrayList<>();
        WeekMemory Weekmem = new WeekMemory();
        ArrayList<Integer> weeklyHoursList = new ArrayList<>();
        String fileName = "./Attendance.csv";
        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        try {
            int inputmonth = Integer.parseInt(inputmo);
            String row2;
            reader2.readLine();
            int currentWeek = -1;
            int weekHours = 0;
            int totalHoursWorked = 0;

            while ((row2 = reader2.readLine()) != null) {
                String[] AttData = row2.split(",");
                System.out.println(row2);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

                LocalDate currentDate = LocalDate.parse(AttData[3], dateTimeFormatter);

                if (currentDate.getMonthValue() == inputmonth && inputnum.equals(AttData[0])) {
                    int weekNumber = currentDate.get(WeekFields.ISO.weekOfMonth());

                    if (currentWeek != weekNumber) {
                        if (currentWeek != -1) {
                            weeklyHoursList.add(weekHours);
                        }

                        currentWeek = weekNumber;
                        weekHours = 0;
                    }

                    Attendance atten = new Attendance();
                    atten.setEmpN(AttData[0]);
                    atten.setLN(AttData[1]);
                    atten.setFN(AttData[2]);
                    atten.setMonthdate(AttData[3]);
                    LocalTime timeIn = LocalTime.parse(AttData[4], timeFormatter);
                    LocalTime timeOut = LocalTime.parse(AttData[5], timeFormatter);
                    atten.setTimeIn(timeIn);
                    atten.setTimeOut(timeOut);
                    Duration duration = Duration.between(timeIn, timeOut);
                    long thehoursWorked = duration.toHours();
                    int monthlyHours = (int) thehoursWorked;
                    atten.setMonthlyHours(monthlyHours);

                    employeeAttendances.add(atten);
                    long hoursWorked = atten.getHoursWorked();
                    weekHours += hoursWorked;
                    totalHoursWorked += hoursWorked;
                }
            }

            if (currentWeek != -1) {
                weeklyHoursList.add(weekHours);
            }

            // Calculate monthly hours
            int monthlyHours = 0;
            for (int hours : weeklyHoursList) {
                monthlyHours += weekHours;
            }

            attendance.setMonthlyHours(totalHoursWorked);
            attendance.setMonthlyHours(monthlyHours);

            // Assign weekly hours to string variables
            String weeklyhour1 = "";
            String weeklyhour2 = "";
            String weeklyhour3 = "";
            String weeklyhour4 = "";
            String weeklyhour5 = "";

            for (int weekIndex = 0; weekIndex < weeklyHoursList.size(); weekIndex++) {
                int weeklyHoursValue = weeklyHoursList.get(weekIndex);
                switch (weekIndex) {
                    case 0:
                        Weekmem.setWeeklyhour1(Integer.toString(weeklyHoursValue));
                        break;
                    case 1:
                        Weekmem.setWeeklyhour2(Integer.toString(weeklyHoursValue));
                        break;
                    case 2:
                        Weekmem.setWeeklyhour3(Integer.toString(weeklyHoursValue));
                        break;
                    case 3:
                        Weekmem.setWeeklyhour4(Integer.toString(weeklyHoursValue));
                        break;
                    case 4:
                        Weekmem.setWeeklyhour5(Integer.toString(weeklyHoursValue));
                        break;
                }
            }

            // Print weekly hours
            for (int weekIndex = 0; weekIndex < weeklyHoursList.size(); weekIndex++) {
                System.out.println("Week " + (weekIndex + 1) + " Hours: " + weeklyHoursList.get(weekIndex));
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }
        return Weekmem;
    }
}