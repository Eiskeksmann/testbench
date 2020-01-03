package com.eiskeksi.util;

import java.util.ArrayList;

public class RayTrace2D {

    private ArrayList<HitBox> hit;
    private int x;
    private int y;

    public RayTrace2D(int x, int y){

        this.x = x;
        this.y = y;
    }

    public ArrayList<HitBox> getHit(){

        hit = new ArrayList<>();
        return hit;
    }
}
