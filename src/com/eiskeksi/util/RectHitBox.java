package com.eiskeksi.util;

import java.util.ArrayList;

public class RectHitBox extends HitBox {

    //pos is on the left top corner of the Rectangle
    private float w;
    private float h;

    public RectHitBox(Vector2f pos, float w, float h){

        super.pos = pos;
        this.w = w;
        this.h = h;
    }
    @Override
    protected boolean collide(HitBox col) {
        return false;
    }

    @Override
    protected double calcSize() {

        double a = w*h;
        return a;
    }

    @Override
    protected double calcPerimeter(){

        double p = 2*w + 2*h;
        return p;
    }

    @Override
    protected ArrayList<Vector2f> getCollisionPoint(String dir) {
        return null;
    }

    @Override
    protected boolean getSelected() {
        return false;
    }

    @Override
    protected Vector2f getPos() {
        return null;
    }

    @Override
    protected void setPos(Vector2f pos) {

    }

    @Override
    protected void update() {

    }

    @Override
    protected void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    protected void render() {

    }
}
