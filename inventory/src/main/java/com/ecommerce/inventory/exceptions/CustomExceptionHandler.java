package com.ecommerce.inventory.exceptions;

import com.ecommerce.inventory.model.ErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorModel> handleAllExceptions(Exception ex, WebRequest request){
        ErrorModel errorModel=new ErrorModel(ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<ErrorModel> handleProductNotFoundExceptions(Exception ex, WebRequest request){
        ErrorModel errorModel=new ErrorModel(ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode,WebRequest request){
        ErrorModel errorModel=new ErrorModel(ex.getFieldError().getDefaultMessage(),request.getDescription(false));

        return new ResponseEntity<Object>(errorModel,HttpStatus.BAD_REQUEST);
    }
}
