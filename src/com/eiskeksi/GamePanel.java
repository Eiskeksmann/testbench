package com.eiskeksi;

import com.eiskeksi.util.Constant;
import com.eiskeksi.util.KeyHandler;
import com.eiskeksi.util.MouseHandler;
import com.eiskeksi.states.GameStateManager;
import org.xml.sax.SAXException;

import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable{

    public static int width;
    public static int height;


    private Thread thread;
    private boolean running = false;
    private boolean pause = false;
    private int fps = 0;
    private int frameCount = 0;
    private BufferedImage img;
    private Graphics2D g;

    private MouseHandler mouse;
    private KeyHandler key;

    private GameStateManager gsm;

    public GamePanel(int width, int height){

        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(this.width, this.height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this,"stratsis");
            thread.start();
        }

    }

    public void init() throws IOException, SAXException, ParserConfigurationException {

        running = true;
        img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
        g.scale(Constant.DOUBLE_SCALE,Constant.DOUBLE_SCALE);
        mouse = new MouseHandler(this);
        key = new KeyHandler(this);

        gsm = new GameStateManager();
    }

    public void run(){

            //This value would probably be stored elsewhere.
            final double GAME_HERTZ = 144.0;
            //Calculate how many ns each frame should take for our target game hertz.
            final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
            //At the very most we will update the game this many times before a new render.
            //If you're worried about visual hitches more than perfect timing, set this to 1.
            final int MAX_UPDATES_BEFORE_RENDER = 5;
            //We will need the last update time.
            double lastUpdateTime = System.nanoTime();
            //Store the last time we rendered.
            double lastRenderTime;

            //If we are able to get as high as this FPS, don't render again.
            final double TARGET_FPS = 144;
            final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;

            //Simple way of finding FPS.
            int lastSecondTime = (int) (lastUpdateTime / 1000000000);

        try {

            init();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        while (running)
            {
                double now = System.nanoTime();
                int updateCount = 0;

                if (!pause)
                {
                    //Do as many game updates as we need to, potentially playing catchup.
                    while( now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER )
                    {
                        update();
                        input(this.mouse, this.key);
                        lastUpdateTime += TIME_BETWEEN_UPDATES;
                        updateCount++;
                    }

                    //If for some reason an update takes forever, we don't want to do an insane number of catchups.
                    //If you were doing some sort of game that needed to keep EXACT time, you would get rid of this.
                    if ( now - lastUpdateTime > TIME_BETWEEN_UPDATES)
                    {
                        lastUpdateTime = now - TIME_BETWEEN_UPDATES;
                    }

                    //Render. To do so, we need to calculate interpolation for a smooth render.
                    float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES) );
                    render(interpolation);
                    draw(interpolation);
                    lastRenderTime = now;
                    frameCount++;

                    //Update the frames we got.
                    int thisSecond = (int) (lastUpdateTime / 1000000000);
                    if (thisSecond > lastSecondTime)
                    {
                        System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                        fps = frameCount;
                        frameCount = 0;
                        lastSecondTime = thisSecond;
                    }

                    //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
                    while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES)
                    {
                        Thread.yield();

                        //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
                        //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
                        //FYI on some OS's this can cause pretty bad stuttering.
                        try {Thread.sleep(1);} catch(Exception e) {}

                        now = System.nanoTime();
                    }
                }
            }
    }

    public void update(){

        gsm.update();
    }
    public void input(MouseHandler mouse, KeyHandler key){

        gsm.input(mouse, key);
    }
    public void render(float interpolation){

        if(g != null){

            g.setColor(new Color(57,200,250));
            g.fillRect(0, 0, this.width, this.height);
            gsm.render(g, interpolation);
        }
    }
    public void draw(float interpolation){
        Graphics g2 = (Graphics2D) this.getGraphics();
        g2.drawImage(img, 0, 0, this.width, this.height, null);
        g2.dispose();
    }
}
