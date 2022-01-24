package window;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import objects.Handler;
import objects.Player;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class GamePanel extends JPanel {
    //System
    public BufferedImage img;
    public int frames;
    private long lastTime;
    private String outputFPS = "";
    public Handler handler;
    public Player player = new Player(100, 100, 100, 100, 15);
    public UI ui = new UI(this);

    //Screen Settings
    final int defaultTileSize = 16; // 16 bit
    final int scale = 3;
    final int tileSize = defaultTileSize * scale; //Larger image size with 16 bit look
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;


    // GAME STATES
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int settingsState = 2;


    public GamePanel(BufferedImage img) {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.img = img;
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        handler = new Handler();
        int gameState = 0;
        int titleState = 0;
        int playState = 1;
    }

    public void paintComponent(Graphics2D g2) {
        super.paintComponent(g2);
        // TITLE SCREEN
        if (gameState == titleState | gameState == settingsState) {
            ui.draw(g2);
        }
        else if (gameState == playState) {
            //UI
            ui.draw(g2);
            handler.addEntity(player);
            handler.render(g2);
            handler.borderPatrol();
            handler.move();

            g2.setColor(Color.GREEN);
            g2.drawString(callFPS(),  10, 10);
        }
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