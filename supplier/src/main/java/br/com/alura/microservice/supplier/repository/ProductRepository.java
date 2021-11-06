package br.com.alura.microservice.supplier.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.supplier.model.Product;


@Repository
public interface ProductRepository  extends CrudRepository<Product, Long>{
	
	List<Product> findByState(String State);
	
	List<Product> findByIdIn(List<Long> id);
}
