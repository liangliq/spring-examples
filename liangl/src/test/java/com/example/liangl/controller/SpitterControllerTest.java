package com.example.liangl.controller;

import com.example.liangl.data.SpitterRepository;
import com.example.liangl.model.Spitter;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        Spitter spitter =new Spitter(24L,"Jack","Wang","WJ","pwd11");
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register")).andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception{

        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("Jack","Wang","WJ","pwd11");
        Spitter saved = new Spitter(24L, "Jack","Wang","WJ","pwd11");
        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
        .param("firstname","Jack")
        .param("lastname","Wang")
        .param("username","WJ")
        .param("password","pwd11")).andExpect(redirectedUrl("/spitter/WJ"));
        verify(mockRepository,atLeastOnce()).save(unsaved);
    }
}