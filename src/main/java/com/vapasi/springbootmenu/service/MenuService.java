package com.vapasi.springbootmenu.service;

import com.vapasi.springbootmenu.entity.Menu;
import com.vapasi.springbootmenu.repository.MenuRepository;
import com.vapasi.springbootmenu.request.MenuDto;
import com.vapasi.springbootmenu.response.MenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public MenuResponse saveMenu(MenuDto menuDto) {
        Menu result = menuRepository.save(new Menu(menuDto.getName() , menuDto.getPrice()));
        return new MenuResponse(result.getName() , result.getPrice());
    }


    public List<MenuResponse> getMenu() {
        List<Menu> menuList = menuRepository.findAll();
        List<MenuResponse> listMenuResponse = new ArrayList();
        for (Menu menu : menuList){
            listMenuResponse.add(new MenuResponse(menu.getName() , menu.getPrice()));
        }
        return listMenuResponse;
    }

    public void deleteMenu(String name) {
        menuRepository.deleteByName(name);
    }
}
