// CustomerRepository.java
package com.jisnamathew.spring.finalex.repository;

import com.jisnamathew.spring.finalex.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {}
