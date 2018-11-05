package com.example.liangl.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/**
 * Created by cpekl-ddim-2 on 11/5/18.
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();

        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));;

    }

}