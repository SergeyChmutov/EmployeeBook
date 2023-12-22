package pro.sky.employee.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.employee.interfaces.DepartmentServiceInterface;
import pro.sky.employee.models.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceInterface departmentService;

    public DepartmentController(DepartmentServiceInterface departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> EmployeesByDepartment(@PathVariable("id") Integer department) {
        return departmentService.getEmployeesByDepartment(department);
    }

    @GetMapping("/{id}/salary/sum")
    public int sumSalaryByDepartment(@PathVariable("id") Integer department) {
        return departmentService.getSumSalaryByDepartment(department);
    }

    @GetMapping("/{id}/salary/max")
    public int maxSalaryByDepartment(@PathVariable("id") Integer department) {
        return departmentService.getMaxSalaryByDepartment(department);
    }

    @GetMapping("/{id}/salary/min")
    public int minSalaryByDepartment(@PathVariable("id") Integer department) {
        return departmentService.getMinSalaryByDepartment(department);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> EmployeesByDepartmentGroup() {
        return departmentService.getEmployeesGroupByDepartment();
    }

}
