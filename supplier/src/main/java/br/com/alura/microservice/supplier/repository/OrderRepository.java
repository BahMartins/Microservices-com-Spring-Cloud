package br.com.alura.microservice.supplier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.supplier.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
