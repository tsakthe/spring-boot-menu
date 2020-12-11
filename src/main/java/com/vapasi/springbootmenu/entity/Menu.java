package com.vapasi.springbootmenu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;
    private Integer price;

    public Menu(){

    }

    public Menu(String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Menu(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) &&
                Objects.equals(price, menu.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
