package com.vapasi.springbootmenu.request;

public class MenuDto {
    String name;
    int price;

    public MenuDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
