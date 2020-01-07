package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.RectHitBox;

import java.awt.*;
import java.util.Random;

public class Mountain extends LogicTile {

    private int code;

    public Mountain(Grid loc, Sprite spr_sur, Sprite spr_rhb){

        super.build = false;
        super.swim = false;
        super.walk = true;
        super.loc = loc;
        super.spr_sur = spr_sur;
        super.spr_rhb = spr_rhb;
        super.r = new Random();
        super.val = r.nextInt(Constant.SPR_COL_MAX);
        super.rhb = new RectHitBox(this, spr_rhb, new Grid(loc.getX(), loc.getY()),
                Constant.SQUARED_SCALE,Constant.SQUARED_SCALE);
        this.code = Constant.MOUNTAIN;
    }
    public String toString(){

        return "MOU";
    }

    @Override
    public void update() {

        rhb.setSelected(super.isSelected);
    }

    @Override
    public void render(Graphics2D g, float interpolation){

        Sprite.drawSprite(g, spr_sur, val, code, (int)loc.getX(),
                (int)loc.getY(), Constant.SPR_STANDARD, Constant.SPR_STANDARD);
        super.rhb.render(g, interpolation);
    }
}
