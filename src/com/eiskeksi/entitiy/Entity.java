package com.eiskeksi.entitiy;

import com.eiskeksi.graphics.Animation;
import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.logic.Direction;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    private Sprite sprite;
    private Vector2f origin;
    private int size;

    private Animation ani;

    Direction dir;

    protected float dx;
    protected float dy;

    protected float maxspeed;
    protected float acc;
    protected float deacc;

    public Entity(Sprite sprite, Vector2f origin, int size){

        this.sprite = sprite;
        this.origin = origin;
        this.size = size;
        this.ani = new Animation();
        dir = new Direction();

        //initAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

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
        if(dir.isMovingN()){
            mov = Direction.N();
            if(!dir.isHeading().equals(dir.isMovingN()) || ani.getDelay() == -1){
                dir.setHeading(mov);
                initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
            }
        }

        switch(dir.isHeading()){

            case("NORTH"):
                mov = Direction.N();
                if(!dir.isHeading().equals(dir.isMovingN()) || ani.getDelay() == -1){
                    dir.setMoveN(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;
            case("NORTHEAST"):
                mov = Direction.NE();
                if(!dir.isHeading().equals(dir.isMovingNE()) || ani.getDelay() == -1){
                    dir.setMoveNE(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;

            case("EAST"):
                mov = Direction.E();
                if(!dir.isHeading().equals(dir.isMovingE()) || ani.getDelay() == -1){
                    dir.setMoveE(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;

            case("SOUTHEAST"):
                mov = Direction.SE();
                if(!dir.isHeading().equals(dir.isMovingSE()) || ani.getDelay() == -1){
                    dir.setMoveSE(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;

            case("SOUTH"):
                mov = Direction.S();
                if(!dir.isHeading().equals(dir.isMovingS()) || ani.getDelay() == -1){
                    dir.setMoveS(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;

            case("SOUTHWEST"):
                mov = Direction.SW();
                if(!dir.isHeading().equals(dir.isMovingSW()) || ani.getDelay() == -1){
                    dir.setMoveSW(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;

            case("WEST"):
                mov = Direction.W();
                if(!dir.isHeading().equals(dir.isMovingW()) || ani.getDelay() == -1){
                    dir.setMoveW(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;

            case("NORTHWEST"):
                mov = Direction.NW();
                if(!dir.isHeading().equals(dir.isMovingNW()) || ani.getDelay() == -1){
                    dir.setMoveNW(true);
                    initAnimation(mov, sprite.getSpriteArray(Direction.translateDir(mov)), 5);
                }
                break;
        }

    }

    public void update(){

        //TODO: CREATE HITBOX DETECTION
        animate();
        //setHitBoxDirection();
        ani.update();
    }
    public abstract void render(Graphics2D g);
    public void input(KeyHandler key, MouseHandler mouse){

    }

}
