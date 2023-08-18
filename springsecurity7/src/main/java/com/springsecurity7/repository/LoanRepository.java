package com.springsecurity7.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity7.model.Loans;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
