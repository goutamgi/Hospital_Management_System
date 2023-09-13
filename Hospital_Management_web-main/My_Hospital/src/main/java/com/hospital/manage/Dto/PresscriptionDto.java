package com.hospital.manage.Dto;

import com.hospital.manage.entity.Problem;

import lombok.Data;

@Data
public class PresscriptionDto {
	
private Long receiptid;
	
	private String detail;
	private String barcode;
	private String drugdetail;
	private String usageDetail;
	private String deliverydate;
	private Long problemid;
	private Long patientid;
	private Problem problem;
	

}
