public class AttendanceMemoryFile {
    private Employee employee;
    private Attendance attendance;


    // Constructor to initialize the Employee and Attendance objects
    public AttendanceMemoryFile(Employee employee, Attendance attendance) {
        this.employee = employee;
        this.attendance = attendance;
    }

    // Method to access the HourlyRate from Employee
    public double getHourlyRate() {
        return employee.getHourlyRate();
    }

    // Method to access the HoursWorked from Attendance
    public long getHoursWorked() {
        return attendance.getHoursWorked();
    }

    public double getStaticSalary(){
        return (this.attendance.getMonthlyHours() * this.getHourlyRate());
    }
}
