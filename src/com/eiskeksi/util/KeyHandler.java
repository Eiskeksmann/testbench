package com.eiskeksi.util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener{

    public static List<Key> keys = new ArrayList<>();

    public class Key{
        public int presses, absorbs;
        public boolean down, clicked;

        public Key(){
            keys.add(this);
        }

        public void toggle(boolean pressed){
            if(pressed != down){
                down = pressed;
            }
            if(pressed){
                presses++;
            }
        }

        public void tick(){
            if(absorbs < presses){
                absorbs++;
                clicked = true;
            }
            else{
                clicked = false;
            }
        }
    }
    public void keyTyped(KeyEvent e){

    }
    public void keyPressed(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
}
