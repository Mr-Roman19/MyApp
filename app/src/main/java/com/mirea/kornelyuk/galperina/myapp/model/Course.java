package com.mirea.kornelyuk.galperina.myapp.model;

public class Course {
    int id;
    String img, title, lvl, date, colour;

    public Course(int id, String img, String title, String lvl, String date, String colour) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.lvl = lvl;
        this.date = date;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
