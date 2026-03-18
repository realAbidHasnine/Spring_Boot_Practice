package com.REST_API.myRESTapi.exception;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {
    

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception{

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                                    ex.getMessage(),
                                    request.getDescription(false));


        return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
      ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                                    "Total Errors : " + ex.getErrorCount() + 
                                    ex.getFieldError().getDefaultMessage(),
                                    request.getDescription(false));

        //can use ex.getFieldError to fetch the message from Beans
        //error ex.count to show error count
        return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
   }

}
