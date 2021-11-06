package org.springframework.boot.store.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VoucherDTO {
	
	private Long number;
	private LocalDate forecastForDelivery;
	//private LocalDate forecastForDelivery;
}
