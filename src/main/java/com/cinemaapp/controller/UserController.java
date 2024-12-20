package com.cinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cinemaapp.model.Utilisateur;
import com.cinemaapp.service.UtilisateurService;

@Controller
public class UserController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable Long id, Model model) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        model.addAttribute("utilisateur", utilisateur);
        return "profile";
    }
}
