package org.springframework.boot.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.store.dto.PurchaseDTO;
import org.springframework.boot.store.model.Order;
import org.springframework.boot.store.service.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping
	public Iterable<Order> getOrders(){
		return purchaseService.getAllOrders();
	}
	
	
	@GetMapping("/{id}")
	public Order getById(@PathVariable("id") Long id) {
		return purchaseService.getById(id);
	}
	
	@PostMapping
	public Order buying(@RequestBody PurchaseDTO purchase) {
		return purchaseService.makePurchase(purchase);
	}

	
	
}
