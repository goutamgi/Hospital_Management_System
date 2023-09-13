package com.hospital.manage.entity;

import java.util.Date;
import java.util.List;

import com.hospital.manage.Enum.City;
import com.hospital.manage.Enum.Department;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name="staffs")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "AA_PATIENT_SEQ")
	@SequenceGenerator(sequenceName = "AA_PATIENT_SEQ",allocationSize = 1,name = "AA_PATIENT_SEQ")
	private Long staffid;
	private String staffname;
	private String lastfname;
	private String gender;
	
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotEmpty(message = "Email cannot be empty")
	@Column(name="email",unique = true)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bornDate;
	@Enumerated(EnumType.STRING)
	private City city;
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Pattern(regexp = "\\+?[0-9]+", message = "Invalid phone number")
	private String mobile;
	
	@OneToMany(mappedBy = "staff",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Admission>admission;
	
	
	
	
}
