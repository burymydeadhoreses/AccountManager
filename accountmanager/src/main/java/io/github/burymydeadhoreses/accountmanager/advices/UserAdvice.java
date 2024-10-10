package io.github.burymydeadhoreses.accountmanager.advices;

import io.github.burymydeadhoreses.accountmanager.exceptions.UserExistsException;
import io.github.burymydeadhoreses.accountmanager.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String employeeNotFoundHandler(UserExistsException ex) {
        return ex.getMessage();
    }
}
