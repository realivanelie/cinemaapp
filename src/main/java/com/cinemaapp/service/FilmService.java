package com.cinemaapp.service;

import org.springframework.stereotype.Service;
import com.cinemaapp.model.Film;
import com.cinemaapp.repository.FilmRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final List<Film> films;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
        this.films = filmRepository.findAll();
    }

    public List<Film> getAllFilms() {
        return films;
    }

    public Film getFilmById(Long id) {
        Optional<Film> film = filmRepository.findById(id);
        return film.orElse(null); // Ou lancez une exception personnalisée
    }

    public Film addFilm(Film film) {
        films.add(film);
        return filmRepository.save(film);
    }
}
