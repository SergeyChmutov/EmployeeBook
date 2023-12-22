package pro.sky.employee.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.interfaces.EmployeeServiceInterface;
import pro.sky.employee.models.Employee;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceInterface employeeService;

    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Integer salary,
            @RequestParam Integer department
    ) {
        return employeeService.add(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/employees")
    public Collection<Employee> addEmployee() {
        return employeeService.getEmployees();
    }

}
