package com.hospital.manage.exception;

public class PatientNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	Long fieldValue;
	
	public PatientNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s Not Found With %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	

}
