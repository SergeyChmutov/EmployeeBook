package pro.sky.employee.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.interfaces.DepartmentServiceInterface;
import pro.sky.employee.models.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceInterface departmentService;

    public DepartmentController(DepartmentServiceInterface departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryByDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.getEmployeeWithMaxSalaryByDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryByDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.getEmployeeWithMinSalaryByDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> EmployeesByDepartment(@RequestParam(value = "departmentId") Integer department) {
        return departmentService.getEmployeesByDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> EmployeesByDepartmentGroup() {
        return departmentService.getEmployeesGroupByDepartment();
    }

}
