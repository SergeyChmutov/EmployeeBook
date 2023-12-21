package pro.sky.employee.interfaces;

import pro.sky.employee.models.Employee;

import java.util.Collection;

public interface EmployeeServiceInterface {
    Employee add(String firstName, String lastName, Integer salary, Integer department);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getEmployees();
}
