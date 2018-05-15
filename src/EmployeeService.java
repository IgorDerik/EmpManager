import java.io.*;
import java.util.Collections;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void printEmployeesInfo() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }

    public void sortEmpByDescSalary() {
        Collections.sort(employees);
    }

    public void printFirstFiveEmployeesInfo() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(employees.get(i));
            }
            System.out.println();
        }
        catch (IndexOutOfBoundsException exception) {
            System.out.println( "We have only "+employees.size()+" employees." );
            System.out.println();
        }
    }

    public void printThreeLastEmpId() {
        if (employees.size()>=3) {
            for (int i = employees.size() - 3; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                System.out.println(employee.getName() + " ID: " + employee.getId());
            }
            System.out.println();
        }
        else {
            System.out.println("We don't have 3 employees.");
        }
    }

    public void saveEmployeesToFile(String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(employees);

            out.close();
            file.close();

            System.out.println("Serialized");
        }
        catch(IOException e) {
            System.out.println("IOException is caught");
        }
    }

    private static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        else return "";
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> getEmployeesFromFile(String fileName, String requiredExtension) {

        List<Employee> result = null;

        if(!getFileExtension(fileName).equals(requiredExtension)) {
            System.out.println("Warning! File Format is not correct.");
        }

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            result = (List<Employee>) in.readObject();

            in.close();
            file.close();

            System.out.println("Deserialized");
        }

        catch(IOException ex) {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        return result;
    }

}
