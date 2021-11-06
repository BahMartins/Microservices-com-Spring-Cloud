package org.springframework.boot.store.dto;

import lombok.Data;

@Data
public class AddressDTO {
	
	private String street;
	private int number;
	private String state;

}
