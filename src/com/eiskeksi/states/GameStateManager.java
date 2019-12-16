package com.eiskeksi.states;

import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> states;

    public GameStateManager(){

        states  = new ArrayList<GameState>();
        states.add(new PlayState(this));
    }

    public void update(){

        for (GameState s : states) {
            s.update();
        }

    }
    public void input(MouseHandler mouse, KeyHandler key){

        for (GameState s : states) {
            s.input(mouse, key);
        }
    }
    public void render(Graphics2D g){

        for (GameState s : states) {
            s.render(g);
        }
    }
}
