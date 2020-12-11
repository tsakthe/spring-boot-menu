package com.vapasi.springbootmenu.service;

import com.vapasi.springbootmenu.entity.Menu;
import com.vapasi.springbootmenu.repository.MenuRepository;
import com.vapasi.springbootmenu.request.MenuDto;
import com.vapasi.springbootmenu.response.MenuResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {
    @Mock
    MenuRepository menuRepository;
    @InjectMocks
    MenuService menuService;

    @Test
    public void shouldReturnTheSavedMenu(){
        MenuResponse expectedMenuResponse = new MenuResponse("Noodles" ,300);
        Menu expectedMenu = new Menu( expectedMenuResponse.getName() , expectedMenuResponse.getPrice());
        when(menuRepository.save(any())).thenReturn(expectedMenu);

        MenuResponse actualMenuResponse = menuService.saveMenu(new MenuDto( "Noodles" , 300));

        assertEquals(expectedMenuResponse , actualMenuResponse);
        verify(menuRepository).save(expectedMenu);

    }

    @Test
    public void shouldReturnListOfMenu(){
        List<Menu> expectedMenuList = Arrays.asList(new Menu(1, "Dosa", 50), new Menu(2, "Idly", 30), new Menu(3, "Vada", 15));
        List<MenuResponse> expectedMenuResponseList = new ArrayList();
        for (Menu menu : expectedMenuList){
            expectedMenuResponseList.add(new MenuResponse(menu.getName() , menu.getPrice()));
        }
        when(menuRepository.findAll()).thenReturn(expectedMenuList);

        List<MenuResponse> actualMenuResponseList = menuService.getMenu();

        assertEquals(expectedMenuResponseList , actualMenuResponseList);
        verify(menuRepository).findAll();

    }

    @Test
    public void shouldDeleteTheMenu(){

        when(menuRepository.deleteByName(anyString())).thenReturn(1l);

        menuService.deleteMenu("Dosa");

        verify(menuRepository).deleteByName("Dosa");

    }
}
