package com.eiskeksi.graphics;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Animation {

    private BufferedImage[] frames;
    private int cframe;
    private int nframes;

    private int count;
    private int delay;

    private int tplayed;

    public Animation(BufferedImage[] frames){

        tplayed = 0;
        this.frames = frames;
        initFrames();
    }

    public Animation(){
        tplayed = 0;
    }
    public void initFrames(){

        cframe = 0;
        count = 0;
        tplayed = 0;
        delay = 2;
        nframes = frames.length;
    }

    public void setDelay(int set){
        delay = set;
    }
    public void setFrames(int set){
        cframe = set;
    }
    public void setNframes(int set){
        nframes = set;
    }


    public void Update(){
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
    public int getDelay(){
        return delay;
    }
    public int getCFrame(){
        return cframe;
    }
    public int getCount(){
        return count;
    }
    public BufferedImage getImage(){
        return frames[cframe];
    }
    public boolean hasPlayedOnce(){
        return tplayed > 0;
    }
    public boolean hasPlayed(int howoften){
        return tplayed == howoften;
    }


}
