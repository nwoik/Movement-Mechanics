package window;

import javax.swing.JFrame;
import java.awt.*;


public class GameWindow extends JFrame {
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public int HEIGHT = dimension.height;
    public int WIDTH = dimension.width;


    public GameWindow(GamePanel gamePanel) {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(true);
        this.add(gamePanel);
        setUndecorated(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
