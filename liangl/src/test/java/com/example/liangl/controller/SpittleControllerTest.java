package com.example.liangl.controller;

import com.example.liangl.data.SpittleRepository;
import com.example.liangl.model.Spittle;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by cpekl-ddim-2 on 11/5/18.
 */
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository =
                mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE,20))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        Matchers.hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count ; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}