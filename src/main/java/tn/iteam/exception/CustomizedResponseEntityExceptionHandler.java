package tn.iteam.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tn.iteam.user.UserNotFoundException;

import java.time.LocalTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorsDetails> handleAllException(Exception ex, WebRequest request)
            throws Exception {

        ErrorsDetails errorsDetails = new ErrorsDetails(LocalTime.now(),
                ex.getMessage(), request.getDescription(false) );

        return new ResponseEntity<>(errorsDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorsDetails> handleUserException(Exception ex, WebRequest request)
            throws Exception {

        ErrorsDetails errorsDetails = new ErrorsDetails(LocalTime.now(),
                ex.getMessage(), request.getDescription(false) );

        return new ResponseEntity<>(errorsDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorsDetails errorsDetails = new ErrorsDetails(LocalTime.now(),
                ex.getFieldError().getDefaultMessage(), request.getDescription(false) );

        return new ResponseEntity<>(errorsDetails, HttpStatus.BAD_REQUEST);
    }


}

