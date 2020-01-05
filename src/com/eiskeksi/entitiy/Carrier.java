package com.eiskeksi.entitiy;

import com.eiskeksi.graphics.Animation;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Direction;
import com.eiskeksi.logic.Grid;
import com.eiskeksi.logic.LogicTile;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.RectHitBox;

import java.awt.*;

public class Carrier extends Entity {


    public Carrier(Sprite spr_idl, Sprite spr_mov, Sprite spr_rhb, LogicTile origin){

        super.spr_rhb = spr_rhb;
        super.spr_idl = spr_idl;
        super.spr_mov = spr_mov;
        super.origin = origin;
        super.pos = origin.getLoc();
        super.ani = new Animation(spr_idl, origin.getLoc());
        super.dir = new Direction();
        super.rhb = new RectHitBox(spr_rhb, new Grid(pos.getX() + Constant.SCALE,
                pos.getY() + Constant.SCALE), Constant.SCALE,Constant.SCALE);
    }

    @Override
    public void render(Graphics2D g, float interpolation) {


        //Sprite.drawSprite(g, super.spr_idl, 0,0,
          //      super.pos.getX(),
            //   super.pos.getY(),
              //  Constant.SPR_STANDARD, Constant.SPR_STANDARD);

        super.ani.render(g, interpolation);
       // super.rhb.render(g, interpolation);
    }
}
