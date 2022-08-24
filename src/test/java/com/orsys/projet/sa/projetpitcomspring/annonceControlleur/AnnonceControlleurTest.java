package com.orsys.projet.sa.projetpitcomspring.annonceControlleur;

import com.orsys.projet.sa.projetpitcomspring.controller.AnnonceControlleur;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AnnonceControlleurTest {

    private MockMvc mockMvc;

    @Test
    public void testRecupererAnnonces() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/annonces");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateHeureCreation").value("2022-07-01"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }




}
