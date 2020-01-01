package com.eiskeksi.logic;

import java.util.ArrayList;

public class Direction {

    private static final String POINT = "POINT";

    private static final String NORTH = "NORTH";
    private static final String WEST = "WEST";
    private static final String SOUTH = "SOUTH";
    private static final String EAST = "EAST";

    private static final String NORTHWEST = "NORTHWEST";
    private static final String SOUTHWEST = "SOUTHWEST";
    private static final String SOUTHEAST = "SOUTHEAST";
    private static final String NORTHEAST = "NORTHEAST";

    private static final String[] DIRECTIONS = {
            "POINT",
            "NORTH",
            "WEST",
            "SOUTH",
            "EAST",
            "NORTHWWEST",
            "SOUTHWEST",
            "SOUTHEAST",
            "NORTHEAST"
    };

    private boolean movingP;
    private boolean movingN;
    private boolean movingE;
    private boolean movingS;
    private boolean movingW;

    private boolean movingNW;
    private boolean movingSW;
    private boolean movingSE;
    private boolean movingNE;

    private boolean[] register;

    private String heading;

    public Direction(){

        register = new boolean[]{

                movingP = true,
                movingN = false,
                movingE = false,
                movingS = false,
                movingW = false,
                movingNW = false,
                movingSW = false,
                movingSE = false,
                movingNE = false
        };
        heading = POINT;
    }
    public static String P(){ return POINT;}
    public static String N(){ return NORTH;}
    public static String W(){ return WEST;}
    public static String S(){ return SOUTH;}
    public static String E(){ return EAST;}

    public static String NW(){ return NORTHWEST;}
    public static String SW(){ return SOUTHWEST;}
    public static String SE(){ return SOUTHEAST;}
    public static String NE(){ return NORTHEAST;}

    public static boolean isValidDir(String dir){

        for(String check : DIRECTIONS){

            if(check.equals(dir)) return true;
        }
        return false;
    }

    public boolean isMovingP(){ return movingP;}
    public boolean isMovingN(){ return movingN;}
    public boolean isMovingE(){ return movingE;}
    public boolean isMovingS(){ return movingS;}
    public boolean isMovingW(){ return movingW;}

    public boolean isMovingNW(){ return movingNW;}
    public boolean isMovingSW(){ return movingSW;}
    public boolean isMovingSE(){ return movingSE;}
    public boolean isMovingNE(){ return movingNE;}

    public String isHeading(){ return heading;}

    public void setMoveP(boolean set){ setMoveReg(movingP, set); }
    public void setMoveN(boolean set){ setMoveReg(movingN, set);}
    public void setMoveW(boolean set){ setMoveReg(movingW, set);}
    public void setMoveS(boolean set){ setMoveReg(movingS, set);}
    public void setMoveE(boolean set){ setMoveReg(movingE, set);}

    public void setMoveNW(boolean set){ setMoveReg(movingNW, set);}
    public void setMoveSW(boolean set){ setMoveReg(movingSW, set);}
    public void setMoveSE(boolean set){ setMoveReg(movingSE, set);}
    public void setMoveNE(boolean set){ setMoveReg(movingNE, set);}

    private void setMoveReg(boolean toset, boolean set){

        for(boolean b : register){

            if(b) b = false;
        }
        toset = set;
    }

    public void setHeading(String set){ heading = set;}

    public static int translateDir(String dir){

        if(isValidDir(dir) && !dir.equals(POINT)){
            switch (dir){

                case(NORTH):
                    return 0;
                case(NORTHEAST):
                    return 1;
                case(EAST):
                    return 2;
                case(SOUTHEAST):
                    return 3;
                case(SOUTH):
                    return 4;
                case(SOUTHWEST):
                    return 5;
                case(WEST):
                    return 6;
                case(NORTHWEST):
                    return 7;
            }
        }
        System.out.println("Not a valid Direction");
        return -1;
    }
}
