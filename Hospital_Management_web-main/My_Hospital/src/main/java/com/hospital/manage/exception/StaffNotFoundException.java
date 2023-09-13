package com.hospital.manage.exception;

public class StaffNotFoundException extends RuntimeException {
	
	
	String resorceName;
	String fieldName;
	Long fieldValue;
	public StaffNotFoundException(String resorceName, String fieldName, Long fieldValue) {
		super(String.format("%s Not Found With %s : %s",resorceName,fieldName,fieldValue));
		this.resorceName = resorceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
	

}
