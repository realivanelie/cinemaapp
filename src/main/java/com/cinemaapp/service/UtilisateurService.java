package com.cinemaapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaapp.model.Utilisateur;
import com.cinemaapp.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.orElse(null); // Ou lancez une exception personnalisée
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
}
