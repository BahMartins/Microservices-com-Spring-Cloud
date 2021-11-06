package br.com.alura.microservice.supplier.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private Integer preparationTime;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	@Getter @Setter
	private List<OrderItem> items;
	
	public Order() {}

	public Order(List<OrderItem> items) {
		this.items = items;
		this.status = OrderStatus.RECEIVED;
	}
	
}
