import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> eList = new ArrayList<>();
        eList.add(new HourlyEmployee("Andy",100));
        eList.add(new HourlyEmployee("Sammy",90));
        eList.add(new HourlyEmployee("Igor",800));
        eList.add(new FixedPaidEmployee("Anna",7000));
        eList.add(new FixedPaidEmployee("Mick",8000));
        eList.add(new HourlyEmployee("Bobby",100));
        eList.add(new HourlyEmployee("Aaron",100));

        EmployeeService employeeService = new EmployeeService(eList);
        employeeService.sortEmpByDescSalary();
        employeeService.printEmployeesInfo();
        employeeService.printFirstFiveEmployeesInfo();
        employeeService.printThreeLastEmpId();
        employeeService.saveEmployeesToFile("employees.bin");

        List<Employee> employeesFromFile = EmployeeService.getEmployeesFromFile("employees.bin", "bin");
        employeeService.setEmployees(employeesFromFile);
        employeeService.printEmployeesInfo();

    }

}
