package com.eiskeksi.logic;
import java.util.Vector;

public abstract class LogicTile{

    protected Grid loc;
    protected boolean build;
    protected boolean walk;
    protected boolean swim;

    protected abstract void lUpdate();
    protected abstract void lInput();
    protected abstract void lRender();

    public boolean canBuild(){
        return build;
    }
    public boolean canWalk(){
        return walk;
    }
    public boolean canSwim(){
        return swim;
    }

}
