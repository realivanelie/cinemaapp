package com.cinemaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cinemaapp.model.Seance;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findByFilmId(Long filmId);
}
