package com.eiskeksi.logic;

public class Mountain extends LogicTile {


    public Mountain(int x, int y){

        super.build = false;
        super.swim = false;
        super.walk = true;
        super.loc = new Grid(x, y);
    }
    public void lUpdate(){

    }
    public void lInput(){

    }
    public void lRender(){
        //TODO CREATE REDNER ANIMATION FOR MOUNTAIN TILE...
    }
}
