package com.eiskeksi.util;

import java.util.ArrayList;

public class CircHitBox extends HitBox{

    private float r;
    private DirSkeletton dsk;

    public CircHitBox(Vector2f pos, float r){

        super.pos = pos;
        this.r = r;
        this.dsk = new DirSkeletton(pos, r);
    }
    @Override
    protected boolean collide(HitBox col) {
        return false;
    }

    @Override
    protected double calcSize() {

        double a = Math.PI * r * r;
        return a;
    }
    @Override
    protected ArrayList<Vector2f> getCollisionPoint(String dir){

        ArrayList<Vector2f> col = new ArrayList<>();
        // 7 - 0 - 1
        // - - - - -
        // 6 - x - 2
        // - - - - -
        // 5 - 4 - 3
        switch(dir){

            case("NORTH"):
                // col.add(); // 6
                // col.add(); // 7
                // col.add(); // 0
                // col.add(); // 1
                // col.add(); // 2
                return null;
        }
        return null;
    }

    @Override
    protected double calcPerimeter(){

        double p = Math.PI * 2 * r;
        return p;
    }

    @Override
    protected boolean getSelected() {
        return false;
    }

    @Override
    protected Vector2f getPos() {
        return super.pos;
    }

    @Override
    protected void setPos(Vector2f pos) {

        super.pos = pos;
    }
    protected void update(){
        dsk.setPos(pos);
    }
    protected void input(MouseHandler mouse, KeyHandler key){

    }
    protected void render(){

    }
}
