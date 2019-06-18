package com.codersbay.photography;

import javax.swing.*;

public class Photo {
    private int p_pixel;
    private boolean p_color;
    private static int max_id;
    private int id;
    public Photo(int p_pixel, boolean p_color) {
        Photo.max_id++;
        this.id = Photo.max_id;
        this.p_color=p_color;
        this.p_pixel = p_pixel;
    }

    public int getP_pixel() {
        return p_pixel;
    }

    public void setP_pixel(int p_pixel) {
        this.p_pixel = p_pixel;
    }

    public boolean isP_color() {
        return p_color;
    }

    public void setP_color(boolean p_color) {
        this.p_color = p_color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
