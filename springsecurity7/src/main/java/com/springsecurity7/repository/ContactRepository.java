package com.springsecurity7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity7.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
