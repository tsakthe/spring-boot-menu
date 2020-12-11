package com.vapasi.springbootmenu.controller;

import com.vapasi.springbootmenu.response.MenuResponse;
import com.vapasi.springbootmenu.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@RunWith(SpringRunner.class)
public class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MenuService menuService;

    @Test
    public void shouldCreateMenu() throws Exception {
        when(menuService.saveMenu(any())).thenReturn(new MenuResponse("Dosa" , 50));
        mockMvc.perform(post("/menu")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Dosa\",\"price\":\"50\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Dosa\",\"price\":50}"));
    }

    @Test
    public void shouldGetMenu() throws Exception {
        when(menuService.getMenu()).thenReturn(Arrays.asList(new MenuResponse("Dosa", 50), new MenuResponse("Idly", 30), new MenuResponse("Vada", 15)));
        mockMvc.perform(get("/menu")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"Dosa\",\"price\":50},{\"name\":\"Idly\",\"price\":30},{\"name\":\"Vada\",\"price\":15}]"));

    }

    @Test
    public void shouldDeleteMenu() throws Exception {
        mockMvc.perform(delete("/menu")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"menu\",\"price\":\"200\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
