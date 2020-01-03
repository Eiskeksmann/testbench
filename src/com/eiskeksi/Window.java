package com.eiskeksi;

import javax.swing.JFrame;

public class Window extends JFrame {

    public Window(){

        setTitle("Window Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new com.eiskeksi.GamePanel(1920,1080));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
