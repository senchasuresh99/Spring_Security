package com.springsecurity7.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity7.model.AccountTransactions;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {
	
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
