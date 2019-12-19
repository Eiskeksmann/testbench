package com.eiskeksi.logic;

import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;

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

    public Layer(MouseHandler mouse, KeyHandler  key){

        this.mouse = mouse;
        this.key = key;
    }

}
