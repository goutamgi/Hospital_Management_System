package com.hospital.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.manage.Dto.StaffDto;
import com.hospital.manage.exception.ApiResponse;
import com.hospital.manage.repository.StaffRepo;
import com.hospital.manage.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping("/save")
	public ResponseEntity<StaffDto>savePatient(@RequestBody StaffDto staffDto){
		StaffDto createStaff = staffService.create(staffDto);
		return new ResponseEntity<>(createStaff,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{staffid}")
	public ResponseEntity<ApiResponse>deletePatient(@PathVariable Long staffid){
	    staffService.delete(staffid);
	    return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted SuccessFully !!",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StaffDto>> getAllstaff(){
		List<StaffDto> all = staffService.getAll();
		return ResponseEntity.ok(all);
	}

}
