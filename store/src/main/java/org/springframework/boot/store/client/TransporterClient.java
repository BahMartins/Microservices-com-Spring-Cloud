package org.springframework.boot.store.client;

import org.springframework.boot.store.dto.DeliveryInfoDTO;
import org.springframework.boot.store.dto.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("transporter")
public interface TransporterClient {
	
	@PostMapping("/delivery")
	VoucherDTO reserveDelivery(DeliveryInfoDTO deliveryDTO);

}
