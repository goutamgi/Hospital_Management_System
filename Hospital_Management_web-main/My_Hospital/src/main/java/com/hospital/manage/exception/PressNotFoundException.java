package com.hospital.manage.exception;

public class PressNotFoundException extends RuntimeException {
	

	String resourceName;
	String fieldName;
	Long fieldValue;
	
	public PressNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s Not Found With %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
