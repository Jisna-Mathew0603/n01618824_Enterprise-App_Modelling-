package com.jisnamathew.spring.finalex.controller;

import com.jisnamathew.spring.finalex.model.Reservation;
import com.jisnamathew.spring.finalex.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationViewController {

    @Autowired
    private ReservationRepository reservationRepository; 

    // Mapping for showing the reservation form
    @GetMapping("/reservation")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation()); // Create a new Reservation object
        return "reservationForm"; 
    }

    // Mapping for handling form submission
    @PostMapping("/reservation")
    public String submitReservation(@ModelAttribute("reservation") Reservation reservation, Model model) {
        reservationRepository.save(reservation);
       
        model.addAttribute("reservation", reservation);
        return "reservationConfirmation";
    }
}
