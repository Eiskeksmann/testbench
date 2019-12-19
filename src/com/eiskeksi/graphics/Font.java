package com.eiskeksi.graphics;

import com.eiskeksi.util.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

public class Font {

    private BufferedImage FONTSHEET = null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    public int w;
    public int h;
    private int wFont;
    private int hFont;

    public Font(String file){

        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("Loading" + file + "...");
        FONTSHEET = loadSprite(file);

        wFont = FONTSHEET.getWidth() / w;
        hFont = FONTSHEET.getHeight() / h;
        loadSpriteArray();
    }

    public Font(String file, int w, int h){

        this.w = w;
        this.h = h;

        System.out.println("Loading" + file + "...");
        FONTSHEET = loadSprite(file);

        wFont = FONTSHEET.getWidth() / w;
        hFont = FONTSHEET.getHeight() / h;
        loadSpriteArray();
    }

    public void setSize(int width, int height){

        setWidth(width);
        setHeight(height);
    }
    public void setWidth(int w){
        this.w = w;
        wFont = FONTSHEET.getWidth() / w;
    }
    public void setHeight(int h){
        this.h = h;
        hFont = FONTSHEET.getHeight() / h;
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

        spriteArray = new BufferedImage[wFont][hFont];

        for(int x =  0; x < wFont; x++){

            for(int y = 0; y < hFont; y++){
                spriteArray[x][y] = getSprite(x, y);
            }
        }

    }
    public BufferedImage getSpriteSheet(){
        return FONTSHEET;
    }
    public BufferedImage getSprite(int x, int y){
        return FONTSHEET.getSubimage(x * w, y* h, w, h);
    }
    public BufferedImage[] getSpriteArray(int i){
        return spriteArray[i];
    }
    public BufferedImage[][] getSpriteArray2(){
        return spriteArray;
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

    public static void drawArray(Graphics2D g, Font f, String word, Vector2f pos, int width, int height, int xoffset, int yoffset){
        float x = pos.x;
        float y = pos.y;

        for(int i  = 0; i < word.length(); i++){
            if(word.charAt(i) != 32){
                //g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
            }

            x+= xoffset;
            y+= xoffset;

        }
    }

}
