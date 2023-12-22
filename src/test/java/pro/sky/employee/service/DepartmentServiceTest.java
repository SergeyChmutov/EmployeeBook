package pro.sky.employee.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employee.exceptions.EmployeeNotFoundException;
import pro.sky.employee.models.Employee;
import pro.sky.employee.services.DepartmentService;
import pro.sky.employee.services.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.employee.constants.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService out;

    // check department valid values

    @Test
    public void shouldReturnThrowIllegalArgumentExceptionWhenDepartmentNotValid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> out.getEmployeesByDepartment(EMPLOYEE_NULL_DEPARTMENT)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> out.getEmployeesByDepartment(EMPLOYEE_NEGATIVE_DEPARTMENT)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> out.getEmployeesByDepartment(EMPLOYEE_ZERO_DEPARTMENT)
        );

        verify(employeeService, times(0)).getEmployees();
    }

    // getEmployeesByDepartment method

    @Test
    public void shouldReturnEmptyListWhenGetEmployeesByDepartmentCallAndDepartmentNotExist() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(emptyList(), out.getEmployeesByDepartment(EMPLOYEE_NOT_EXIST_DEPARTMENT));
    }

    @Test
    public void shouldReturnEmptyListWhenGetEmployeesByDepartmentCall() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(1, out.getEmployeesByDepartment(EMPLOYEE_DEPARTMENT_1).size());
        assertEquals(2, out.getEmployeesByDepartment(EMPLOYEE_DEPARTMENT_2).size());
        assertEquals(3, out.getEmployeesByDepartment(EMPLOYEE_DEPARTMENT_3).size());

        verify(employeeService, times(3)).getEmployees();
    }

    // getEmployeesGroupByDepartment method

    @Test
    public void shouldReturnEmptyMapWhenGetEmployeesGroupByDepartmentCallAndEmployeesListIsEmpty() {
        when(employeeService.getEmployees()).thenReturn(emptyList());

        Map<Integer, List<Employee>> actual = out.getEmployeesGroupByDepartment();

        assertEquals(0, actual.keySet().size());
    }

    @Test
    public void shouldReturnEmptyMapWhenGetEmployeesGroupByDepartmentCall() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);

        Map<Integer, List<Employee>> actual = out.getEmployeesGroupByDepartment();
        Map<Integer, List<Employee>> expected = EMPLOYEE_LIST.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));

        assertIterableEquals(expected.keySet(), actual.keySet());

        for (Map.Entry<Integer, List<Employee>> entry : expected.entrySet()) {
            Integer department = entry.getKey();
            List<Employee> employees = entry.getValue();
            assertIterableEquals(expected.get(department), employees);
        }
    }

    // getSalaryByDepartment methods

    @Test
    public void shouldReturnThrowEmployeeNotFoundExceptionWhenGetSalaryByDepartmentCallAndDepartmentNotExist() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);

        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryByDepartment(EMPLOYEE_NOT_EXIST_DEPARTMENT));
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalaryByDepartment(EMPLOYEE_NOT_EXIST_DEPARTMENT));
        assertThrows(EmployeeNotFoundException.class, () -> out.getSumSalaryByDepartment(EMPLOYEE_NOT_EXIST_DEPARTMENT));

        verify(employeeService, times(3)).getEmployees();
    }

    @Test
    public void shouldReturnMinSalaryWhenGetMinSalaryByDepartmentCall() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(EMPLOYEE_SALARY_1, out.getMinSalaryByDepartment(EMPLOYEE_DEPARTMENT_1));
        assertEquals(EMPLOYEE_SALARY_1, out.getMinSalaryByDepartment(EMPLOYEE_DEPARTMENT_2));
        assertEquals(EMPLOYEE_SALARY_2, out.getMinSalaryByDepartment(EMPLOYEE_DEPARTMENT_3));

        verify(employeeService, times(3)).getEmployees();
    }

    @Test
    public void shouldReturnMaxSalaryWhenGetMaxSalaryByDepartmentCall() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(EMPLOYEE_SALARY_1, out.getMaxSalaryByDepartment(EMPLOYEE_DEPARTMENT_1));
        assertEquals(EMPLOYEE_SALARY_2, out.getMaxSalaryByDepartment(EMPLOYEE_DEPARTMENT_2));
        assertEquals(EMPLOYEE_SALARY_3, out.getMaxSalaryByDepartment(EMPLOYEE_DEPARTMENT_3));

        verify(employeeService, times(3)).getEmployees();
    }

    @Test
    public void shouldReturnSumSalaryWhenGetSumSalaryByDepartmentCall() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(
                EMPLOYEE_SALARY_1,
                out.getSumSalaryByDepartment(EMPLOYEE_DEPARTMENT_1)
        );
        assertEquals(
                EMPLOYEE_SALARY_1 + EMPLOYEE_SALARY_2,
                out.getSumSalaryByDepartment(EMPLOYEE_DEPARTMENT_2)
        );
        assertEquals(
                EMPLOYEE_SALARY_2 + EMPLOYEE_SALARY_3 + EMPLOYEE_SALARY_3,
                out.getSumSalaryByDepartment(EMPLOYEE_DEPARTMENT_3)
        );

        verify(employeeService, times(3)).getEmployees();
    }
}
