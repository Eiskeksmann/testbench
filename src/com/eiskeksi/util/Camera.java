package com.eiskeksi.util;

import com.eiskeksi.logic.Grid;


public class Camera {

    private Grid loc;

    public Camera(int x, int y, int w, int h){

        loc = new Grid(x, y);
    }

}
