package com.hospital.manage.entity;

import java.util.Date;
import java.util.List;

import com.hospital.manage.Enum.ProblemStatus;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="problems")
public class Problem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "AA_PATIENT_SEQ")
	@SequenceGenerator(sequenceName = "AA_PATIENT_SEQ",allocationSize = 1,name = "AA_PATIENT_SEQ")
	@Column(name="problem_id")
	private Long problemid;
	
	private String problemName;
	
	private String problemDetail;
	
	@Enumerated(EnumType.STRING)
	private ProblemStatus problemStatus;
	
	private Long admissionid;
	
	private Long patientid;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreationDate;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patients_id")
	private Patient patient;
	
	@OneToMany(mappedBy = "problem",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Presscription> presscription;
	
}
