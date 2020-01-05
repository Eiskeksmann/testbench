package com.eiskeksi.util;

import com.eiskeksi.entitiy.Entity;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Grid;

import java.awt.*;
import java.util.ArrayList;

public abstract class HitBox {

    protected Entity ent;
    protected Sprite spr;
    protected Grid pos;
    protected DirSkeletton dsk;
    protected ArrayList<Grid> col;
    protected boolean getSelected;

    public boolean isGetSelected(){
        return getSelected;
    }
    public void setGetSelected(boolean set){
        getSelected = set;
    }

    protected abstract boolean collide(HitBox col);
    protected abstract double calcSize();
    protected abstract double calcPerimeter();
    protected abstract ArrayList<Grid> getCollisionPoint(String dir);

    protected abstract boolean getSelected();
    protected abstract Grid getPos();
    protected abstract void setPos(Grid pos);

    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g, float interpolation);
}
