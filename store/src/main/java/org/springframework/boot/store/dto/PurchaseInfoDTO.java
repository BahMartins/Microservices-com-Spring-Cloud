package org.springframework.boot.store.dto;

import lombok.Getter;
import lombok.Setter;

public class PurchaseInfoDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private Integer preparationTime;
}
