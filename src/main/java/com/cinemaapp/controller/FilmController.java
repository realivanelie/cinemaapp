package com.cinemaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "index";
    }
}
