package com.hospital.manage.Dto;

import java.util.Date;

import com.hospital.manage.Enum.ProblemStatus;
import com.hospital.manage.entity.Patient;

import lombok.Data;

@Data
public class ProblemDto {
	
private Long Problemid;
	
	private String problemName;
	
	private String problemDetail;
	
	private Long patientid;
	
	private Long admissionid;
	
	private Date CreationDate;
	
	private ProblemStatus problemStatus;
	
	private Patient patient;

}
