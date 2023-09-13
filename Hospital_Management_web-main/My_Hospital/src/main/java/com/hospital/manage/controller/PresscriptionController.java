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

import com.hospital.manage.Dto.PresscriptionDto;
import com.hospital.manage.exception.ApiResponse;
import com.hospital.manage.service.PresscriptionService;

@RestController
@RequestMapping("/api")
public class PresscriptionController {
	
	@Autowired
	private PresscriptionService presscriptionService;
	
	
	@PostMapping("/press")
	public ResponseEntity<PresscriptionDto> savePress(@RequestBody PresscriptionDto presscriptionDto) {
		PresscriptionDto savePress = presscriptionService.savePress(presscriptionDto);
		return new ResponseEntity<>(savePress,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{receiptid}")
	public ResponseEntity<ApiResponse>deletePress(@PathVariable Long receiptid){
		presscriptionService.deletePress(receiptid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted SuccessFully !!", true),HttpStatus.OK);
	}
	
	@GetMapping("/press/All")
	public ResponseEntity<List<PresscriptionDto>>getAllData(){
		List<PresscriptionDto> all = presscriptionService.getAll();
		return ResponseEntity.ok(all);
	}

}
