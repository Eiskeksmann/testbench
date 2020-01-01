package com.eiskeksi.util;

import java.awt.*;
import java.util.ArrayList;

public class RectHitBox extends HitBox {

    //pos is on the left top corner of the Rectangle
    private float w;
    private float h;

    public RectHitBox(Vector2f pos, float w, float h){

        super.pos = pos;
        this.w = w;
        this.h = h;
        super.dsk = new DirSkeletton(pos, this.w, this.h);
        super.col = new ArrayList<>(dsk.getNesw());
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
        super.col = super.dsk.getNesw();
        return super.col;
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

        super.dsk.update(super.pos);
    }

    @Override
    protected void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    protected void render(Graphics2D g, float interpolation) {

        g.drawRect((int)super.pos.x, (int)super.pos.y, (int)this.w, (int)this.h);
    }
}
