package com.cinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cinemaapp.model.Seance;
import com.cinemaapp.service.SeanceService;
import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @GetMapping
    public List<Seance> getAllSeances() {
        return seanceService.getAllSeances();
    }

    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Long id) {
        return seanceService.getSeanceById(id);
    }

    @PostMapping
    public Seance addSeance(@RequestBody Seance seance) {
        return seanceService.addSeance(seance);
    }
}
