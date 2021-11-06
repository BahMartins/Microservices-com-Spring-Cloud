package br.com.alura.microservice.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.supplier.model.InfoSupplier;
import br.com.alura.microservice.supplier.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository inforRepository;
	
	
	public InfoSupplier getInfoByState(String state) {
		return inforRepository.findByState(state);
	}

}
