package com.eiskeksi.logic;

import com.eiskeksi.graphics.Sprite;
import com.eiskeksi.util.Constant;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

//CLASS DESCRIPTION

//Lets say we have 3 standard Layers ...
// --> Ground Level Should be Water and thats Default for like every Tile of the map (0)
// --> If the Level Rises By one it should be a regular Ground Tile (1)
// --> If the Level Rises by another one it should be a Mountain Tile (2)

// - (0) Water Tiles Should be able to Store Resources like for example Fish or something like that
// - (0) Only Ships Should be able to move through Water Tiles
// - (1) Ground Tiles Should be able to Store Resources like Wood, Stone - Harvestable Materials (Food for example)
// - (1) On Ground Tiles it should be possible to build something - BUT only one building per Ground Tile
// - (1) Ground Tiles should temporarily Store Units that move Through the Tile or even stay there (rest, idle)
// - (2) Mountain Tiles should be able to store Resources like Cole, Iron and Gold
// - (2) On Mountain Tiles the only allowed Building Type should be Mines

public class Layer {

    MouseHandler mouse;
    KeyHandler key;

    private File layout;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document doc;
    private NodeList nod;

    private Sprite spr;
    private Sprite spr_rhb;
    private String[] rows;
    private LogicTile[][] sat;

    private int size;
    private int x;
    private int y;

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getSize(){ return size;}
    public LogicTile[][] getSat(){ return sat;}

    public Layer(String path, Sprite spr, Sprite spr_rhb) throws ParserConfigurationException,
            IOException, SAXException {


        this.layout = new File(path);
        this.factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();
        this.doc = builder.parse(layout);
        this.nod = doc.getElementsByTagName("Row");
        this.spr = spr;
        this.spr_rhb = spr_rhb;
        createStringArray();
        createLogicTileArray();
    }
    private void createStringArray(){

        rows = new String[nod.getLength()];
        for(int i = 0; i < nod.getLength(); i++){

            rows[i] = nod.item(i).getTextContent();
            System.out.println("["+ i +"] :" + rows[i]);
        }
        this.x = rows.length;
        this.y = rows[0].length() / 2 + 1;
        this.size = x * y;
        sat = new LogicTile[x][y];
    }
    private void createLogicTileArray(){

        for(int i = 0; i < x; i++){
            StringTokenizer tok = new StringTokenizer(rows[i],",");
            for(int j = 0; j < y; j++){
                switch (tok.nextToken()){

                    case("0"):
                        sat[i][j] = new Water(new Grid(j * Constant.DOUBLE_SCALE,
                                i * Constant.DOUBLE_SCALE), spr, spr_rhb);
                        break;
                    case("1"):
                        sat[i][j] = new Ground(new Grid(j * Constant.DOUBLE_SCALE,
                                i * Constant.DOUBLE_SCALE), spr, spr_rhb);
                        break;
                    case("2"):
                        sat[i][j] = new Mountain(new Grid(j * Constant.DOUBLE_SCALE,
                                i * Constant.DOUBLE_SCALE), spr, spr_rhb);
                        break;
                }
            }
        }

    }
    public void printLogicTileArray(){

        for(int i = 0; i < x; i++){

            String line = " | ";
            for(int j = 0; j < y; j++){

                line += sat[i][j].toString() + " | ";
            }
            System.out.println(line);
        }
    }
    public LogicTile getLogicTile(int xat, int yat){

        return sat[xat][yat];
    }
    public void setlogicTile(int xat, int yat, LogicTile set){

        sat[xat][yat] = set;
    }



}
