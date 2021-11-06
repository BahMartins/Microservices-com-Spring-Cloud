package br.com.alura.microservice.transporter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VoucherDTO {

	private Long number;
	
	private LocalDate forecastForDelivery;
}
