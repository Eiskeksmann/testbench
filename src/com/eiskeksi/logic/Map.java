package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class Map {

    private Layer lay;
    private LogicTile last;
    private Grid lastindex;
    private boolean isRendered;
    private ArrayList<Grid> precise_render;

    public Map(Layer lay){

        this.lay = lay;
        isRendered = false;
    }

    public void update(){

        for (int i = 0; i < lay.getY(); i++) {

            for (int j = 0; j < lay.getX(); j++) {

                lay.getSat()[j][i].update();
            }
        }
    }
    public void input(MouseHandler mouse, KeyHandler key){

        if(mouse.getRayTrace2D() != null){

            precise_render = new ArrayList<>();
            int x = mouse.getRayTrace2D().convertedRasterPos().getY();
            int y = mouse.getRayTrace2D().convertedRasterPos().getX();
            precise_render.add(new Grid(x, y));

            if(!lay.getSat()[x][y].getSelected()){

                if (last != null) {
                    precise_render.add(lastindex);
                    last.setSelected(false);
                }
                last = lay.getSat()[x][y];
                lastindex = new Grid(x, y);
                last.setSelected(true);
            }
            else{

                lay.getSat()[x][y].setSelected(false);
                last = null;
            }
            mouse.setRayTrace2D(null);
        }
    }
    public void render(Graphics2D g, float interpolation){

        renderBackGround(g, interpolation);
    }

    private void renderBackGround(Graphics2D g, float interpolation){

        if(!isRendered) {
            for (int i = 0; i < lay.getY(); i++) {

                for (int j = 0; j < lay.getX(); j++) {

                    lay.getSat()[j][i].render(g, interpolation);
                }
            }
            isRendered = true;
        }
        if(precise_render != null){
            for(Grid gr : precise_render) {

                lay.getSat()[gr.getX()][gr.getY()].render(g, interpolation);
            }
            precise_render = null;
        }
    }

}
