package br.com.alura.microservice.transporter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.transporter.dto.DeliveryDTO;
import br.com.alura.microservice.transporter.dto.VoucherDTO;
import br.com.alura.microservice.transporter.model.Delivery;
import br.com.alura.microservice.transporter.repository.DeliveryRepository;

@Service
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository repository;

	public VoucherDTO reserveDelivery(DeliveryDTO deliveryDTO) {
		
		Delivery delivery = new Delivery();
		delivery.setForecastForDelivery(deliveryDTO.getDeliveryDate());
		delivery.setForecastForDelivery(deliveryDTO.getDeliveryDate().plusDays(1L));
		delivery.setDestinationAddress(deliveryDTO.getDestinationAddress());
		delivery.setOriginAddress(deliveryDTO.getOriginAddress());
		delivery.setOrderId(deliveryDTO.getOrderId());
		
		repository.save(delivery);
		
		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumber(delivery.getId());
		voucher.setForecastForDelivery(delivery.getForecastForDelivery());
		return voucher;
	}

}
