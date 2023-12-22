package pro.sky.employee.services;

import org.springframework.stereotype.Service;
import pro.sky.employee.exceptions.EmployeeNotFoundException;
import pro.sky.employee.interfaces.DepartmentServiceInterface;
import pro.sky.employee.models.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public int getMaxSalaryByDepartment(Integer department) {
        checkValidDepartmentValue(department);
        Employee employeeWithMaxSalaryByDepartment = employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("В указанном департаменте нет сотрудников"));
        return employeeWithMaxSalaryByDepartment.getSalary();
    }

    @Override
    public int getMinSalaryByDepartment(Integer department) {
        checkValidDepartmentValue(department);
        Employee employeeWithMinSalaryByDepartment = employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("В указанном департаменте нет сотрудников"));
        return employeeWithMinSalaryByDepartment.getSalary();
    }

    @Override
    public int getSumSalaryByDepartment(Integer department) {
        checkValidDepartmentValue(department);
        List<Employee> employeesByDepartment = employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department).toList();
        if (employeesByDepartment.isEmpty()) {
            throw new EmployeeNotFoundException("В указанном департаменте нет сотрудников");
        }
        return employeesByDepartment.stream()
                .mapToInt(employee -> employee.getSalary())
                .sum();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Integer department) {
        checkValidDepartmentValue(department);
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartment() {
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }

    private void checkValidDepartmentValue(Integer department) {
        if (department == null || department <= 0) {
            throw new IllegalArgumentException("Значение подразделения не указано или указано неверно");
        }
    }
}
