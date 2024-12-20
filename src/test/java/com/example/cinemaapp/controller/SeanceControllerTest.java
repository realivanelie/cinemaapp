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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cinemaapp.controller.SeanceController;
import com.cinemaapp.model.Seance;
import com.cinemaapp.service.SeanceService;

public class SeanceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SeanceService seanceService;

    @InjectMocks
    private SeanceController seanceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(seanceController).build();
    }

    @Test
    void testListSeances() throws Exception {
        // Créez des données de test
        Seance seance1 = new Seance();
        seance1.setId(1L);
        seance1.setDate("2024-12-20");
        seance1.setHeure("18:00");

        Seance seance2 = new Seance();
        seance2.setId(2L);
        seance2.setDate("2024-12-21");
        seance2.setHeure("20:00");

        List<Seance> seanceList = Arrays.asList(seance1, seance2);

        // Simulez le service
        when(seanceService.getAllSeances()).thenReturn(seanceList);

        // Effectuez la requête et vérifiez le résultat
        mockMvc.perform(get("/seances"))
                .andExpect(status().isOk());
        verify(seanceService, times(1)).getAllSeances();
    }

    // Vous pouvez ajouter d'autres tests pour les fonctionnalités supplémentaires de SeanceController
}
