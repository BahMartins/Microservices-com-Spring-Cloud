package org.springframework.boot.store.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.store.client.SupplierClient;
import org.springframework.boot.store.client.TransporterClient;
import org.springframework.boot.store.dto.DeliveryInfoDTO;
import org.springframework.boot.store.dto.PurchaseDTO;
import org.springframework.boot.store.dto.PurchaseInfoDTO;
import org.springframework.boot.store.dto.SupplierInfoDTO;
import org.springframework.boot.store.dto.VoucherDTO;
import org.springframework.boot.store.model.Order;
import org.springframework.boot.store.model.PurchaseState;
import org.springframework.boot.store.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
	
	@Autowired
	private SupplierClient supplierClient;
	
	@Autowired
	private TransporterClient transporterClient;

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	
	//@HystrixCommand
	public Order getById(Long id) {
		return purchaseRepository.findById(id).orElse(new Order());
	}
	
	public Iterable<Order> getAllOrders() {
		return purchaseRepository.findAll();
	}
	
	//@HystrixCommand(fallbackMethod = "makePurchaseFallBack", threadPoolkey = "makePurchaseThreadPool")
	public Order makePurchase(PurchaseDTO purchase) {
		
		Order saveOrder = new Order();
		saveOrder.setState(PurchaseState.RECEIVED);
		saveOrder.setDestinationAddress(purchase.getAddress().toString());
		purchaseRepository.save(saveOrder);
		
		SupplierInfoDTO infoSupplier = supplierClient.getInfoByState(purchase.getAddress().getState());
		PurchaseInfoDTO order = supplierClient.makeAOrder(purchase.getItems());
		saveOrder.setOrderId(order.getId());
		saveOrder.setPreparationTime(order.getPreparationTime());
		saveOrder.setState(PurchaseState.ORDER_PLACED);
		purchaseRepository.save(saveOrder);
		
		
		DeliveryInfoDTO deliveryDto = new DeliveryInfoDTO();
		deliveryDto.setOrderId(order.getId());
		deliveryDto.setDeliveryDate(LocalDate.now().plusDays(order.getPreparationTime()));
		deliveryDto.setOriginAddress(infoSupplier.getAddress());
		deliveryDto.setDestinationAddress(purchase.getAddress().toString());
		VoucherDTO voucher = transporterClient.reserveDelivery(deliveryDto);
		saveOrder.setDeliveryDate(voucher.getForecastForDelivery());
		saveOrder.setVoucher(voucher.getNumber());
		saveOrder.setState(PurchaseState.DELIVERY_RESERVATION_MADE);
		purchaseRepository.save(saveOrder);

		
		return saveOrder;
	}

	/*public Order makePurchaseFallBack(PurchaseDTO purchase) {
		Order orderFallback = new Order();
		orderFallback.setDestinationAddress(purchase.getAddress().toString());
		return orderFallback;
	}*/


}
