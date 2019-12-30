package com.eiskeksi.entitiy;

import com.eiskeksi.graphics.Animation;
import com.eiskeksi.graphics.Sprite;
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
    private int cani;

    private final int UP = 0;
    private final int DOWN = 1;
    private final int RIGHT = 2;
    private final int LEFT = 3;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

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

        initAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

    public void initAnimation(int current, BufferedImage[] frames, int delay){

        cani = current;
        ani.setFrames(frames);
        ani.setDelay(delay);
    }

    public void animate(){


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
