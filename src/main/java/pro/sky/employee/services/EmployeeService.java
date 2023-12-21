package pro.sky.employee.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employee.exceptions.EmployeeNotFoundException;
import pro.sky.employee.exceptions.EmployeeNotValidNameException;
import pro.sky.employee.interfaces.EmployeeServiceInterface;
import pro.sky.employee.models.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName, Integer salary, Integer department) {
        checkValidNames(firstName, lastName);
        String fullName = StringUtils.capitalize(firstName) + StringUtils.capitalize(lastName);
        Employee employee = employees.get(fullName);
        if (employee == null) {
            employee = new Employee(firstName, lastName, salary, department);
            employees.put(fullName, employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен в список сотрудников фирмы");
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        checkValidNames(firstName, lastName);
        String fullName = StringUtils.capitalize(firstName) + StringUtils.capitalize(lastName);
        Employee employee = employees.remove(fullName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в списке сотрудников фирмы");
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        checkValidNames(firstName, lastName);
        String fullName = StringUtils.capitalize(firstName) + StringUtils.capitalize(lastName);
        Employee employee = employees.get(fullName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в списке сотрудников фирмы");
        }
        return employee;
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void checkValidNames(String... names) {
        for (String name : names) {
            if (!StringUtils.isAlpha(name)) {
                throw new EmployeeNotValidNameException("Строка имени/фамилии должна содержать только символы");
            }
        }
    }
}