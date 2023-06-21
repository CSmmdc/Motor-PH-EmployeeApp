public class Employee {
    String EmpNum;
    String FirstName;
    String LastName;
    String Address;
    String Birth;
    String Position;
    String Supervisor;
    String TimeIn;
    String TimeOut;
    String PhoneNum;
    String SSS;
    String PhilHealth;
    String TIN;
    String Pagibig;
    String Status;

    private double BasicSalary;
    float Rice;
    float PhoneMoney;
    float Clothes;
    float MonthlyRate;
    private double HourlyRate;

    public double getHourlyRate() {
        return HourlyRate;
    }

    public void setHourlyRate(double HourlyRate){
        this.HourlyRate = HourlyRate;
    }
    public double getBasicSalary() {
        return BasicSalary;
    }
    public void setBasicSalary(double salary) {
        this.BasicSalary = salary;
    }
}
