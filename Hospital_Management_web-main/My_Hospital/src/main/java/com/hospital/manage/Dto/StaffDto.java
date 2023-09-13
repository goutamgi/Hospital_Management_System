package com.hospital.manage.Dto;

import java.util.Date;
import java.util.List;

import com.hospital.manage.Enum.Department;
import com.hospital.manage.entity.Admission;

import lombok.Data;

@Data
public class StaffDto {

	private Long staffid;
	private String staffname;
	private String lastfname;
	private String gender;
	private String email;
	private Date createdDate;
	private Date bornDate;
	private String mobile;
	private List<Admission>admission;
	private Department department;
}
