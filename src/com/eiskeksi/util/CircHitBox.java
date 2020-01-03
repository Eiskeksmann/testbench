package com.eiskeksi.util;

import com.eiskeksi.entitiy.Entity;
import com.eiskeksi.logic.Direction;
import gherkin.lexer.En;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CircHitBox extends HitBox{

    private float r;

    public CircHitBox(Vector2f pos, float r){

        super.pos = pos;
        this.r = r;
        super.dsk = new DirSkeletton(pos, r);
        super.col = new ArrayList<>(dsk.getNesw());
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
        super.col = super.dsk.getNesw();
        return super.col;
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
    public void update(){
        super.dsk.update(super.pos);
    }
    public void input(MouseHandler mouse, KeyHandler key){

    }
    public void render(Graphics2D g, float interpolation){

        //TODO Visualize Hitboxes for Test Purposes
    }
}
