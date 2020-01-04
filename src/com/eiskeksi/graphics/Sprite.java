package com.eiskeksi.graphics;

import com.eiskeksi.logic.Direction;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.Vector2f;
import gherkin.lexer.Ar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;

public class Sprite {

    private BufferedImage SPRITESHEET = null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    public int w;
    public int h;
    private int wSprite;
    private int hSprite;

    public Sprite(String file){

        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("Loading" + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public Sprite(String file, int w, int h){

        this.w = w;
        this.h = h;

        System.out.println("Loading" + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public void setSize(int width, int height){

        setWidth(width);
        setHeight(height);
    }
    public void setWidth(int w){
        this.w = w;
        wSprite = SPRITESHEET.getWidth() / w;
    }
    public void setHeight(int h){
        this.h = h;
        hSprite = SPRITESHEET.getHeight() / h;
    }

    public int getWidth(){ return w;}
    public int getHeigth(){return h;}

    private BufferedImage loadSprite(String file){

        BufferedImage sprite = null;
        try{

            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));

        }
        catch(Exception e){
            System.out.println("ERROR: couldnt load file:" +  file);
        }
        return sprite;
    }
    public void loadSpriteArray(){

        spriteArray = new BufferedImage[wSprite][hSprite];

        for(int x =  0; x < wSprite; x++){

            for(int y = 0; y < hSprite; y++){
                spriteArray[x][y] = getSprite(x, y);
            }
        }

    }
    public BufferedImage getRandomImage(int column){

        Random r = new Random();
        return SPRITESHEET.getSubimage(r.nextInt(7) * w, column * h, w, h);
    }
    public BufferedImage getSpriteSheet(){
        return SPRITESHEET;
    }
    public BufferedImage getSprite(int x, int y){
        return SPRITESHEET.getSubimage(x * w, y* h, w, h);
    }
    public BufferedImage[] getSpriteArray(int i){
        return spriteArray[i];
    }
    public BufferedImage[][] getSpriteArray2(){
        return spriteArray;
    }
    public ArrayList<BufferedImage> getAniCol(String column){

        ArrayList<BufferedImage> ret = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            ret.add(this.getSprite(Direction.translateDir(column), i));
        }
        return ret;
    }
    public static void drawSprite(Graphics2D g, Sprite spr, int xsh, int ysh,
                                  int xpo, int ypo, int w, int h){

        g.drawImage(spr.getSprite(xsh, ysh), xpo, ypo, w, h, null);
    }
    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img,
                                 Vector2f pos, int width, int height,
                                 int xoffset, int yoffset){

        float x = pos.x;
        float y = pos.y;

        for(int i = 0; i < img.size(); i++){
            if(img.get(i) != null){
                g.drawImage(img.get(i), (int) x, (int) y, width, height, null);
            }

            x += xoffset;
            y += yoffset;
        }
    }

    public static void drawArray(Graphics2D g, Sprite s, String word, Vector2f pos, int width, int height, int xoffset, int yoffset){
        float x = pos.x;
        float y = pos.y;

        for(int i  = 0; i < word.length(); i++){

            g.drawImage(s.getSprite((int) x, (int) y), width, height, null);
            x+= xoffset;
            y+= yoffset;

        }
     }

}
