package pro.sky.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotValidNameException extends RuntimeException {
    public EmployeeNotValidNameException(String message) {
        super(message);
    }
}
