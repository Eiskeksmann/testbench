package com.eiskeksi.states;
import com.eiskeksi.entitiy.Carrier;
import com.eiskeksi.entitiy.Entity;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Grid;
import com.eiskeksi.logic.Layer;
import com.eiskeksi.logic.Map;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.graphics.Font;
import com.eiskeksi.util.Vector2f;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

public class PlayState extends GameState{

    private final int SPRITESTANDARD = 16;
    private final int FONTSTANDARD = 16;

    private Font font;
    private Sprite ent_idl;
    private Sprite ent_mov;
    private Sprite floor;
    private Entity test;
    private Layer raster;
    private Map map;

    private double mousex;
    private double mousey;

    public PlayState(GameStateManager gsm) throws IOException, SAXException, ParserConfigurationException {

        super(gsm);
        font = new Font("font/filler.png", FONTSTANDARD, FONTSTANDARD);
        ent_idl = new Sprite("sprite/carrier_idle.png", SPRITESTANDARD, SPRITESTANDARD);
        ent_mov = new Sprite("sprite/carrier_move.png", SPRITESTANDARD, SPRITESTANDARD);
        floor = new Sprite("sprite/map.png", SPRITESTANDARD, SPRITESTANDARD);
        raster = new Layer("C://Users/eiskeksi/IdeaProjects/Tutorial/res/map/map.xml", floor);
        test = new Carrier(ent_idl, ent_mov, new Grid(5, 5));
        map = new Map(raster);

    }


    public void update(){

    }
    public void input(MouseHandler mouse, KeyHandler key){

        mousex = mouse.getX();
        mousey = mouse.getY();
    }
    public void render(Graphics2D g, float interpolation){

        map.render(g, interpolation);
       //Font.drawArray(g, font, "test", new Vector2f(10, 10),
               //SPRITESTANDARD, SPRITESTANDARD, 4, 0);
        test.render(g, interpolation);


    }
}
