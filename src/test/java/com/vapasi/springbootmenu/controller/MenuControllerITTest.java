package com.vapasi.springbootmenu.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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

    /*@Test
    public void shouldSaveTheMenu() throws JSONException {
        String response = this.restTemplate.postForObject("/menu" , String.class);
        JSONAssert.assertEquals("[{name:Dosa} , {name:Idly} ,{name:Vada}]" , response , false);
    }*/

    @Test
    public void shouldDeleteTheMenu() throws JSONException {
        this.restTemplate.delete("/menu/Dosa");

    }
}
