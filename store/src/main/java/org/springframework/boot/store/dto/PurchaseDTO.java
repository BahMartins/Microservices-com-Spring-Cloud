package org.springframework.boot.store.dto;

import java.util.List;

import lombok.Data;

@Data
public class PurchaseDTO {
	
	private List<ItemToBuyDTO> items;
	private AddressDTO address;
}
