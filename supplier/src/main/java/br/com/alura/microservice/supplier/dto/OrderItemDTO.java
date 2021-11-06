package br.com.alura.microservice.supplier.dto;

import lombok.Getter;
import lombok.Setter;

public class OrderItemDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private Integer quantity;

}
