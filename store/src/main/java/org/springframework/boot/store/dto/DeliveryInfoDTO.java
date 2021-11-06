package org.springframework.boot.store.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DeliveryInfoDTO {
	
	private Long orderId;
	private LocalDate deliveryDate;
	private String originAddress;
	private String destinationAddress;
}
