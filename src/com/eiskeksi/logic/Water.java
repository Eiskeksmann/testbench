package com.eiskeksi.logic;

public class Water extends LogicTile {

    public Water(int x, int y){

        super.build = false;
        super.swim = true;
        super.walk = false;
        super.loc = new Grid(x, y);
    }
    public void lUpdate(){

    }
    public void lInput(){

    }
    public void lRender(){
        //TODO: CREATE RENDER ANIMATION FOR WATER TILES...

    }


}
