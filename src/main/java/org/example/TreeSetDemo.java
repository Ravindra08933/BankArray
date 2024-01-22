package org.example;
import java.util.TreeSet;
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Employee> employeeTreeSet = new TreeSet<>();

        // Add some employees
        employeeTreeSet.add(new Employee("John Doe", 101, 50000.0));
        employeeTreeSet.add(new Employee("Alice Smith", 102, 60000.0));
        employeeTreeSet.add(new Employee("Bob Johnson", 103, 55000.0));
        employeeTreeSet.add(new Employee("Eva Williams", 104, 58000.0));
        employeeTreeSet.add(new Employee("David Lee", 105, 52000.0));
    }
}
