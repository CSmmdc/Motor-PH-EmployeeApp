import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Attendance {
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

    public Date getTimeIn() {
        return TimeIn;
    }

    /**
     * Whenever we set the value of timein from the CSV file,
     * we are immediately converting the data from String to
     * Date.
     */
    public void setTimeIn(String timeIn) throws ParseException {
        TimeIn = this.dateFormatter.parse(timeIn);
    }

    public Date getTimeOut() {
        return TimeOut;
    }

    /**
     * Whenever we set the value of timeout from the CSV file,
     * we are immediately converting the data from String to
     * Date.
     */
    public void setTimeOut(String timeOut) throws ParseException {
        TimeOut = this.dateFormatter.parse(timeOut);
    }

    private String empN;
    private String LN;
    private String FN;
    private String monthdate;

    /**
     * We are representing TimeIn and TimeOut as dates, so we can compute
     * the hours worked represented by this Attendance.
     */
    private Date TimeIn;
    private Date TimeOut;

    /**
     * This is your date formatter within your Attendance class. Basically,
     * for each Attendance object you'll instantiate, you can have a formatter
     * that you can utilize. Refer to line 41 and 49.
     */
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:mm");

    /**
     * This is how we replace your computation in MyPanel for the
     */
    public int getHoursWorked() {
        return (this.TimeOut.getHours() - this.TimeIn.getHours()) - 1;
    }
}
}
