package com.security.springsecurity5.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.security.springsecurity5.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	// derived method name query
	List<Customer> findByEmail(String email);

}
