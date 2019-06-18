package com.codersbay.photography;


public class Objective {

    // set variables for the objective

    private int focalLengthMin;
    private int focalLengthMax;

    //set a default value for the objective-variables

    Objective(){
        focalLengthMin = 22;
        focalLengthMax = 55;
    }

    //test if the maximum is the bigger number and the minimum is the smaller number

    public void setFocalLength(int focalLengthMin, int focalLengthMax) {
        if (focalLengthMin < focalLengthMax) {
            this.focalLengthMin = focalLengthMin;
        }
        if (focalLengthMax > focalLengthMin) {
            this.focalLengthMax = focalLengthMax;
        }
    }

    public int getFocalLengthMin() {
        return focalLengthMin;
    }

    public int getFocalLengthMax() {
        return focalLengthMax;
    }

}
