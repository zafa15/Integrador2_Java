package com.mytest.user.integrador2_java;

public class Article {
    String name;
    String description;
    int price;
    int stock;
    int img_url_final;
    String brand;
    String provider;

    public Article() {
    }

    public Article(String name, String description, int price, int stock, int img_url_final, String brand, String provider) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.img_url_final = img_url_final;
        this.brand = brand;
        this.provider = provider;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getImg_url_final() {
        return img_url_final;
    }

    public void setImg_url_final(int img_url_final) {
        this.img_url_final = img_url_final;
    }
}
