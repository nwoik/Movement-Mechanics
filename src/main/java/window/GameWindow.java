package window;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class GameWindow extends JFrame{
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public int HEIGHT = dimension.height;
    public int WIDTH = dimension.width;

    public GameWindow(GamePanel gamePanel) {

        this.setTitle("Game");
        this.add(gamePanel);
        this.pack();
//        setUndecorated(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void TitleWindow() {

        //Title Name

    }
}
