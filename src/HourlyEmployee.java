public class HourlyEmployee extends Employee {

    private double rate;

    public HourlyEmployee(String name, double rate) {
        super(name);
        this.rate = rate;
    }

    @Override
    public double getSalary() {
        return 20.8*8*rate;
    }
}