package com.eiskeksi.logic;

public class Ground extends LogicTile{


    public Ground(int x, int y){

        super.build = false;
        super.walk = true;
        super.swim = false;
        super.loc = new Grid(x, y);
    }
    public void lUpdate(){

    }
    public void lInput(){

    }
    public void lRender(){
        //TODO CREATE RENDER ANIMATION FOR GROUND TILE...

    }
}
