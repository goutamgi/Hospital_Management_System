package com.hospital.manage.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.manage.Dto.ProblemDto;
import com.hospital.manage.entity.Patient;
import com.hospital.manage.entity.Problem;
import com.hospital.manage.exception.PatientNotFoundException;
import com.hospital.manage.exception.ProblemNotFoundException;
import com.hospital.manage.repository.PatientRepo;
import com.hospital.manage.repository.ProblemRepo;
import com.hospital.manage.service.ProblemService;

@Service
public class ProblemServiceImpl implements ProblemService {
	
	@Autowired
	private ProblemRepo problemRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Override
	public ProblemDto savePatient(ProblemDto problemDto) {
		Patient patient = patientRepo.findById(problemDto.getPatientid()).orElseThrow(()->new PatientNotFoundException("Problem", "patientid", problemDto.getPatientid()));
		Problem problem = modelMapper.map(problemDto, Problem.class);
		problem.setPatientid(patient.getPatientId());
		Problem saveProblem = problemRepo.save(problem);
		ProblemDto problemDtos = modelMapper.map(saveProblem, ProblemDto.class);
		return problemDtos;
	}

	@Override
	public void deleteProblem(Long problemid) {
		Problem problem = problemRepo.findById(problemid).orElseThrow(()->new ProblemNotFoundException("Problem", "problemid", problemid));
		problemRepo.delete(problem);
	}

	@Override
	public ProblemDto findByProblemid(Long problemid) {
		 Problem problem = problemRepo.findById(problemid).orElseThrow(()->new ProblemNotFoundException("Problem", "problemid", problemid));
		ProblemDto ProblemById = modelMapper.map(problem, ProblemDto.class);
		return ProblemById;
	}

	@Override
	public ProblemDto updateProblem(ProblemDto problemDto, Long problemid) {
		Problem problem = problemRepo.findById(problemid).orElseThrow(()->new ProblemNotFoundException("Problem", "problemid", problemid));
		problem.setProblemDetail(problemDto.getProblemDetail());
		problem.setProblemName(problemDto.getProblemName());
		problem.setProblemStatus(problemDto.getProblemStatus());
		Problem saveProblem = problemRepo.save(problem);
		return modelMapper.map(saveProblem, ProblemDto.class);
	}
	
	
	
	
	
	

}
