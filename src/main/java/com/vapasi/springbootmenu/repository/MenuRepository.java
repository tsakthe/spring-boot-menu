package com.vapasi.springbootmenu.repository;

import com.vapasi.springbootmenu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findByName(String name);
    Long deleteByName(String name);
}
