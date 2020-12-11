package com.vapasi.springbootmenu.controller;

import com.vapasi.springbootmenu.entity.Menu;
import com.vapasi.springbootmenu.request.MenuDto;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MenuControllerITTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldGetTheMenu() throws JSONException {
        String response = this.restTemplate.getForObject("/menu" , String.class);
        JSONAssert.assertEquals("[{name:Dosa} , {name:Idly} ,{name:Vada}]" , response , false);
    }

    @Test
    public void shouldSaveTheMenu() throws JSONException {
        MenuDto menuDto = new MenuDto("Noodles" , 200);
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("/menu" , menuDto , String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldDeleteTheMenu() throws JSONException {
        this.restTemplate.delete("/menu/Dosa");
        String response = this.restTemplate.getForObject("/menu" , String.class);
        System.out.println(response);
        JSONAssert.assertEquals("[{name:Idly} ,{name:Vada}]" , response , false);

    }
}
