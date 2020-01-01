package com.eiskeksi.util;

import com.eiskeksi.logic.Direction;

import java.util.ArrayList;

public class DirSkeletton {

    Vector2f pos;
    ArrayList<Vector2f> nesw;
    String id;

    float r;
    float w;
    float h;

    public DirSkeletton(Vector2f pos, float r){

        id = "CIRC";
        this.r = r;
        this.pos = pos;
        nesw = new ArrayList<>();
        initSkeletton();
    }
    public DirSkeletton(Vector2f pos, float w, float h){

        id = "RECT";
        this.w = w;
        this.h = h;
        this.pos = pos;
        nesw = new ArrayList<>();
        initSkeletton();
    }

    public void setPos(Vector2f pos){

        this.pos = pos;
        initSkeletton();
    }

    private void initSkeletton(){

        nesw.clear();
        switch(id){

            case("CIRC"):
                //N
                nesw.add(new Vector2f( pos.x, pos.y - r));
                //NE
                nesw.add(new Vector2f( pos.x + r, pos.y - r));
                //E
                nesw.add(new Vector2f( pos.x + r, pos.y));
                //SE
                nesw.add(new Vector2f( pos.x + r, pos.y + r));
                //S
                nesw.add(new Vector2f( pos.x, pos.y + r));
                //SW
                nesw.add(new Vector2f( pos.x - r, pos.y - r));
                //W
                nesw.add(new Vector2f( pos.x - r, pos.y));
                //NW
                nesw.add(new Vector2f( pos.x - r, pos.y + r));
                return;
            case("RECT"):
                //N
                nesw.add(new Vector2f(pos.x + w/2, pos.y));
                //NE
                nesw.add(new Vector2f(pos.x + w, pos.y));
                //E
                nesw.add(new Vector2f(pos.x + w, pos.y + h/2));
                //SE
                nesw.add(new Vector2f(pos.x + w, pos.y + h));
                //S
                nesw.add(new Vector2f(pos.x + w / 2, pos.y + h));
                //SW
                nesw.add(new Vector2f(pos.x, pos.y + h));
                //W
                nesw.add(new Vector2f(pos.x, pos.y + h/2));
                //NW
                nesw.add(pos);
                return;
        }
    }
    public Vector2f translateVec(String dir){

        return nesw.get(Direction.translateDir(dir));
    }
}
