package com.jisnamathew.spring.finalex.controller;

import com.jisnamathew.spring.finalex.model.Reservation;
import com.jisnamathew.spring.finalex.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(savedReservation);
    }

    @GetMapping
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        return ResponseEntity.ok(reservations);
    }
}
