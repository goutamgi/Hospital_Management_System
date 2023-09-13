package com.hospital.manage.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.manage.Dto.PatientDto;
import com.hospital.manage.entity.Patient;
import com.hospital.manage.exception.PatientNotFoundException;
import com.hospital.manage.repository.PatientRepo;
import com.hospital.manage.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Override
	public PatientDto save(PatientDto patientDto) {
		Patient patient = modelMapper.map(patientDto, Patient.class);
		Patient savePatient = patientRepo.save(patient);
		return modelMapper.map(savePatient, PatientDto.class);
	}

	@Override
	public PatientDto update(PatientDto patientDto, Long patientId) {
		Patient patient = patientRepo.findById(patientId).orElseThrow(()->new PatientNotFoundException("Patient", "patientid", patientId));
		patient.setBornDate(patientDto.getBornDate());
		patient.setEmail(patientDto.getEmail());
		patient.setFirstName(patientDto.getFirstName());
		patient.setLastName(patientDto.getLastName());
		patient.setGender(patientDto.getGender());
		patient.setPhoneNo(patientDto.getPhoneNo());
		Patient updatePatient = patientRepo.save(patient);
		return modelMapper.map(updatePatient, PatientDto.class);
	}

	@Override
	public void delete(Long patientId) {
		Patient patient = patientRepo.findById(patientId).orElseThrow(()->new PatientNotFoundException("Patient", "patientid", patientId));
		patientRepo.delete(patient);
	}

	@Override
	public PatientDto getPatientById(Long patientId) {
		Patient patient = patientRepo.findById(patientId).orElseThrow(()->new PatientNotFoundException("Patient", "patientid", patientId));
		return modelMapper.map(patient, PatientDto.class);
	}

	@Override
	public List<PatientDto> getAllPatients() {
		List<Patient> getAll = patientRepo.findAll();
		List<PatientDto> getAllData = getAll.stream().map(patient->modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
		return getAllData;
	}

}
