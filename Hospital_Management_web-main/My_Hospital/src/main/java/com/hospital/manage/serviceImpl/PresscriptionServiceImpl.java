package com.hospital.manage.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.manage.Dto.PresscriptionDto;
import com.hospital.manage.entity.Presscription;
import com.hospital.manage.exception.PressNotFoundException;
import com.hospital.manage.exception.ProblemNotFoundException;
import com.hospital.manage.repository.PresscriptionRepo;
import com.hospital.manage.service.PresscriptionService;
@Service
public class PresscriptionServiceImpl implements PresscriptionService{
	
	@Autowired
	private PresscriptionRepo presscriptionRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public PresscriptionDto savePress(PresscriptionDto presscriptionDto) {
	       Presscription press = presscriptionRepo.findById(presscriptionDto.getProblemid())
				.orElseThrow(()-> new ProblemNotFoundException("Presscription", "receiptid", presscriptionDto.getProblemid()));
	       modelMapper.map(presscriptionDto, press);
	       Presscription savedPresscription  = presscriptionRepo.save(press);
		return modelMapper.map(savedPresscription,PresscriptionDto.class);
	}

	@Override
	public void deletePress(Long receiptid) {
		presscriptionRepo.findById(receiptid).orElseThrow(()->new PressNotFoundException("Presscription", "receiptid", receiptid));
		presscriptionRepo.deleteById(receiptid);
	}

	@Override
	public List<PresscriptionDto> getAll() {
		List<Presscription> getAllData = presscriptionRepo.findAll();
		List<PresscriptionDto> all = getAllData.stream().map(press->modelMapper.map(press, PresscriptionDto.class)).collect(Collectors.toList());
		return all;
	}

}
