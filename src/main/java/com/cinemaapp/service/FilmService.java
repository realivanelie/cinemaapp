package com.cinemaapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinemaapp.model.Film;
import com.cinemaapp.repository.FilmRepository;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final List<Film> films;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
        this.films = filmRepository.findAll();
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElse(null); // Ou lancez une exception personnalisée
    }

    public Film addFilm(Film film) {
        films.add(film);
        return filmRepository.save(film);
    }
}
