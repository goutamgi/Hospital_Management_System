package com.hospital.manage.service;

import com.hospital.manage.Dto.ProblemDto;

public interface ProblemService {
	
	public ProblemDto savePatient(ProblemDto problemDto);
	
	public void deleteProblem(Long problemid);
	
	public ProblemDto findByProblemid(Long problemid);
	
	public ProblemDto updateProblem(ProblemDto problemDto, Long problemid);

}
