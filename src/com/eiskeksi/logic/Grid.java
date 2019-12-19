package com.eiskeksi.logic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grid {

    private int x;
    private int y;

    ArrayList<Grid> path;

    public Grid(int x, int y){

        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public ArrayList<Grid> createPath(Grid from, Grid to){

        //TODO: Create a simple pathing Algorithm
        return this.path;
    }
    public int calcDistance(Grid from, Grid to){

        int d = 0;
        switch(getDir(from, to)){
            case("NORTH"):
                d = from.getY() - to.getY();
                break;

            case("NORTHEAST"):
                if(from.getY() - to.getY() >= to.getX() - from.getX()){

                    d = to.getY() - from.getY();
                } else d = to.getX() - from.getX();
                break;

            case("EAST"):
                d = to.getX() - from.getX();
                break;

            case("SOUTHEAST"):
                if(to.getX() - from.getX() >= to.getY() - from.getY()){

                    d = to.getX() - from.getX();
                } else d = to.getY() - from.getY();
                break;

            case("SOUTH"):
                d = to.getY() - from.getY();
                break;

            case("SOUTHWEST"):
                if(from.getX() - to.getX() >= to.getY() - from.getY()){

                    d = from.getX() - to.getX();
                } else d = to.getY() - from.getY();
                break;

            case("WEST"):
                d = from.getX() - to.getX();
                break;

            case("NORTHWEST"):
                if(from.getX() - to.getX() >= from.getY() - to.getY()){

                    d = from.getX() - to.getX();
                }else d = from.getY() - to.getY();
                break;

            case("POINT"):
                d = 0;
                break;
        }
        return d;
    }
    public String getDir(Grid from, Grid to){

        //NORTH
        if(from.getX() == to.getX() && from.getY() > to.getY()){
            return Direction.N();
        }
        //NORTHEAST
        else if(from.getX() < to.getX() && from.getY() > to.getY()){
            return Direction.NE();
        }
        //EAST
        else if(from.getX() < to.getX() && from.getY() == to.getY()){
            return Direction.E();
        }
        //SOUTHEAST
        else if(from.getX() < to.getX() && from.getY() < to.getY()){
            return Direction.SE();
        }
        //SOUTH
        else if(from.getX() == to.getX() && from.getY() < to.getY()){
            return Direction.S();
        }
        //SOUTHWEST
        else if(from.getX() > to.getX() && from.getY() < to.getY()){
            return Direction.SW();
        }
        //WEST
        else if(from.getX() > to.getX() && from.getY() == to.getY()){
            return Direction.W();
        }
        //NORTHWEST
        else if(from.getX() > to.getX() && from.getY() > to.getY()){
            return Direction.NW();
        }
        else return Direction.P();
    }
}
