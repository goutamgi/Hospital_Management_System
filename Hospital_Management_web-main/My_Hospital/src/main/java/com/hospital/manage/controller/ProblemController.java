package com.hospital.manage.controller;

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

import com.hospital.manage.Dto.ProblemDto;
import com.hospital.manage.exception.ApiResponse;
import com.hospital.manage.service.ProblemService;

@RestController
@RequestMapping("/api/problem")
public class ProblemController {
	
	@Autowired
	private ProblemService problemService;
	
	@PostMapping("/")
	public ResponseEntity<ProblemDto>saveProblem(@RequestBody ProblemDto problemDto){
		ProblemDto savePatient = problemService.savePatient(problemDto);
		return  ResponseEntity.ok(savePatient);
	}
	
	@DeleteMapping("/{problemid}")
	public ResponseEntity<ApiResponse>deleteProblem(@PathVariable Long problemid){
		problemService.deleteProblem(problemid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted SuccessFully",true),HttpStatus.OK);
	}
	
	@GetMapping("/{problemid}")
	public ResponseEntity<ProblemDto>findByProblemId(@PathVariable Long problemid){
		ProblemDto findByProblem= problemService.findByProblemid(problemid);
		return ResponseEntity.ok(findByProblem);
	}
	
	@PutMapping("/update/{problemid}")
	public ResponseEntity<ProblemDto>updateProblem(@RequestBody ProblemDto problemDto,@PathVariable Long problemid){
		ProblemDto updateProblem = problemService.updateProblem(problemDto, problemid);
		return ResponseEntity.ok(updateProblem);
	}

}
