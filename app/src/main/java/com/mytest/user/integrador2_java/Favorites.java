package com.mytest.user.integrador2_java;

public class Favorites {
    int id_user;
    int id_article;
    String [] article;

    public Favorites(int id_user, int id_article, String[] article) {
        this.id_user = id_user;
        this.id_article = id_article;
        this.article = article;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String[] getArticle() {
        return article;
    }

    public void setArticle(String[] article) {
        this.article = article;
    }


}
