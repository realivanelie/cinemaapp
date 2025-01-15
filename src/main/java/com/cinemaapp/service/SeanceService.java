package com.cinemaapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinemaapp.model.Seance;
import com.cinemaapp.repository.SeanceRepository;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;
    private final List<Seance> seances;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
        this.seances = seanceRepository.findAll();
    }

  
    public List<Seance> getAllSeances() {
        Seance seance1 = new Seance();
        seance1.setId(1L);
        seance1.setDate("2024-12-20");
        seance1.setHeure("18:00");

        Seance seance2 = new Seance();
        seance2.setId(2L);
        seance2.setDate("2024-12-21");
        seance2.setHeure("20:00");

        return Arrays.asList(seance1, seance2);
    }


    public Seance getSeanceById(Long id) {
        Optional<Seance> seance = seanceRepository.findById(id);
        return seance.orElse(null); // Ou lancez une exception personnalisée
    }

    public Seance addSeance(Seance seance) {
        seances.add(seance);
        return seanceRepository.save(seance);
    }
    public List<Seance> findSeancesByFilmId(Long filmId) { 
        return seanceRepository.findByFilmId(filmId); 
    }
}
