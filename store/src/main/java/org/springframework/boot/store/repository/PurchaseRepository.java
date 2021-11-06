package org.springframework.boot.store.repository;

import org.springframework.boot.store.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository  extends CrudRepository<Order, Long>{
	
}
