package pro.sky.employee.services;

import org.springframework.stereotype.Service;
import pro.sky.employee.exceptions.EmployeeNotFoundException;
import pro.sky.employee.interfaces.DepartmentServiceInterface;
import pro.sky.employee.models.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public int getMaxSalaryByDepartment(Integer department) {
        Employee employeeWithMaxSalaryByDepartment = employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("В указанном департаменте нет сотрудников"));
        return employeeWithMaxSalaryByDepartment.getSalary();
    }

    @Override
    public int getMinSalaryByDepartment(Integer department) {
        Employee employeeWithMinSalaryByDepartment = employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("В указанном департаменте нет сотрудников"));
        return employeeWithMinSalaryByDepartment.getSalary();
    }

    @Override
    public int getSumSalaryByDepartment(Integer department) {
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
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartment() {
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }
}
