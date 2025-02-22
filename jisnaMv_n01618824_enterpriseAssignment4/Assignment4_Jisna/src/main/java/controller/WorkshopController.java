package controller;

import jakarta.validation.Valid;
import model.WorkshopRegistration;
import repository.WorkshopRegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class WorkshopController {

    @Autowired
    private WorkshopRegistrationRepository repository;

    // Show registration form
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("registration", new WorkshopRegistration());
        return "register";
    }

    // Handle form submission
    @PostMapping
    public String submitForm(@Valid @ModelAttribute("registration") WorkshopRegistration registration,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";  // Return form with error messages
        }

        repository.save(registration);
        return "success";
    }

    // Handle reset operation
    @GetMapping("/reset")
    public String resetForm(Model model) {
        model.addAttribute("registration", new WorkshopRegistration());
        return "register";
    }
}
