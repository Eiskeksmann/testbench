package com.eiskeksi.states;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;

import java.awt.*;

public class PlayState extends GameState{

    private Font font;

    public PlayState(GameStateManager gsm){

        super(gsm);
        font = new Font("/res/font/transparent_font.png", 16, 16);
    }

    public void update(){

    }
    public void input(MouseHandler mouse, KeyHandler key){

    }
    public void render(Graphics2D g){

    }
}
