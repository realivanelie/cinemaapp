package com.cinemaapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinemaapp.model.User;
import com.cinemaapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("error", false);
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        logger.info("Tentative de connexion pour l'utilisateur avec email: {}", email);
        User user = userService.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            logger.warn("Email ou mot de passe incorrect pour l'utilisateur avec email: {}", email);
            model.addAttribute("error", true);
            return "login";
        }
        // Ajouter l'utilisateur à la session
        session.setAttribute("user", user);
        logger.info("Utilisateur connecté avec succès: {}", email);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("error", false);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("nom") String nom, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        logger.info("Tentative d'inscription pour l'utilisateur avec email: {}", email);
        if (userService.findByEmail(email) != null) {
            logger.warn("Cet email est déjà utilisé: {}", email);
            model.addAttribute("error", true);
            return "register";
        }
        User user = new User();
        user.setNom(nom);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userService.save(user);
        logger.info("Utilisateur enregistré avec succès: {}", email);
        return "redirect:/login";
    }
}
