package com.cinemaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping
    public String about(Model model) {
        model.addAttribute("message", "Bienvenue sur la page À propos de notre site de cinéma.");
        return "aboutPage";
    }
}
