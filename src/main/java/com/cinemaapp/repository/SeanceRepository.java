package com.cinemaapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemaapp.model.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    // Trouver les séances d'un film
    List<Seance> findByFilmId(Long filmId);
}
