package com.eiskeksi.entitiy;

import com.eiskeksi.graphics.Animation;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Direction;
import com.eiskeksi.util.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected Sprite spr_idl;
    protected Sprite spr_mov;
    protected Vector2f pos;
    protected int size;

    protected Animation ani;
    protected Direction dir;
    protected RectHitBox rhb;
    protected CircHitBox chb;

    protected float dx;
    protected float dy;

    protected float maxspeed;
    protected float acc;
    protected float deacc;

    public void initAnimation(String current, BufferedImage[] frames, int delay){

        if(Direction.isValidDir(current)){

            dir.setHeading(current);
        }
        else dir.setHeading(Direction.P());
        ani.setFrames(frames);
        ani.setDelay(delay);
    }

    public void animate(){

        String mov;
        switch(dir.isHeading()){

            case("NORTH"):
                mov = Direction.N();
                if(!dir.isHeading().equals(dir.isMovingN()) || ani.getDelay() == -1){
                    dir.setMoveN(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;
            case("NORTHEAST"):
                mov = Direction.NE();
                if(!dir.isHeading().equals(dir.isMovingNE()) || ani.getDelay() == -1){
                    dir.setMoveNE(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;

            case("EAST"):
                mov = Direction.E();
                if(!dir.isHeading().equals(dir.isMovingE()) || ani.getDelay() == -1){
                    dir.setMoveE(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;

            case("SOUTHEAST"):
                mov = Direction.SE();
                if(!dir.isHeading().equals(dir.isMovingSE()) || ani.getDelay() == -1){
                    dir.setMoveSE(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;

            case("SOUTH"):
                mov = Direction.S();
                if(!dir.isHeading().equals(dir.isMovingS()) || ani.getDelay() == -1){
                    dir.setMoveS(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;

            case("SOUTHWEST"):
                mov = Direction.SW();
                if(!dir.isHeading().equals(dir.isMovingSW()) || ani.getDelay() == -1){
                    dir.setMoveSW(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;

            case("WEST"):
                mov = Direction.W();
                if(!dir.isHeading().equals(dir.isMovingW()) || ani.getDelay() == -1){
                    dir.setMoveW(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;

            case("NORTHWEST"):
                mov = Direction.NW();
                if(!dir.isHeading().equals(dir.isMovingNW()) || ani.getDelay() == -1){
                    dir.setMoveNW(true);
                    initAnimation(mov, spr_mov.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                return;
        }

    }

    public void update(){

        //TODO: CREATE HITBOX DETECTION
        animate();
        ani.update();
    }
    public abstract void render(Graphics2D g, float interpolation);
    public void input(KeyHandler key, MouseHandler mouse){

    }

}
