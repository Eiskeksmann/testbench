package com.eiskeksi.util;

import java.util.ArrayList;

public abstract class HitBox {

    protected Vector2f pos;

    protected abstract boolean collide(HitBox col);
    protected abstract double calcSize();
    protected abstract double calcPerimeter();
    protected abstract ArrayList<Vector2f> getCollisionPoint(String dir);

    protected abstract boolean getSelected();
    protected abstract Vector2f getPos();
    protected abstract void setPos(Vector2f pos);

    protected abstract void update();
    protected abstract void input(MouseHandler mouse, KeyHandler key);
    protected abstract void render();
}
