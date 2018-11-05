package com.example.liangl.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

/**
 * Created by cpekl-ddim-2 on 11/5/18.
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();

        //MockMvc mockMvc=
        assertEquals("home", controller.home());

    }

}