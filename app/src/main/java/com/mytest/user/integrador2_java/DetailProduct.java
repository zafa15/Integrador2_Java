package com.mytest.user.integrador2_java;

public class DetailProduct {

    private String addres;
    private int img_icon;

    public DetailProduct(){

    }

    public DetailProduct(String addres, int img_icon) {
        this.addres = addres;
        this.img_icon = img_icon;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getImg_icon() {
        return img_icon;
    }

    public void setImg_icon(int img_icon) {
        this.img_icon = img_icon;
    }
}
