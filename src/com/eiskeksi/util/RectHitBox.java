package com.eiskeksi.util;

import com.eiskeksi.entitiy.Carrier;
import com.eiskeksi.entitiy.Entity;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Grid;
import com.eiskeksi.logic.LogicTile;

import java.awt.*;
import java.util.ArrayList;

public class RectHitBox extends HitBox {

    //pos is on the left top corner of the Rectangle

    private int w;
    private int h;

    private Grid real;

    boolean isReal;

    Grid[][] hitpoints;

    public RectHitBox(LogicTile log, Sprite spr, Grid pos, int w, int h){

        super.spr = spr;
        super.pos = pos;
        this.w = w;
        this.h = h;
        this.isReal = true;
        super.dsk = new DirSkeletton(pos, this.w, this.h);
        super.col = new ArrayList<>(dsk.getNesw());
        super.isSelected = false;
        initReal();
    }
    public RectHitBox(Carrier car, Sprite spr, Grid pos, int w, int h){

        super.spr = spr;
        super.pos = pos;
        this.w = w;
        this.h = h;
        this.isReal = false;
        super.dsk = new DirSkeletton(pos, this.w, this.h);
        super.col = new ArrayList<>(dsk.getNesw());
        super.isSelected = false;
        initReal();
    }
    public void initReal(){

        if(isReal){

            real = super.pos;
            hitpoints = new Grid[w][h];

            for(int i = 0; i < w; i++){

                for(int j = 0; j < h; j++){

                    hitpoints[i][j] = new Grid(pos.getX() + i, pos.getY() + j);
                }
            }
        }
        else{

            real = new Grid(super.pos.getX() + Constant.UNIT_IN, super.pos.getY() + Constant.UNIT_IN);
            hitpoints = new Grid[Constant.SCALE][Constant.SCALE];

            for(int i = 0; i < Constant.SCALE; i++){

                for(int j = 0; j < Constant.SCALE; j++){

                    hitpoints[i][j] = new Grid(real.getX() + i, real.getY() + j);
                }
            }
        }
    }

    public int getHeight(){
        return w;
    }
    public int getWidth(){
        return h;
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
    protected Grid getPos() {
        return super.pos;
    }

    @Override
    protected void setPos(Grid pos) {

        super.pos = pos;
        initReal();
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

        if(super.isSelected && spr != null){
            Sprite.drawSprite(g, spr, 1,0, super.pos.getX(), super.pos.getY(), w, h);
        }else Sprite.drawSprite(g, spr, 0,0, super.pos.getX(), super.pos.getY(), w, h);
    }
}
