import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Attendance {
    private String empN;
    private String LN;
    private String FN;
    private String monthdate;
    private LocalTime TimeIn;
    private LocalTime TimeOut;
    private int monthlyHours;

    public String getEmpN() {
        return empN;
    }

    public void setEmpN(String empN) {
        this.empN = empN;
    }

    public String getLN() {
        return LN;
    }

    public void setLN(String LN) {
        this.LN = LN;
    }

    public String getFN() {
        return FN;
    }

    public void setFN(String FN) {
        this.FN = FN;
    }

    public String getMonthdate() {
        return monthdate;
    }

    public void setMonthdate(String monthdate) {
        this.monthdate = monthdate;
    }

    public LocalTime getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.TimeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.TimeOut = timeOut;
    }

    public int getMonthlyHours() {
        return monthlyHours;
    }

    public void setMonthlyHours(int monthlyHours) {
        this.monthlyHours = monthlyHours;
    }

    public long getHoursWorked() {
        if (TimeIn != null && TimeOut != null) {
            Duration duration = Duration.between(TimeIn, TimeOut);
            return duration.toHours();
        } else {
            return 0; // Or any default value you prefer when the times are not set
        }
    }
}