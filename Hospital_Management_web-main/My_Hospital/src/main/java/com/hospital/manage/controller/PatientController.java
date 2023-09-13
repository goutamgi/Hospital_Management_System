package com.hospital.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.manage.Dto.PatientDto;
import com.hospital.manage.exception.ApiResponse;
import com.hospital.manage.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping("/patient")
	public ResponseEntity<PatientDto>createPatient(@RequestBody PatientDto patientDto){
		PatientDto savePatients = patientService.save(patientDto);
		return new ResponseEntity<>(savePatients,HttpStatus.CREATED);
	}
	
	@PutMapping("/patient/{patientId}")
	public ResponseEntity<PatientDto>updatePatient(@RequestBody PatientDto patientDto,@PathVariable Long patientId){
		PatientDto updatePatients = patientService.update(patientDto, patientId);
		return ResponseEntity.ok(updatePatients);
	}
	
	@DeleteMapping("/patient/delete/{patientId}")
	public ResponseEntity<ApiResponse>deletePatient(@PathVariable Long patientId){
		patientService.delete(patientId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("SuccessFully Deleted !!",true),HttpStatus.OK);
	}
	
	@GetMapping("/patient/single/{patientId}")
	public ResponseEntity<PatientDto>getPatientById(@PathVariable Long patientId){
		PatientDto patientById = patientService.getPatientById(patientId);
		return ResponseEntity.ok(patientById);
	}
	
	@GetMapping("/patients")
	public ResponseEntity<List<PatientDto>>getAllPatient(){
		List<PatientDto> allPatients = patientService.getAllPatients();
		return ResponseEntity.ok(allPatients);
	}

}
