public class Calculation {
    private AttendanceMemoryFile attendancemem;
    private LeaveFileReader leaveFileReader;
    private Employee employee;
    private String empNum;
    private String month;
    private double newsalary;

    public Calculation(AttendanceMemoryFile attendancemem, LeaveFileReader leaveFileReader, Employee employee) {
        this.attendancemem = attendancemem;
        this.leaveFileReader = leaveFileReader;
        this.employee = employee;
    }



    public double netsalary(AttendanceMemoryFile attendancemem, LeaveFileReader leaveFileReader, Employee employee, String empNum, String month) {

        this.attendancemem = attendancemem;
        this.employee = employee;
        this.leaveFileReader = leaveFileReader;
        this.empNum = empNum;
        this.month = month;
        newsalary = this.getStaticSalary();
        int leaveHours = leaveFileReader.getLeaveHours(empNum, month);
        double leaveDeduction = leaveHours * employee.getHourlyRate();
        newsalary -= leaveDeduction;
        System.out.println("Leave deduction: " + leaveDeduction);
        System.out.println("Static Salary: " + newsalary);

        if (newsalary >= 19250 && newsalary <= 19750) {
            newsalary = newsalary - 877.50;
            System.out.println("SSS deduction: 877.50");
        }
        if (newsalary >= 19751 && newsalary <= 20250) {
            newsalary = newsalary - 900;
            System.out.println("SSS deduction: 900");
        }
        if (newsalary >= 20251 && newsalary <= 20750) {
            newsalary = newsalary - 922.50;
            System.out.println("SSS deduction: 922.50");
        }
        if (newsalary >= 20751 && newsalary <= 21250) {
            newsalary = newsalary - 945;
            System.out.println("SSS deduction: 945");
        }
        if (newsalary >= 21251 && newsalary <= 21750) {
            newsalary = newsalary - 967.50;
            System.out.println("SSS deduction: 967.50");
        }
        if (newsalary >= 21751 && newsalary <= 22250) {
            newsalary = newsalary - 990;
            System.out.println("SSS deduction: 990");
        }
        if (newsalary >= 22251 && newsalary <= 22750) {
            newsalary = newsalary - 1012.50;
            System.out.println("SSS deduction: 1012.50");
        }
        if (newsalary >= 22751 && newsalary <= 23250) {
            newsalary = newsalary - 1035.00;
            System.out.println("SSS deduction: 1035.00");
        }
        if (newsalary >= 23251 && newsalary <= 23750) {
            newsalary = newsalary - 1057.50;
            System.out.println("SSS deduction: 1057.50");
        }
        if (newsalary >= 23751 && newsalary <= 24250) {
            newsalary = newsalary - 1080.00;
            System.out.println("SSS deduction: 1080.00");
        }
        if (newsalary >= 24251 && newsalary <= 24750) {
            newsalary = newsalary - 1102.50;
            System.out.println("SSS deduction: 1102.50");
        }
        if (newsalary >= 24751) {
            newsalary = newsalary - 1125.00;
            System.out.println("SSS deduction: 1125.00");
        }
        //Philheath deductions below
        if (this.employee.getBasicSalary() <= 59999.99) {
            double premiumrate = this.employee.getBasicSalary() * 0.03;
            double philhealthshare = premiumrate / 2;
            System.out.println("Philhealth deduction: " + premiumrate);
            newsalary = newsalary - (premiumrate + philhealthshare);
        }
        if (this.employee.getBasicSalary() > 60000) {
            double premiumrate = 1800;
            double philhealthshare = premiumrate / 2;
            System.out.println("Philhealth deduction: " + premiumrate);
            newsalary = newsalary - (premiumrate + philhealthshare);
        }
        //Pagibig deduction
        if (this.employee.getBasicSalary() > 0) {
            newsalary = newsalary - 100;
            System.out.println("Pagibig deduction: 100");
        }
        //Withholding tax below
        if (this.employee.getBasicSalary() <= 20832) {
            System.out.println("Witholding Tax: NONE");
        }
        if (this.employee.getBasicSalary() >= 20833 && this.employee.getBasicSalary() <= 33333) {
            double WithTax = (newsalary - 20833) * 0.2;
            newsalary -= WithTax; // Subtract the WithTax value from the newsalary
            System.out.println("Withholding Tax: " + WithTax);
        }
        if (this.employee.getBasicSalary() >= 33334 && this.employee.getBasicSalary() <= 66666) {
            double WithTax = ((newsalary - 33333) * 0.25) + 2500;
            newsalary -= WithTax; // Subtract the WithTax value from the newsalary
            System.out.println("Withholding Tax: " + WithTax);
        }
        if (this.employee.getBasicSalary() >= 66667 && this.employee.getBasicSalary() <= 166666) {
            double WithTax = ((newsalary - 66667) * 0.30) + 10833;
            newsalary -= WithTax; // Subtract the WithTax value from the newsalary
            System.out.println("Withholding Tax: " + WithTax);
        }
        if (this.employee.getBasicSalary() >= 166667 && this.employee.getBasicSalary() <= 666666) {
            double WithTax = ((newsalary - 166667) * 0.32) + 40833.33;
            newsalary -= WithTax; // Subtract the WithTax value from the newsalary
            System.out.println("Withholding Tax: " + WithTax);
        }
        if (this.employee.getBasicSalary() >= 666667) {
            double WithTax = ((newsalary - 666667) * 0.35) + 200833.33;
            newsalary -= WithTax; // Subtract the WithTax value from the newsalary
            System.out.println("Withholding Tax: " + WithTax);
        }
        return newsalary;
    }
    public double getNetSalary(LeaveFileReader leaveFileReader) {
        return netsalary(attendancemem, leaveFileReader, employee, empNum, month);
    }

    private double getStaticSalary() {
        return attendancemem.getStaticSalary();
    }
}