import java.util.ArrayList;
import java.util.List;

public class PayrollTest {
    public static void main(String[] args) {
        Payroll<Employee> payroll = new Payroll<>();

        FullTimeEmployee ft = new FullTimeEmployee("FT01", "Ayşe", 120000);
        PartTimeEmployee pt = new PartTimeEmployee("PT01", "Mehmet", 50);

        pt.setHoursWorked(80);

        payroll.addEmployee(ft);
        payroll.addEmployee(pt);

        System.out.println("Ayşe's monthly salary: " + ft.calculatePay());
        System.out.println("Mehmet's monthly earnings: " + pt.calculatePay());

        System.out.println("Total payroll: " + payroll.calculateTotalPayroll());

        payroll.giveRaise("FT01", 10.0);
        payroll.giveRaise("PT01", 20.0);
        pt.setHoursWorked(80);

        System.out.println("After raise, Ayşe: " + payroll.calculatePayForEmployee("FT01"));
        System.out.println("After raise, Mehmet: " + payroll.calculatePayForEmployee("PT01"));
    }
}
interface Payable {
    public double calculatePay();
}

abstract class Employee implements Payable {
    private String id;
    private String name;
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
   public abstract double calculatePay();
}

class FullTimeEmployee extends Employee {
    private double annualSalary;
    public FullTimeEmployee(String id, String name, double salary) {
        super(id,name);
        this.annualSalary = salary;
    }
    public double calculatePay() {
        return annualSalary / 12.0;
    }
    public void giveRaise(double percent) {
        setAnnualSalary(getAnnualSalary() * (1 + percent / 100));
    }
    public double getAnnualSalary() {
        return annualSalary;
    }
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    public PartTimeEmployee(String id, String name, double rate) {
        super(id, name);
        this.hourlyRate = rate;
    }
    public double calculatePay(){
        return hourlyRate * hoursWorked;
    }
    public void setHoursWorked(int h) {
        this.hoursWorked = h;
    }
    public void giveRaise(double percent) {
        hourlyRate *= (1 + percent / 100);
    }
    public int getHoursWorked(){
        return this.hoursWorked;
    }
}

class Payroll<T extends Employee> {
    private List<T> employees = new ArrayList<>();
    public void addEmployee(T e) {
        employees.add(e);
    }
    public void removeEmployee(String id) {
       if(employees != null){
           employees.remove(findById(id));
       }
    }
    public T findById(String id) {
        if(employees!= null){
            for(int i = 0 ; i < employees.size() ; i++){
                if(employees.get(i).getId().equals(id)){
                    return employees.get(i);
                }
            }
        }
        return null;
    }
    public double calculateTotalPayroll() {
        double sum = 0;
        if(employees != null){
            for(int i = 0 ; i < employees.size() ; i++){
                sum += calculatePayForEmployee(employees.get(i).getId());
            }
        }
        return sum;
    }
    public double calculatePayForEmployee(String id) {
        if(findById(id) != null){
            return findById(id).calculatePay();
        }
        return 0;
    }
    public void giveRaise(String id, double percent) {
        if(findById(id) instanceof FullTimeEmployee){
            ((FullTimeEmployee) findById(id)).giveRaise(percent);
        }
        if(findById(id) instanceof PartTimeEmployee){
            ((PartTimeEmployee) findById(id)).giveRaise(percent);
        }
    }
}
