package com.eiskeksi.logic;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.util.RectHitBox;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

public abstract class LogicTile{

    protected RectHitBox rhb;
    protected Random r;
    protected int val;
    protected Grid loc;
    protected Sprite spr;
    protected boolean build;
    protected boolean walk;
    protected boolean swim;

    public boolean canBuild(){
        return build;
    }
    public boolean canWalk(){
        return walk;
    }
    public boolean canSwim(){
        return swim;
    }

    public abstract void update();
    public abstract void render(Graphics2D g, float interpolation);
    public void input(MouseHandler mouse, KeyHandler key){

    }
}
