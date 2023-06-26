public class AttendanceMemoryFile {
    private Employee employee;
    private Attendance attendance;



    public AttendanceMemoryFile(Employee employee, Attendance attendance) {
        this.employee = employee;
        this.attendance = attendance;
    }


    public double getHourlyRate() {
        return employee.getHourlyRate();
    }


    public long getHoursWorked() {
        return attendance.getHoursWorked();
    }

    public double getStaticSalary(){
        return (this.attendance.getMonthlyHours() * this.getHourlyRate());
    }
}
