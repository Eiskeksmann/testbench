package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.RectHitBox;
import com.eiskeksi.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Water extends LogicTile {

    private int code;

    public Water(Grid loc, Sprite spr){

        super.build = false;
        super.swim = true;
        super.walk = false;
        super.loc = loc;
        super.spr = spr;
        super.r = new Random();
        super.val = r.nextInt(Constant.SPR_COL_MAX);
        super.rhb = new RectHitBox(new Grid(loc.getX(), loc.getY()),
                Constant.DOUBLE_SCALE, Constant.DOUBLE_SCALE);
        this.code = Constant.WATER;
    }
    public String toString(){

        return "WAT";
    }


    @Override
    public void render(Graphics2D g, float interpolation){

        Sprite.drawSprite(g, spr, val, code, loc.getX(),
                loc.getY(), Constant.SPR_STANDARD, Constant.SPR_STANDARD);
        rhb.render(g, interpolation);
    }

    @Override
    public void update() {

    }
}
