package com.eiskeksi.util;

import com.eiskeksi.entitiy.Entity;

import java.awt.*;
import java.util.ArrayList;

public abstract class HitBox {

    protected Entity ent;
    protected Vector2f pos;
    protected DirSkeletton dsk;
    protected ArrayList<Vector2f> col;
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
    protected abstract ArrayList<Vector2f> getCollisionPoint(String dir);

    protected abstract boolean getSelected();
    protected abstract Vector2f getPos();
    protected abstract void setPos(Vector2f pos);

    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g, float interpolation);
}
