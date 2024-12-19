package com.cinemaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemaapp.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
    // Exemple de méthode personnalisée
    List<Film> findByGenre(String genre);
}
