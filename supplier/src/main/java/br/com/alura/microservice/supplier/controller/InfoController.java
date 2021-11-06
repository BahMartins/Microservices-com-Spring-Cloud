package br.com.alura.microservice.supplier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.supplier.model.InfoSupplier;
import br.com.alura.microservice.supplier.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/{state}")
	public InfoSupplier getInfoByState(@PathVariable String state) {
		return infoService.getInfoByState(state);
	}
	
	
	
}
