package com.cinemaapp.repository;

import com.cinemaapp.model.Utilisateur;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Trouver un utilisateur par email
    Optional<Utilisateur> findByEmail(String email);
}
