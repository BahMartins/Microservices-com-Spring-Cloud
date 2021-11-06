package br.com.alura.microservice.transporter.controller;

import br.com.alura.microservice.transporter.dto.DeliveryDTO;
import br.com.alura.microservice.transporter.dto.VoucherDTO;
import br.com.alura.microservice.transporter.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;

	@PostMapping
	public VoucherDTO reserveDelivery(@RequestBody DeliveryDTO deliveryDTO) {
		return deliveryService.reserveDelivery(deliveryDTO);
	}
}
