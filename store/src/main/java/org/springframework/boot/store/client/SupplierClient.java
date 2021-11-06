package org.springframework.boot.store.client;

import java.util.List;

import org.springframework.boot.store.dto.ItemToBuyDTO;
import org.springframework.boot.store.dto.PurchaseInfoDTO;
import org.springframework.boot.store.dto.SupplierInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("supplier")
public interface SupplierClient {
	
	@RequestMapping("/info/{state}")
	SupplierInfoDTO getInfoByState(@PathVariable String state);

	@RequestMapping(method = RequestMethod.POST, value = "/order")
	PurchaseInfoDTO makeAOrder(List<ItemToBuyDTO> items);
	
}
