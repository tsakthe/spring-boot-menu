package com.vapasi.springbootmenu.repository;

import com.vapasi.springbootmenu.entity.Menu;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void shouldSaveTheMenu(){
        Menu menu = new Menu("Noodles" , 200);
        Menu menu2 = new Menu("Fried Rice" , 200);

        menuRepository.save(menu);
        menuRepository.save(menu2);

        assertEquals(5, menuRepository.findAll().size());

    }

    @Test
    public void shouldFindAllTheMenu(){
        List<Menu> menuList = menuRepository.findAll();
        assertEquals(3, menuList.size());
    }

    @Test
    public void shouldDeleteTheMenuByName(){
        menuRepository.deleteByName("Dosa");
        assertEquals(2 , menuRepository.findAll().size());
    }

}
