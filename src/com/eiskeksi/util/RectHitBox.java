package com.eiskeksi.util;

import com.eiskeksi.entitiy.Entity;
import com.eiskeksi.logic.Grid;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.awt.*;
import java.util.ArrayList;

public class RectHitBox extends HitBox {

    //pos is on the left top corner of the Rectangle

    protected int w;
    protected int h;

    public RectHitBox(Grid pos, int w, int h){

        super.pos = pos;
        this.w = w;
        this.h = h;
        super.dsk = new DirSkeletton(pos, this.w, this.h);
        super.col = new ArrayList<>(dsk.getNesw());
    }

    public RectHitBox(Entity ent){

        //TODO: INITIATE HITBOX PREFFERED TO ENTITY VALUES
        super.ent = ent;
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
    protected ArrayList<Grid> getCollisionPoint(String dir) {
        super.col = super.dsk.getNesw();
        return super.col;
    }

    @Override
    protected boolean getSelected() {
        return false;
    }

    @Override
    protected Grid getPos() {
        return super.pos;
    }

    @Override
    protected void setPos(Grid pos) {

        super.pos = pos;
    }

    @Override
    public void update() {

        super.dsk.update(super.pos);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g, float interpolation) {

        if(super.isGetSelected()){

            g.setColor(new Color(0,0,255));
        }
        else{
            g.setColor(new Color(255,0,0));
        }

        g.drawRect(super.pos.getX(), super.pos.getY(), this.w, this.h);
    }
}
