package com.eiskeksi.entitiy;

import com.eiskeksi.graphics.Animation;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Direction;
import com.eiskeksi.util.CircHitBox;
import com.eiskeksi.util.Vector2f;

import java.awt.*;

public class Carrier extends Entity {


    public Carrier(Sprite spr_idl, Sprite spr_mov, Vector2f pos){

        super.spr_idl = spr_idl;
        super.spr_mov = spr_mov;
        super.pos = pos;

        super.ani = new Animation();
        super.dir = new Direction();
        super.chb = new CircHitBox(pos, 5);
    }

    @Override
    public void render(Graphics2D g) {

    }
}
