package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.RectHitBox;

import java.awt.*;
import java.util.Random;

public class Water extends LogicTile {

    private int code;

    public Water(Grid loc, Sprite spr_sur, Sprite spr_rhb){

        super.build = false;
        super.swim = true;
        super.walk = false;
        super.loc = loc;
        super.spr_sur = spr_sur;
        super.spr_rhb = spr_rhb;
        super.r = new Random();
        super.val = r.nextInt(Constant.SPR_COL_MAX);
        super.rhb = new RectHitBox(this, spr_rhb, new Grid(loc.getX(), loc.getY()),
                Constant.SQUARED_SCALE, Constant.SQUARED_SCALE);
        this.code = Constant.WATER;
    }
    public String toString(){

        return "WAT";
    }


    @Override
    public void render(Graphics2D g, float interpolation){

        Sprite.drawSprite(g, spr_sur, val, code, loc.getX(),
                loc.getY(), Constant.SPR_STANDARD, Constant.SPR_STANDARD);
        rhb.render(g, interpolation);
    }

    @Override
    public void update() {

        rhb.setSelected(super.isSelected);
    }
}
