package window;

import javax.swing.JFrame;
import java.awt.*;


public class GameWindow extends JFrame {
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public int HEIGHT = dimension.height;
    public int WIDTH = dimension.width;


    public GameWindow(GamePanel gamePanel) {
        this.setSize(500, 500);
        this.setResizable(true);
        this.add(gamePanel);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
