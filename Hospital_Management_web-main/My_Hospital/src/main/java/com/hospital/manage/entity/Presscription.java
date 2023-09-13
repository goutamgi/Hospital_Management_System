package com.hospital.manage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="pressc")
public class Presscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AA_PATIENT_SEQ")
    @SequenceGenerator(sequenceName = "AA_PATIENT_SEQ", allocationSize = 1, name = "AA_PATIENT_SEQ")
	private Long receiptid;
	
	private String detail;
	private String barcode;
	private String drugdetail;
	private String usageDetail;
	private String deliverydate;
	private Long problemid;
	private Long patientid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="problem_id")
	private Problem problem;


}
