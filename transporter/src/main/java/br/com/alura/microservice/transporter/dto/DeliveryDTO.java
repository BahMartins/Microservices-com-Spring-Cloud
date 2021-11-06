package br.com.alura.microservice.transporter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryDTO {

	private Long orderId;
	
	private LocalDate deliveryDate;
	
	private String originAddress;
	
	private String destinationAddress;
}
