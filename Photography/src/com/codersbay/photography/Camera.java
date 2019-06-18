package com.codersbay.photography;

public class Camera {

    private int megaPixel;
    private int displaySize;
    private boolean imageStabilizer;
    private String brand;
    private Objective objective;

    //Constructor for the default values

    Camera(){
        this.megaPixel = 22;
        this.displaySize= 8;
        this.imageStabilizer = false;
        this.brand = "Canon";
        this.objective = new Objective(); //a new Objective-"blueprint" will be created, which must be filled with a real Objective
    }

    public Objective getObjektiv() {
        return objective;
    }

    public void setObjektiv1(Objective objektiv) {
        this.objective = objektiv;
    }


    public int getMegaPixel() {
        return megaPixel;
    }

    public void setMegaPixel(int megaPixel) {
        this.megaPixel = megaPixel;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public boolean isImageStabilizer() {
        return imageStabilizer;
    }

    public void setImageStabilizer(boolean imageStabilizer) {
        this.imageStabilizer = imageStabilizer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // initialize a new photo and print its values

    public String takePhoto (int p_pixel, boolean p_color) {

        Photo photo = new Photo(p_pixel, p_color);


        System.out.println("Your photo has got the number: "+photo.getId()+"\nYour photo has this size: "+photo.getP_pixel()*photo.getP_pixel()+"\nYour photo is colored: "+photo.isP_color()+"\nYour photo has got as many pixel: "+photo.getP_pixel());

        return "CLICK!!!!!";

    }


}
