package br.com.alura.microservice.supplier.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.supplier.dto.OrderItemDTO;
import br.com.alura.microservice.supplier.model.Order;
import br.com.alura.microservice.supplier.model.OrderItem;
import br.com.alura.microservice.supplier.model.Product;
import br.com.alura.microservice.supplier.repository.OrderRepository;
import br.com.alura.microservice.supplier.repository.ProductRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Order makeOrder(List<OrderItemDTO> products) {
		if(products == null) {
			return null;
		}
		
		List<OrderItem> orderItems = toOrderItem(products);
		Order order = new Order(orderItems);
		order.setPreparationTime(products.size());
		return orderRepository.save(order);
	}

	public Order getOrderById(Long id) {
		return this.orderRepository.findById(id).orElse(new Order());
	}
	
	private List<OrderItem> toOrderItem(List<OrderItemDTO> items) {
		
		List<Long> ordersIds = items
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> orderOfProducts = productRepository.findByIdIn(ordersIds);
		
		List<OrderItem> orderItems = items
				.stream()
				.map(item -> {
					Product product = orderOfProducts
							.stream()
							.filter(p -> p.getId() == item.getId())
							.findFirst()
							.get();
					
					OrderItem orderItem = new OrderItem();
					orderItem.setProduct(product);
					orderItem.setQuantity(item.getQuantity());
					return orderItem;
				})
				.collect(Collectors.toList());
		
		
		
		return orderItems;
	}
	
}
