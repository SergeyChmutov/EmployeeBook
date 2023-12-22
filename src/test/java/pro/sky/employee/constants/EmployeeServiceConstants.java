package pro.sky.employee.constants;

public class EmployeeServiceConstants {
    // Good names
    public static final String EMPLOYEE_FIRSTNAME_1 = "Ivan";
    public static final String EMPLOYEE_LASTNAME_1 = "Ivanov";
    public static final String EMPLOYEE_FIRSTNAME_2 = "ivan";
    public static final String EMPLOYEE_LASTNAME_2 = "ivanov";
    public static final String EMPLOYEE_FIRSTNAME_3 = "Petr";
    public static final String EMPLOYEE_LASTNAME_3 = "petrov";

    // Bad names
    public static final String EMPLOYEE_NULL_NAME = null;
    public static final String EMPLOYEE_EMPTY_NAME = "";
    public static final String EMPLOYEE_BLANK_NAME = " ";
    public static final String EMPLOYEE_BAD_FIRSTNAME = "Ivan1";
    public static final String EMPLOYEE_BAD_LASTNAME = "Ivanov_";

    // Good salary
    public static final Integer EMPLOYEE_SALARY = 8_000;

    // Bad salary
    public static final Integer EMPLOYEE_NULL_SALARY = null;
    public static final Integer EMPLOYEE_ZERO_SALARY = 0;
    public static final Integer EMPLOYEE_NEGATIVE_SALARY = -5_000;

    // Good department
    public static final Integer EMPLOYEE_DEPARTMENT = 1;

    // Bad department
    public static final Integer EMPLOYEE_NULL_DEPARTMENT = null;
    public static final Integer EMPLOYEE_ZERO_DEPARTMENT = 0;
    public static final Integer EMPLOYEE_NEGATIVE_DEPARTMENT = -4;
}
