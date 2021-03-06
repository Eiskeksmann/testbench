package com.eiskeksi.states;

import com.eiskeksi.GamePanel;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.util.Vector2f;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> states;

    public static Vector2f map;

    public static final int PLAY = 0;
    public static final int MENU = 1;
    public static final int PAUSE = 2;
    public static final int GOVER = 3;


    public GameStateManager() throws ParserConfigurationException, SAXException, IOException {

        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x, map.y);

        states  = new ArrayList<>();
        states.add(new PlayState(this));
    }

    public void pop(int state){

        states.remove(state);
    }
    public void add(int state) throws ParserConfigurationException, SAXException, IOException {

        switch(state){

            case(PLAY):
                states.add(new PlayState(this));
                break;

            case(MENU):
                states.add(new MenuState(this));
                break;

            case(PAUSE):
                states.add(new PauseState(this));
                break;

            case(GOVER):
                states.add(new GameOverState(this));
                break;
        }
    }
    public void addAndPop(int state) throws IOException, SAXException, ParserConfigurationException {
        states.clear();
        add(state);
    }

    public void update(){

        Vector2f.setWorldVar(map.x, map.y);
        for (GameState s : states) {
            s.update();
        }

    }
    public void input(MouseHandler mouse, KeyHandler key){

        for (GameState s : states) {
            s.input(mouse, key);
        }
    }
    public void render(Graphics2D g, float interpolation){

        for (GameState s : states) {
            s.render(g ,interpolation);
        }
    }
}
