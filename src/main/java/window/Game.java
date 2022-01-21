package window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private final GamePanel gamePanel;
    private final double FPS = 60.0;
    private double lastFrameTime;
    private final double frameDuration = 1000000000.0/FPS;
    private Thread gameThread;
    BufferedImage img;


    public Game() {
        importImg();
        gamePanel = new GamePanel(img);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }

    public void loop() {
        while (true) {
            if (System.nanoTime() - lastFrameTime >= frameDuration) {
                lastFrameTime = System.nanoTime(); // reassign the value for last frame
                gamePanel.repaint();
            }
        }
    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void importImg() {
        InputStream inputStream = getClass().getResourceAsStream("/Woodgrain.png");
        try {
            assert inputStream != null;
            img = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void run() {
        loop();
    }
}
