package br.com.alura.microservice.transporter.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private Long orderId;

	@Getter @Setter
	private LocalDate dateForFetch;

	@Getter @Setter
	private LocalDate forecastForDelivery;

	@Getter @Setter
	private String originAddress;

	@Getter @Setter
	private String destinationAddress;
}
