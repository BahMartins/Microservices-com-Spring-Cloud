package br.com.alura.microservice.supplier.dto;

import lombok.Getter;
import lombok.Setter;

public class ReservationDTO {
	
	@Getter @Setter
	private Integer reservationId;
	
	@Getter @Setter
	private Integer preparationTime;
	

}
