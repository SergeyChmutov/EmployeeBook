package pro.sky.employee.constants;

import pro.sky.employee.models.Employee;

import java.util.Collections;
import java.util.List;

public class EmployeeConstants {
    // Good names
    public static final String EMPLOYEE_FIRSTNAME_1 = "Ivan";
    public static final String EMPLOYEE_LASTNAME_1 = "Ivanov";
    public static final String EMPLOYEE_FIRSTNAME_2 = "ivan";
    public static final String EMPLOYEE_LASTNAME_2 = "ivanov";
    public static final String EMPLOYEE_FIRSTNAME_3 = "Petr";
    public static final String EMPLOYEE_LASTNAME_3 = "petrov";
    public static final String EMPLOYEE_FIRSTNAME_4 = "Sergey";
    public static final String EMPLOYEE_LASTNAME_4 = "Sergeev";

    // Bad names
    public static final String EMPLOYEE_NULL_NAME = null;
    public static final String EMPLOYEE_EMPTY_NAME = "";
    public static final String EMPLOYEE_BLANK_NAME = " ";
    public static final String EMPLOYEE_BAD_FIRSTNAME = "Ivan1";
    public static final String EMPLOYEE_BAD_LASTNAME = "Ivanov_";

    // Good salary
    public static final Integer EMPLOYEE_SALARY_1 = 6_000;
    public static final Integer EMPLOYEE_SALARY_2 = 8_000;
    public static final Integer EMPLOYEE_SALARY_3 = 15_000;

    // Bad salary
    public static final Integer EMPLOYEE_NULL_SALARY = null;
    public static final Integer EMPLOYEE_ZERO_SALARY = 0;
    public static final Integer EMPLOYEE_NEGATIVE_SALARY = -5_000;

    // Good department
    public static final Integer EMPLOYEE_DEPARTMENT_1 = 1;
    public static final Integer EMPLOYEE_DEPARTMENT_2 = 2;
    public static final Integer EMPLOYEE_DEPARTMENT_3 = 3;

    // Bad department
    public static final Integer EMPLOYEE_NULL_DEPARTMENT = null;
    public static final Integer EMPLOYEE_ZERO_DEPARTMENT = 0;
    public static final Integer EMPLOYEE_NEGATIVE_DEPARTMENT = -4;
    public static final Integer EMPLOYEE_NOT_EXIST_DEPARTMENT = 4;

    // Employees list
    public static final List<Employee> EMPLOYEE_LIST = List.of(
            new Employee(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_1, EMPLOYEE_SALARY_1, EMPLOYEE_DEPARTMENT_1),

            new Employee(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_3, EMPLOYEE_SALARY_1, EMPLOYEE_DEPARTMENT_2),
            new Employee(EMPLOYEE_FIRSTNAME_1, EMPLOYEE_LASTNAME_4, EMPLOYEE_SALARY_2, EMPLOYEE_DEPARTMENT_2),

            new Employee(EMPLOYEE_FIRSTNAME_3, EMPLOYEE_LASTNAME_3, EMPLOYEE_SALARY_2, EMPLOYEE_DEPARTMENT_3),
            new Employee(EMPLOYEE_FIRSTNAME_3, EMPLOYEE_LASTNAME_4, EMPLOYEE_SALARY_3, EMPLOYEE_DEPARTMENT_3),
            new Employee(EMPLOYEE_FIRSTNAME_4, EMPLOYEE_LASTNAME_4, EMPLOYEE_SALARY_3, EMPLOYEE_DEPARTMENT_3)
    );
}
