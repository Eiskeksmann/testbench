package com.eiskeksi.util;

public class Constant {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;


    public static final int SPR_COL_MAX = 7;
    public static String MAPPATH = "C:/Users/krist/IdeaProjects/testbench/res/map/map.xml";

    public static final int FON_STANDARD = 16;

    public static final int SCALE = 4;
    public static final int SQUARED_SCALE = SCALE * SCALE;
    public static final int HALF_SCALE = SCALE / TWO;
    public static final int SPR_STANDARD = SCALE * SCALE;
    public static final int UNIT_IN = ONE + ((SQUARED_SCALE - SCALE) / TWO);
    public static final int TARGET_PIXEL = SPR_STANDARD * SCALE;

    public static final double DSCALE = (double)SCALE;

    public static final int SOLX = 1920;
    public static final int SOLY = 1080;

    public static final int WATER = ZERO;
    public static final int GROUND = ONE;
    public static final int MOUNTAIN = TWO;
}
