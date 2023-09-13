package com.hospital.manage.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.manage.Dto.StaffDto;
import com.hospital.manage.entity.Staff;
import com.hospital.manage.exception.StaffNotFoundException;
import com.hospital.manage.repository.StaffRepo;
import com.hospital.manage.service.StaffService;
@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepo staffRepo;
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public StaffDto create(StaffDto staffDto) {
		staffDto.setCreatedDate(new Date());
		Staff staff = modelMapper.map(staffDto, Staff.class);
		staffRepo.save(staff);
		return modelMapper.map(staff, StaffDto.class);
	}

	@Override
	public void delete(Long staffid) {
		Staff staff = staffRepo.findById(staffid).orElseThrow(()->new StaffNotFoundException("Staff", "staffid", staffid));
		staffRepo.delete(staff);
	}

	@Override
	public List<StaffDto> getAll() {
		List<Staff> getAll = staffRepo.findAll();
		List<StaffDto> staffAll = getAll.stream().map(staff->modelMapper.map(staff, StaffDto.class)).collect(Collectors.toList());
		return staffAll;
	}

}
