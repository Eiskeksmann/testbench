package com.eiskeksi.util;

import com.eiskeksi.logic.Grid;
import com.eiskeksi.logic.LogicTile;

import java.util.ArrayList;

public class RayTrace2D {

    private ArrayList<HitBox> hit;
    private int x;
    private int y;

    public RayTrace2D(int x, int y){

        this.x = x;
        this.y = y;
    }
    public Grid convertedRasterPos(){
        return new Grid( this.x / Constant.TARGET_PIXEL, this.y / Constant.TARGET_PIXEL);
    }
    public ArrayList<HitBox> getHit(){

        hit = new ArrayList<>();
        return hit;
    }
}
