package br.com.alura.microservice.transporter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.transporter.model.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long>{

}
