package br.com.alura.microservice.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.supplier.model.InfoSupplier;

@Repository
public interface InfoRepository extends JpaRepository<InfoSupplier, Long>{
	InfoSupplier findByState(String State);
}
