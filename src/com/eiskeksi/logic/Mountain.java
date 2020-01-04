package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.RectHitBox;
import com.eiskeksi.util.Vector2f;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Mountain extends LogicTile {

    private int code;

    public Mountain(Grid loc, Sprite spr){

        super.build = false;
        super.swim = false;
        super.walk = true;
        super.loc = loc;
        super.spr = spr;
        super.r = new Random();
        super.val = r.nextInt(Constant.SPR_COL_MAX);
        super.rhb = new RectHitBox(new Grid(loc.getX(), loc.getY()),
                Constant.DOUBLE_SCALE,Constant.DOUBLE_SCALE);
        this.code = Constant.MOUNTAIN;
    }
    public String toString(){

        return "MOU";
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g, float interpolation){

        Sprite.drawSprite(g, spr, val, code, loc.getX(),
                loc.getY(), Constant.SPR_STANDARD, Constant.SPR_STANDARD);
        super.rhb.render(g, interpolation);
    }
}
