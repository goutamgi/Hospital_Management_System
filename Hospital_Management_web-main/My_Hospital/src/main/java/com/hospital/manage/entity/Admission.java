package com.hospital.manage.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="admissions")
public class Admission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "AA_PATIENT_SEQ")
	@SequenceGenerator(sequenceName = "AA_PATIENT_SEQ",allocationSize = 1,name = "AA_PATIENT_SEQ")
	private Long admissionid;
	
	private Long patientId;
	
	private Long staffid;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@ManyToOne(optional = true,fetch = FetchType.LAZY)
	@JoinColumn(name="patients_id")
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "staffs_id")
	private Staff staff;

}
