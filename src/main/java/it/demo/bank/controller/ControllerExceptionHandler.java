package it.demo.bank.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import it.demo.bank.exceptions.ServiceException;



@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

  @ExceptionHandler(ServiceException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String, String> ssobeExceptionHandling(Exception ex, WebRequest request) {
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("message", ex.getLocalizedMessage());
	    errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
    return errorResponse;
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public Map<String, String> methodArgumentNotValidExceptionHandling(MethodArgumentNotValidException ex, WebRequest request) {
	    Map<String, String> errorResponse = new HashMap<>();
	    String errorMessage = "Cannot validate fields filling. ";
	    if(ex.getBindingResult() != null && ex.getBindingResult().getFieldErrors() != null) {
	    	for(FieldError fieldInError: ex.getBindingResult().getFieldErrors()) {
	    		errorMessage += fieldInError.getField() + ": " + fieldInError.getDefaultMessage() + ". ";
	    	}
	    }
	    errorResponse.put("message", errorMessage);
	    errorResponse.put("status", HttpStatus.BAD_REQUEST.toString());
    return errorResponse;
  }
}

