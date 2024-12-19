package com.cinemaapp.service;

import org.springframework.stereotype.Service;
import com.cinemaapp.model.Seance;
import com.cinemaapp.repository.SeanceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;
    private final List<Seance> seances;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
        this.seances = seanceRepository.findAll();
    }

    public List<Seance> getAllSeances() {
        return seances;
    }

    public Seance getSeanceById(Long id) {
        Optional<Seance> seance = seanceRepository.findById(id);
        return seance.orElse(null); // Ou lancez une exception personnalisée
    }

    public Seance addSeance(Seance seance) {
        seances.add(seance);
        return seanceRepository.save(seance);
    }
}
