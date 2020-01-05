package com.eiskeksi.graphics;

import com.eiskeksi.logic.Grid;
import com.eiskeksi.util.Constant;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.nio.Buffer;

public class Animation {

    private Sprite spr;
    private Grid pos;
    private int cframe;
    private int nframes;

    private int count;
    private int delay;

    private int tplayed;

    public Animation(Sprite spr, Grid pos){

        tplayed = 0;
        this.pos = pos;
        this.nframes = spr.getWidth();
        this.spr = spr;
        initFrames();
    }
    public void initFrames(){

        cframe = 0;
        count = 0;
        tplayed = 0;
        delay = -1;
    }

    public void setDelay(int set){
        delay = set;
    }
    public void update(){
        if(delay == -1) return;
        count++;

        if(count == delay){
            cframe++;
            count = 0;
        }
        if(cframe == nframes){
            cframe = 0;
            tplayed++;
        }
    }
    public void render(Graphics2D g, float interpolation){

        Sprite.drawSprite(g, spr, cframe, 0, pos.getX(), pos.getY(), Constant.SPR_STANDARD, Constant.SPR_STANDARD);
        delay++;
    }
    public int getDelay(){
        return delay;
    }
    public int getCFrame(){
        return cframe;
    }
    public int getCount(){
        return count;
    }
    public boolean hasPlayedOnce(){
        return tplayed > 0;
    }
    public boolean hasPlayed(int howoften){
        return tplayed == howoften;
    }


}
