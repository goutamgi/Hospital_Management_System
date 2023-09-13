package com.hospital.manage.service;

import java.util.List;

import com.hospital.manage.Dto.StaffDto;

public interface StaffService {
	
	public StaffDto create(StaffDto staffDto);
	public void delete(Long staffid);
	public List<StaffDto>getAll();

}
