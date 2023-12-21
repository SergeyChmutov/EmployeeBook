package pro.sky.employee.interfaces;

import pro.sky.employee.models.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    Employee getEmployeeWithMaxSalaryByDepartment(Integer department);

    Employee getEmployeeWithMinSalaryByDepartment(Integer department);

    Collection<Employee> getEmployeesByDepartment(Integer department);

    Map<Integer, List<Employee>> getEmployeesGroupByDepartment();
}
