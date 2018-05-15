import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Employee implements Comparable<Employee>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);

    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee(String name) {
        this.name = name;
        this.id = AUTO_ID.getAndIncrement();
    }

    abstract double getSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + getSalary() +
                '}';
    }

    @Override
    public int compareTo(Employee otherEmployee) {

        int result = Double.compare(otherEmployee.getSalary(), this.getSalary());

        if (result==0) {
            result = this.getName().compareTo(otherEmployee.getName());
        }

        return result;
    }

}