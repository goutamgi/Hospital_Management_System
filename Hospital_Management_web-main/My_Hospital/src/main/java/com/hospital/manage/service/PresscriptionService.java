package com.hospital.manage.service;

import java.util.List;

import com.hospital.manage.Dto.PresscriptionDto;

public interface PresscriptionService {
	
	public PresscriptionDto savePress(PresscriptionDto presscriptionDto);
	
	public void deletePress(Long receiptid);
	
	public List<PresscriptionDto> getAll();

}
