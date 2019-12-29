package com.eiskeksi.states;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.graphics.Font;
import com.eiskeksi.util.Vector2f;

import java.awt.*;

public class PlayState extends GameState{

    private Font font;

    public PlayState(GameStateManager gsm){

        super(gsm);
        font = new Font("font/filler.png", 16, 16);
    }

    public void update(){

    }
    public void input(MouseHandler mouse, KeyHandler key){

    }
    public void render(Graphics2D g){

       Font.drawArray(g, font, "DIES ist EIN Leerzeichen TeSt", new Vector2f(16, 16), 16, 16, 8, 0);
    }
}
