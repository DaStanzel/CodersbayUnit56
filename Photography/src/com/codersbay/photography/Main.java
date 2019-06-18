package com.codersbay.photography;

public class Main {

    public static void main(String[] args) {


        Camera canon = new Camera();
        canon.setBrand("Canon");
        canon.setMegaPixel(24);
        canon.setDisplaySize(10);
        canon.setImageStabilizer(true);
        Objective o1 = new Objective();
        o1.setFocalLength(55,22);
        canon.setObjektiv1(o1);

        Camera nikon = new Camera();
        nikon.setBrand("Nikon");
        nikon.setMegaPixel(22);
        nikon.setDisplaySize(8);
        nikon.setImageStabilizer(true);
        Objective o2 = new Objective();
        o2.setFocalLength(55,22);
        nikon.setObjektiv1(o2);

        Camera lomo = new Camera();
        lomo.setBrand("Lomo");
        lomo.setMegaPixel(8);
        lomo.setDisplaySize(5);
        lomo.setImageStabilizer(false);
        Objective o3 = new Objective();
        o3.setFocalLength(55,22);
        lomo.setObjektiv1(o2);

        System.out.println(canon.takePhoto(100,true));
        System.out.println(nikon.takePhoto(200,false));
        System.out.println(lomo.takePhoto(300,true));

    }
}
