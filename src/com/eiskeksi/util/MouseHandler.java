package com.eiskeksi.util;

import com.eiskeksi.GamePanel;

import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;

    private static RayTrace2D ray = null;

    public MouseHandler(GamePanel game){
        game.addMouseListener(this);
        game.addMouseMotionListener(this);
        game.addMouseWheelListener(this);
    }

    public int getX(){
        return mouseX;
    }
    public int getY(){
        return mouseY;
    }
    public int getButton(){
        return mouseB;
    }

    public RayTrace2D getRayTrace2D(){
        return ray;
    }
    public void setRayTrace2D(RayTrace2D set) { ray = set; }

    @Override
    public void mouseClicked(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
        ray = new RayTrace2D(mouseX, mouseY);
        System.out.println("Click X:" + e.getX() + "Click Y:" + e.getY());
        System.out.println("Click X:" + e.getX() / Constant.TARGET_PIXEL + "Click Y:" + e.getY() / Constant.TARGET_PIXEL);
    }
    @Override
    public void mousePressed(MouseEvent e) {

        mouseB = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseB = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

        System.out.println("I CANT EXIT RIGFHT ? " + e.getX() +" | "+ e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
