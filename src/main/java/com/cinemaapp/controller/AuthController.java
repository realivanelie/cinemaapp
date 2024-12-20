package com.cinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cinemaapp.model.Utilisateur;
import com.cinemaapp.service.UtilisateurService;

@Controller
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Utilisateur utilisateur) {
        utilisateurService.addUtilisateur(utilisateur);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Ajouter la logique pour authentifier l'utilisateur
}
