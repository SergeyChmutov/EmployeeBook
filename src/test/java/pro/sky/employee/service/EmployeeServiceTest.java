package pro.sky.employee.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import pro.sky.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employee.exceptions.EmployeeNotFoundException;
import pro.sky.employee.exceptions.EmployeeNotValidNameException;
import pro.sky.employee.interfaces.EmployeeServiceInterface;
import pro.sky.employee.models.Employee;
import pro.sky.employee.services.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.employee.constants.EmployeeConstants.*;

public class EmployeeServiceTest {
    private final EmployeeServiceInterface out = new EmployeeService();

    // Tests for add method

    @Test
    public void shouldReturnEmployeeWhenAddMethodCallWithCapitalizedNames() {
        Employee expected = out.add(
                EMPLOYEE_FIRSTNAME_1,
                EMPLOYEE_LASTNAME_1,
                EMPLOYEE_SALARY_1,
                EMPLOYEE_DEPARTMENT_1
        );

        assertEquals(expected.getFirstName(), EMPLOYEE_FIRSTNAME_1);
        assertEquals(expected.getLastName(), EMPLOYEE_LASTNAME_1);
        assertEquals(expected.getSalary(), EMPLOYEE_SALARY_1);
        assertEquals(expected.getDepartment(), EMPLOYEE_DEPARTMENT_1);
    }

    @Test
    public void shouldReturnEmployeeWhenAddMethodCallWithNonCapitalizedNames() {
        Employee expected = out.add(
                EMPLOYEE_FIRSTNAME_2,
                EMPLOYEE_LASTNAME_2,
                EMPLOYEE_SALARY_1,
                EMPLOYEE_DEPARTMENT_1
        );

        assertEquals(expected.getFirstName(), StringUtils.capitalize(EMPLOYEE_FIRSTNAME_2));
        assertEquals(expected.getLastName(), StringUtils.capitalize(EMPLOYEE_LASTNAME_2));
        assertEquals(expected.getSalary(), EMPLOYEE_SALARY_1);
        assertEquals(expected.getDepartment(), EMPLOYEE_DEPARTMENT_1);
    }

    @Test
    public void shouldReturnThrowEmployeeAlreadyAddedExceptionWhenAddMethodCallWithAlreadyAddedEmployee() {
        out.add(
                EMPLOYEE_FIRSTNAME_2,
                EMPLOYEE_LASTNAME_2,
                EMPLOYEE_SALARY_1,
                EMPLOYEE_DEPARTMENT_1
        );

        assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_2,
                        EMPLOYEE_LASTNAME_2,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithBadFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(
                        EMPLOYEE_BAD_FIRSTNAME,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithNullFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(

                        EMPLOYEE_NULL_NAME,

                        EMPLOYEE_LASTNAME_1,

                        EMPLOYEE_SALARY_1,

                        EMPLOYEE_DEPARTMENT_1

                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithEmptyFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(
                        EMPLOYEE_EMPTY_NAME,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithBlankFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(
                        EMPLOYEE_BLANK_NAME,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithBadLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_BAD_LASTNAME,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithNullLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_NULL_NAME,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithEmptyLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_EMPTY_NAME,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenAddMethodCallWithBlankLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_BLANK_NAME,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowIllegalArgumentExceptionWhenAddMethodCallWithNullSalary() {
        assertThrows(
                IllegalArgumentException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_NULL_SALARY,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowIllegalArgumentExceptionWhenAddMethodCallWithZeroSalary() {
        assertThrows(
                IllegalArgumentException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_ZERO_SALARY,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowIllegalArgumentExceptionWhenAddMethodCallWithNegativeSalary() {
        assertThrows(
                IllegalArgumentException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_NEGATIVE_SALARY,
                        EMPLOYEE_DEPARTMENT_1
                )
        );
    }

    @Test
    public void shouldReturnThrowIllegalArgumentExceptionWhenAddMethodCallWithNullDepartment() {
        assertThrows(
                IllegalArgumentException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_NULL_DEPARTMENT
                )
        );
    }

    @Test
    public void shouldReturnThrowIllegalArgumentExceptionWhenAddMethodCallWithZeroDepartment() {
        assertThrows(
                IllegalArgumentException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_ZERO_DEPARTMENT
                )
        );
    }

    @Test
    public void shouldReturnThrowIllegalArgumentExceptionWhenAddMethodCallWithNegativeDepartment() {
        assertThrows(
                IllegalArgumentException.class,
                () -> out.add(
                        EMPLOYEE_FIRSTNAME_1,
                        EMPLOYEE_LASTNAME_1,
                        EMPLOYEE_SALARY_1,
                        EMPLOYEE_NEGATIVE_DEPARTMENT
                )
        );
    }

    // Tests for find method

    @Test
    public void shouldReturnEmployeeWhenFindMethodCallCapitalizedNames() {
        Employee employeeActual = out.add(
                EMPLOYEE_FIRSTNAME_1,
                EMPLOYEE_LASTNAME_1,
                EMPLOYEE_SALARY_1,
                EMPLOYEE_DEPARTMENT_1
        );
        Employee employeeExpected = out.find(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_1);

        assertEquals(employeeExpected, employeeActual);
    }

    @Test
    public void shouldReturnEmployeeWhenFindMethodCallNonCapitalizedNames() {
        Employee employeeActual = out.add(
                EMPLOYEE_FIRSTNAME_2,
                EMPLOYEE_LASTNAME_2,
                EMPLOYEE_SALARY_1,
                EMPLOYEE_DEPARTMENT_1
        );
        Employee employeeExpected = out.find(EMPLOYEE_FIRSTNAME_2, EMPLOYEE_LASTNAME_2);

        assertEquals(employeeExpected, employeeActual);
    }

    @Test
    public void shouldReturnThrowEmployeeNotFoundExceptionWhenFindMethodCallWithNotAddedEmployee() {
        assertThrows(
                EmployeeNotFoundException.class,
                () -> out.find(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenFindMethodCallWithNullFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.find(EMPLOYEE_NULL_NAME, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenFindMethodCallWithEmptyFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.find(EMPLOYEE_EMPTY_NAME, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenFindMethodCallWithBlankFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.find(EMPLOYEE_BLANK_NAME, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenFindMethodCallWithBadLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.find(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_BAD_LASTNAME)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenFindMethodCallWithNullLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.find(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_NULL_NAME)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenFindMethodCallWithEmptyLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.find(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_EMPTY_NAME)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenFindMethodCallWithBlankLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.find(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_BLANK_NAME)
        );
    }

    // Tests for remove method

    @Test
    public void shouldReturnEmployeeWhenRemoveMethodCallCapitalizedNames() {
        Employee employeeActual = out.add(
                EMPLOYEE_FIRSTNAME_1,
                EMPLOYEE_LASTNAME_1,
                EMPLOYEE_SALARY_1,
                EMPLOYEE_DEPARTMENT_1
        );
        Employee employeeExpected = out.remove(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_1);

        assertEquals(employeeExpected, employeeActual);
    }

    @Test
    public void shouldReturnEmployeeWhenRemoveMethodCallNonCapitalizedNames() {
        Employee employeeActual = out.add(
                EMPLOYEE_FIRSTNAME_2,
                EMPLOYEE_LASTNAME_2,
                EMPLOYEE_SALARY_1,
                EMPLOYEE_DEPARTMENT_1
        );
        Employee employeeExpected = out.remove(EMPLOYEE_FIRSTNAME_2, EMPLOYEE_LASTNAME_2);

        assertEquals(employeeExpected, employeeActual);
    }

    @Test
    public void shouldReturnThrowEmployeeNotFoundExceptionWhenRemoveMethodCallWithNotAddedEmployee() {
        assertThrows(
                EmployeeNotFoundException.class,
                () -> out.remove(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenRemoveMethodCallWithNullFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.remove(EMPLOYEE_NULL_NAME, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenRemoveMethodCallWithEmptyFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.remove(EMPLOYEE_EMPTY_NAME, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenRemoveMethodCallWithBlankFirstName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.remove(EMPLOYEE_BLANK_NAME, EMPLOYEE_LASTNAME_1)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenRemoveMethodCallWithBadLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.remove(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_BAD_LASTNAME)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenRemoveMethodCallWithNullLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.remove(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_NULL_NAME)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenRemoveMethodCallWithEmptyLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.remove(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_EMPTY_NAME)
        );
    }

    @Test
    public void shouldReturnThrowEmployeeNotValidNameExceptionWhenRemoveMethodCallWithBlankLastName() {
        assertThrows(
                EmployeeNotValidNameException.class,
                () -> out.remove(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_BLANK_NAME)
        );
    }

    // Tests for getEmployees method

    @Test
    public void shouldReturnEmptyCollectionWhenGetEmployeesMethodCallBeforeAddFirstElement() {
        assertIterableEquals(
                Collections.unmodifiableList(List.of()),
                out.getEmployees()
        );
    }

    @Test
    public void shouldReturnEmployeeCollectionWhenGetEmployeesMethodCall() {
        List<Employee> employeesActual = List.of(
                out.add(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_1, EMPLOYEE_SALARY_1, EMPLOYEE_DEPARTMENT_1),
                out.add(EMPLOYEE_FIRSTNAME_3, EMPLOYEE_LASTNAME_3, EMPLOYEE_SALARY_1, EMPLOYEE_DEPARTMENT_1),
                out.add(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_3, EMPLOYEE_SALARY_1, EMPLOYEE_DEPARTMENT_1),
                out.add(EMPLOYEE_FIRSTNAME_3, EMPLOYEE_LASTNAME_1, EMPLOYEE_SALARY_1, EMPLOYEE_DEPARTMENT_1)
        );
        Collection<Employee> employeesExpected = out.getEmployees();

        assertTrue(employeesExpected.size() == employeesActual.size()
                && employeesExpected.containsAll(employeesActual)
                && employeesActual.containsAll(employeesExpected));
    }
}
