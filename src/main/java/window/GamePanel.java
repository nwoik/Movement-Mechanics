package window;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import player.Player;

import javax.swing.JPanel;
import java.awt.*;


public class GamePanel extends JPanel {
    private int frames;
    private long lastTime;
    public Player square = new Player(0, 0, 100);

    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(square.x, square.y, square.length, square.length);

        square.move(square.movementSpeed);
        callFPS();
        repaint();
    }

    public void callFPS() {
        frames++;
        if (System.currentTimeMillis() - lastTime >= 1000) { // if the time between the current and last time is over 1000ms
            System.out.println("FPS: " + frames);
            frames = 0; // reset frame count
            lastTime = System.currentTimeMillis(); // reassign last time
        }
    }
}
