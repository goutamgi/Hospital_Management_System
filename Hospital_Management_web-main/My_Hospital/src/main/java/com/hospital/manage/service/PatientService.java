package com.hospital.manage.service;

import java.util.List;

import com.hospital.manage.Dto.PatientDto;

public interface PatientService {
	
	
	public PatientDto save(PatientDto patientDto);
	
	public PatientDto update(PatientDto patientDto, Long patientId);
	
	public void delete(Long patientId);
	
	public PatientDto getPatientById(Long patientId);
	
	public List<PatientDto> getAllPatients();

}
