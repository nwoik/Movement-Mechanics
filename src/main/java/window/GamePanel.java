package window;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import objects.Handler;
import objects.Player;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel {
    public BufferedImage img;
    public int frames;
    private long lastTime;
    private String outputFPS = "";
    public Handler handler;
    public Player player = new Player(100, 100, 100, 100, 15);

    public GamePanel(BufferedImage img) {
        this.img = img;
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        handler = new Handler();
        handler.addEntity(player);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(this.img.getSubimage(0,0,16,16), 0, 0, 100, 100,  null);

        handler.render(g);
        handler.borderPatrol();
        handler.move();

        g.setColor(Color.GREEN);
        g.drawString(callFPS(), 10, 10);
    }

    public String callFPS() {
        frames++;
        if (System.currentTimeMillis() - lastTime >= 1000) { // if the time between the current and last time is over 1000ms
            outputFPS = "" + frames;
            frames = 0; // reset frame count
            lastTime = System.currentTimeMillis(); // reassign last time
        }
        return outputFPS;
    }
}