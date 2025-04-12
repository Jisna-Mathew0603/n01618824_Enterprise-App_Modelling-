// ReservationRepository.java
package com.jisnamathew.spring.finalex.repository;

import com.jisnamathew.spring.finalex.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {}
