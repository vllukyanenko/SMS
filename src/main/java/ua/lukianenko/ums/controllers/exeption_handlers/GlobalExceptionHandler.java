package ua.lukianenko.ums.controllers.exeption_handlers;

import ua.lukianenko.ums.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Object> handleObjectNotExist(ObjectNotFoundException ex) {
    String errorMassage= String.format("Object not found [id=%s, objectType=%s]", ex.getObjectId(), ex.getObjectClass());
        return new ResponseEntity<>(errorMassage, HttpStatus.NOT_FOUND);
    }
}
