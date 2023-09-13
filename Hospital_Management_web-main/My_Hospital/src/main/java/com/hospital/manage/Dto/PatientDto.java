package com.hospital.manage.Dto;

import java.util.Date;
import java.util.List;

import com.hospital.manage.Enum.City;
import com.hospital.manage.entity.Admission;
import com.hospital.manage.entity.Problem;

import lombok.Data;

@Data
public class PatientDto {
	
	
	private Long patientId;
	private String firstName;
	private String lastName;
	private Date bornDate;
    private String phoneNo;
	private String gender;
	private String email;
	private City city;
	private List<Problem>problem;
	private List<Admission> admissions;

}
