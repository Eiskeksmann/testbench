package com.eiskeksi.entitiy;

import com.eiskeksi.graphics.Animation;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Direction;
import com.eiskeksi.util.CircHitBox;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.RectHitBox;
import com.eiskeksi.util.Vector2f;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.awt.*;

public class Carrier extends Entity {


    public Carrier(Sprite spr_idl, Sprite spr_mov, Vector2f pos){

        super.spr_idl = spr_idl;
        super.spr_mov = spr_mov;
        super.pos = pos;

        super.ani = new Animation();
        super.dir = new Direction();
        super.rhb = new RectHitBox(pos, 8,8);
    }

    @Override
    public void render(Graphics2D g, float interpolation) {


        Sprite.drawSprite(g, super.spr_idl, 0,0,((int)super.pos.x - Constant.SCALE * Constant.SCALE) / Constant.SCALE,
               ((int)super.pos.y - Constant.SCALE * Constant.SCALE) / Constant.SCALE, Constant.SPR_STANDARD, Constant.SPR_STANDARD);

        super.rhb.render(g, interpolation);
    }
}
