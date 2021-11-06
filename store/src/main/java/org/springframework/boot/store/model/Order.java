package org.springframework.boot.store.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private Long orderId;
	
	@Getter @Setter
	private Integer preparationTime;
	
	@Getter @Setter
	private String destinationAddress;
	
	@Getter @Setter
	private LocalDate deliveryDate;
	
	@Getter @Setter
	private Long voucher;
	
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	private PurchaseState state;

}
