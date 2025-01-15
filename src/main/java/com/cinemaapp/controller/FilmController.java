package com.cinemaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinemaapp.model.Film;
import com.cinemaapp.service.FilmService;

@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public String listFilms(Model model) {
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "filmsList"; // Nom de la vue sans l'extension .html
    }

    @GetMapping("/{id}")
    public String getFilmDetails(@PathVariable Long id, Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);
        return "filmDetails"; // Nom de la vue sans l'extension .html
    }
    @GetMapping("/film")
    public String showFilmsPage(Model model) {
        // Ajouter les films à afficher
        model.addAttribute("films", filmService.getAllFilms());
        return "index";  // Ou "film" selon ton nom de template
    }

}

