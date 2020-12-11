package com.vapasi.springbootmenu.controller;

import com.vapasi.springbootmenu.request.MenuDto;
import com.vapasi.springbootmenu.response.MenuResponse;
import com.vapasi.springbootmenu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @PostMapping
    public MenuResponse saveMenu(@RequestBody MenuDto menuDto){
        return menuService.saveMenu(menuDto);
    }

    @GetMapping
    public List<MenuResponse> getMenu(){
       return menuService.getMenu();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteMenu(@PathVariable String name){
        menuService.deleteMenu(name);
        return new ResponseEntity("Deleted:"+name , HttpStatus.OK);
    }



}
