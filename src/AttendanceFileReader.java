import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class AttendanceFileReader(String inputmo) {

    public static void AttenFileRead(){
        ArrayList<Attendance> employeeAttendances = new ArrayList<Attendance>();

        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new FileReader("./Attendance.csv"));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        //Filereader Attendance.csv
        try {
            int inputmonth = Integer.parseInt(inputmo);
            String row2 = ",";
            reader2.readLine(); // Read the first line as that is the header of the CSV file
            while ((row2 = reader2.readLine()) != null) { //second file reader for attendance.csv
                String[] AttData = row2.split(",");
                System.out.println(row2);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate currentDate = LocalDate.parse(AttData[3], dateTimeFormatter);
                if (currentDate.getMonth() == Month.of(inputmonth) && inputnum.equals(AttData[0])) {
                    /**
                     * For every attendance row of the employee for the given month, create a new
                     * Attendance object from the Attendance class.
                     */
                    Attendance atten = new Attendance();

                    /**
                     * Notice how we are using setters here instead of directly assigning values
                     * to the attributes. This is the correct way of assigning values to a Java
                     * object.
                     */
                    atten.setEmpN(AttData[0]);
                    atten.setLN(AttData[1]);
                    atten.setFN(AttData[2]);
                    atten.setMonthdate(AttData[3]);
                    atten.setTimeIn(AttData[4]);
                    atten.setTimeOut(AttData[5]);

                    employeeAttendances.add(atten);

                    /**
                     * Instead of computing the hours worked here per row, we replaced it
                     * with a method inside Attendance class called getHoursWorked(). See
                     * definition in Attendance class and usage below.
                     */
//                            emp.HoursWorked += (TimeOut.getHours() - TimeIn.getHours()) - 1;
//                            emp.HoursWorked2 += (TimeOut.getHours() - TimeIn.getHours()) - 1;

                    /**
                     * Since we already have getStaticSalary() in Employee class, this is no
                     * longer needed.
                     */
//                            emp.staticsalary = emp.HoursWorked2 * emp.HourlyRate;
                }
            }
            /**
             * After reading the whole CSV class and getting all the attendance records for the given
             * employee number and month, all that's left are the following:
             *
             * 1. Total hours worked for the month
             * 2. Gross salary based on total hours worked and hourly rate
             */

            int totalHoursWorked = 0;

            /**
             * Use a for-loop to iterate over the employeeAttendances ArrayList
             */
            for (int index = 0; index < employeeAttendances.size(); index++) {
                /** Get one employeeAttendance object based on index */
                Attendance currentEmployeeAttendance = employeeAttendances.get(index);

                /** Call getHoursWorked() and add it to totalHoursWorked */
                totalHoursWorked += currentEmployeeAttendance.getHoursWorked();
            }

            /**
             * After getting total hours worked, set the value to Employee object using setter
             */
            emp.setHoursWorked(totalHoursWorked);

            /**
             * ===== NOTE =====
             * At this point, you now have an ArrayList full of Attendance objects. You can now process
             * it to get the weekly breakdown of hours and gross salary. The code below prints the weekly
             * hours for the first week of whatever chosen month you want.
             *
             * This assumes your ArrayList is sorted by date. PLEASE MAKE SURE IT IS.
             */
            ArrayList<Integer> weeklyHoursList = new ArrayList<>();

            int firstWeekHours = 0;

            /** Get first 7 days of the attendance list and add the hours worked to firstWeekHours */
            for (int dayIndex = 0; dayIndex < 7; dayIndex++) {
                /** If you're sure about the objects inside ArrayList, you can chain methods */
                firstWeekHours += employeeAttendances.get(dayIndex).getHoursWorked();
            }
            // Assuming each week consists of 6 working days
            int workingDaysPerWeek = 7;
            int totalWeeks = (employeeAttendances.size() + workingDaysPerWeek - 1) / workingDaysPerWeek; // Calculate the total number of weeks based on the number of attendance records

            // Process each week
            for (int weekIndex = 0; weekIndex < totalWeeks; weekIndex++) {
                int weekHours = 0;

                // Calculate the starting index and ending index for each week
                int startIndex = weekIndex * workingDaysPerWeek;
                int endIndex = Math.min(startIndex + workingDaysPerWeek, employeeAttendances.size());

                // Iterate over the attendance records within the current week
                for (int dayIndex = startIndex; dayIndex < endIndex; dayIndex++) {
                    weekHours += employeeAttendances.get(dayIndex).getHoursWorked();
                }
                weeklyHoursList.add(weekHours);

            }
            for (int dayIndex = 0; dayIndex < weeklyHoursList.size(); dayIndex++) {

                System.out.println("Week " + (dayIndex + 1) + " Hours: " + weeklyHoursList.get(dayIndex));
            }


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        catch (ParseException a) {
            // Handle the exception
            a.printStackTrace();
        }
    }
}
