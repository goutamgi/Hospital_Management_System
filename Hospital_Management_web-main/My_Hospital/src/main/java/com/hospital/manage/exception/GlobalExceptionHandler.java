package com.hospital.manage.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ApiResponse>patientNotFoundExceptionHandler(PatientNotFoundException pa){
		
	  String message=pa.getMessage();
	  ApiResponse apiResponse=new ApiResponse(message,false);
	  return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		
		Map<String, String>resp=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			resp.put(fieldName, message);
			
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StaffNotFoundException.class)
	public ResponseEntity<ApiResponse>staffNotFoundExceptionHandler(StaffNotFoundException pa){
		
	  String message=pa.getMessage();
	  ApiResponse apiResponse=new ApiResponse(message,false);
	  return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProblemNotFoundException.class)
	public ResponseEntity<ApiResponse>problemNotFoundExceptionHandler(ProblemNotFoundException pr){
		
	  String message=pr.getMessage();
	  ApiResponse apiResponse=new ApiResponse(message,false);
	  return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(PressNotFoundException.class)
	public ResponseEntity<ApiResponse>presstNotFoundExceptionHandler(PressNotFoundException pn){
		
	  String message=pn.getMessage();
	  ApiResponse apiResponse=new ApiResponse(message,false);
	  return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	

}
