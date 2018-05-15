public class FixedPaidEmployee extends Employee {

    private double salary;

    public FixedPaidEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}