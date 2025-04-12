// PaymentRepository.java
package com.jisnamathew.spring.finalex.repository;

import com.jisnamathew.spring.finalex.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {}
