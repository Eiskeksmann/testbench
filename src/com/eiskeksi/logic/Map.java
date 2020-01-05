package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;

import java.awt.*;

public class Map {

    Layer lay;
    boolean isRendered;

    public Map(Layer lay){

        this.lay = lay;
        isRendered = false;
    }

    public void update(){

    }
    public void input(){

    }
    public void render(Graphics2D g, float interpolation){

        for (int i = 0; i < lay.getY(); i++) {

            for (int j = 0; j < lay.getX(); j++) {

                lay.getSat()[j][i].render(g, interpolation);
            }
        }
    }

}
