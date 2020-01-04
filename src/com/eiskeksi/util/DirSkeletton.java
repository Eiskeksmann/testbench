package com.eiskeksi.util;

import com.eiskeksi.logic.Direction;
import com.eiskeksi.logic.Grid;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DirSkeletton {

    Grid pos;
    ArrayList<Grid> nesw;
    String id;

    boolean idle;

    private int r;
    private int w;
    private int h;

    public DirSkeletton(Grid pos, int r){

        id = "CIRC";
        idle = true;
        this.r = r;
        this.pos = pos;
        nesw = new ArrayList<>();
        initSkeletton();
    }
    public DirSkeletton(Grid pos, int w, int h){

        id = "RECT";
        idle = true;
        this.w = w;
        this.h = h;
        this.pos = pos;
        nesw = new ArrayList<>();
        initSkeletton();
    }

    public void setPos(Grid pos){

        this.pos = pos;
        initSkeletton();
    }

    private void initSkeletton(){

        nesw.clear();
        switch(id){

            case("CIRC"):
                //N
                nesw.add(new Grid( pos.getX(), pos.getY() - r));
                //NE
                nesw.add(new Grid( pos.getX() + r, pos.getY() - r));
                //E
                nesw.add(new Grid( pos.getX() + r, pos.getY()));
                //SE
                nesw.add(new Grid( pos.getX() + r, pos.getY() + r));
                //S
                nesw.add(new Grid( pos.getX(), pos.getY() + r));
                //SW
                nesw.add(new Grid( pos.getX() - r, pos.getY() - r));
                //W
                nesw.add(new Grid( pos.getX() - r, pos.getY()));
                //NW
                nesw.add(new Grid( pos.getX() - r, pos.getY() + r));
                return;
            case("RECT"):
                //N
                nesw.add(new Grid(pos.getX() + w/2, pos.getY()));
                //NE
                nesw.add(new Grid(pos.getX() + w, pos.getY()));
                //E
                nesw.add(new Grid(pos.getX() + w, pos.getY() + h/2));
                //SE
                nesw.add(new Grid(pos.getX() + w, pos.getY() + h));
                //S
                nesw.add(new Grid(pos.getX() + w / 2, pos.getY() + h));
                //SW
                nesw.add(new Grid(pos.getX(), pos.getY() + h));
                //W
                nesw.add(new Grid(pos.getX(), pos.getY() + h/2));
                //NW
                nesw.add(pos);
                return;
        }
    }
    public Grid translateVec(String dir){

        return nesw.get(Direction.translateDir(dir));
    }
    public ArrayList<Grid> getNesw(){

        return nesw;
    }

    //Routine
    public void update(Grid pos){

        if(!idle) {
            this.pos = pos;
            initSkeletton();
        }
    }
    public void input(MouseHandler mouse, KeyHandler key){

    }
    public void render(float interpolation){
        //only for test purposes
    }

    //TODO MOUSE CLICKS ON THIS HITBOX --> RETURN TRUE
    public boolean getSelected(){

        return false;
    }

}
