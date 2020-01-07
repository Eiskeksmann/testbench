package com.eiskeksi.states;
import com.eiskeksi.entitiy.Carrier;
import com.eiskeksi.entitiy.Entity;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.*;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.graphics.Font;
import com.eiskeksi.util.Vector2f;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class PlayState extends GameState{

    private final int SPRITESTANDARD = 16;
    private final int FONTSTANDARD = 16;

    private Font font;
    private Sprite ent_rhb;
    private Sprite til_rhb;
    private Sprite ent_idl;
    private Sprite ent_mov;
    private Sprite floor;
    private Entity test;
    private Layer raster;
    private Map map;

    public PlayState(GameStateManager gsm) throws IOException, SAXException, ParserConfigurationException {

        super(gsm);
        font = new Font("font/optimized_trans_ascii.png", FONTSTANDARD, FONTSTANDARD);
        ent_idl = new Sprite("sprite/carrier_idle.png", SPRITESTANDARD, SPRITESTANDARD);
        ent_mov = new Sprite("sprite/carrier_move.png", SPRITESTANDARD, SPRITESTANDARD);
        ent_rhb = new Sprite("sprite/unit_rhb.png", SPRITESTANDARD, SPRITESTANDARD);
        til_rhb = new Sprite("sprite/tile_rhb.png", SPRITESTANDARD, SPRITESTANDARD);
        floor = new Sprite("sprite/map.png", SPRITESTANDARD, SPRITESTANDARD);
        raster = new Layer(Constant.MAPPATH, floor, til_rhb);
        test = new Carrier(ent_idl, ent_mov, ent_rhb, raster.getSat()[5][5]);
        map = new Map(raster);

    }
    public void update(){

        map.update();
        test.update();
    }
    public void input(MouseHandler mouse, KeyHandler key){

        map.input(mouse, key);
    }
    public void render(Graphics2D g, float interpolation){

        map.render(g, interpolation);
       Font.drawArray(g, font, "testwert: " + Constant.SCALE, new Vector2f(10, 10),
               SPRITESTANDARD, SPRITESTANDARD, 8, 0);
        test.render(g, interpolation);


    }
}
