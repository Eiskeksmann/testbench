package com.eiskeksi.states;
import com.eiskeksi.entitiy.Carrier;
import com.eiskeksi.entitiy.Entity;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.graphics.Font;
import com.eiskeksi.util.Vector2f;

import java.awt.*;

public class PlayState extends GameState{

    private final int SPRITESTANDARD = 16;
    private final int FONTSTANDARD = 16;

    private Font font;
    private Sprite ent_idl;
    private Sprite ent_mov;
    private Entity test;

    private double mousex;
    private double mousey;

    public PlayState(GameStateManager gsm){

        super(gsm);
        font = new Font("font/filler.png", FONTSTANDARD, FONTSTANDARD);
        ent_idl = new Sprite("sprite/carrier_idle.png", SPRITESTANDARD, SPRITESTANDARD);
        ent_mov = new Sprite("sprite/carrier_move.png", SPRITESTANDARD, SPRITESTANDARD);

        test = new Carrier(ent_idl, ent_mov, new Vector2f(10, 10));
    }

    public void update(){

    }
    public void input(MouseHandler mouse, KeyHandler key){

        mousex = mouse.getPrecX();
        mousey = mouse.getPrecY();
        System.out.println("X:" + mousex + " Y:" + mousey);
    }
    public void render(Graphics2D g, float interpolation){

       Font.drawArray(g, font, "test", new Vector2f(10, 10), SPRITESTANDARD, SPRITESTANDARD, 4, 0);
       Sprite.drawSprite(g, ent_idl, 0,0,(int)mousex,(int)mousey,SPRITESTANDARD,SPRITESTANDARD);
    }
}
