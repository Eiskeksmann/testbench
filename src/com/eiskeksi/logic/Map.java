package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;
import sun.rmi.runtime.Log;

import java.awt.*;

public class Map {

    Layer lay;

    public Map(Layer lay){

        this.lay = lay;
        lay.printLogicTileArray();
        System.out.println(lay.getX());
        System.out.println(lay.getY());
    }

    public void update(){

    }
    public void input(){

    }
    public void render(Graphics2D g, float interpolation){

        //TODO: RUN THIS RENDERING LOOP IN ANOTHER THREAD PLS...
        for(int i = 0; i < lay.getY(); i++){

            for(int j = 0; j < lay.getX(); j++){

                lay.getSat()[j][i].render(g, interpolation);
            }
        }
    }

}
