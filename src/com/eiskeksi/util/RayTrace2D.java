package com.eiskeksi.util;

import java.util.ArrayList;

public class RayTrace2D {

    private ArrayList<HitBox> hit;
    Vector2f pos;

    public RayTrace2D(Vector2f pos){

        this.pos = pos;
    }

    public ArrayList<HitBox> getHit(){

        hit = new ArrayList<>();
        return hit;
    }
}
