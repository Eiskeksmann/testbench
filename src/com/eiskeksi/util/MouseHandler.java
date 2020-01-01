package com.eiskeksi.util;

import com.eiskeksi.GamePanel;
import com.eiskeksi.Window;

import java.awt.*;
import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;

    private static double precX = -1.0;
    private static double precY = -1.0;

    private static RayTrace2D ray = null;

    public MouseHandler(GamePanel gpanel){
        gpanel.addMouseListener(this);
        gpanel.addMouseMotionListener(this);
        gpanel.addMouseWheelListener(this);
    }

    public int getx(){
        return mouseX;
    }
    public int getY(){
        return mouseY;
    }
    public int getButton(){
        return mouseB;
    }
    public double getPrecX(){
        return precX;
    }
    public double getPrecY(){
        return precY;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        precX = e.getLocationOnScreen().getLocation().getX();
        precY = e.getLocationOnScreen().getLocation().getY();
        ray = new RayTrace2D(new Vector2f((float)precX, (float)precY));
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
