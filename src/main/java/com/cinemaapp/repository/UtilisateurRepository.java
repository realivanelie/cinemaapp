package com.cinemaapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemaapp.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Trouver un utilisateur par email
    Optional<Utilisateur> findByEmail(String email);
}
