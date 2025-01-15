package com.cinemaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping
    public String contact(Model model) {
        model.addAttribute("message", "Contactez-nous à l'adresse suivante : contact@cinemaapp.com");
        return "contactPage"; // Nom du nouveau template
    }
}
