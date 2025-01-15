package com.example.cinemaapp.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cinemaapp.controller.FilmController;
import com.cinemaapp.model.Film;
import com.cinemaapp.service.FilmService;

public class FilmControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FilmService filmService;

    @InjectMocks
    private FilmController filmController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(filmController).build();
    }

    @Test
    void testListFilms() throws Exception {
        // Créez des données de test
        Film film1 = new Film();
        film1.setId(1L);
        film1.setTitle("Film 1");
        film1.setDescription("Description du Film 1");

        Film film2 = new Film();
        film2.setId(2L);
        film2.setTitle("Film 2");
        film2.setDescription("Description du Film 2");

        List<Film> filmList = Arrays.asList(film1, film2);

        // Simulez le service
        when(filmService.getAllFilms()).thenReturn(filmList);

        // Effectuez la requête et vérifiez le résultat
        mockMvc.perform(get("/films"))
                .andExpect(status().isOk())
                .andExpect(view().name("filmsList"))
                .andExpect(model().attributeExists("films"))
                .andExpect(model().attribute("films", filmList));
        
        verify(filmService, times(1)).getAllFilms();
    }

    // Ajoutez d'autres tests si nécessaire
}
