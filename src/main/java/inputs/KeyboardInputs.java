package inputs;

import objects.Player;
import window.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener{
    private final Player player;

    public KeyboardInputs(GamePanel gamePanel) {
        this.player = gamePanel.square;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> this.player.left = true;
            case KeyEvent.VK_D -> this.player.right = true;
            case KeyEvent.VK_S -> this.player.down = true;
            case KeyEvent.VK_W -> this.player.up = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar() + " released");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> this.player.left = false;
            case KeyEvent.VK_D -> this.player.right = false;
            case KeyEvent.VK_S -> this.player.down = false;
            case KeyEvent.VK_W -> this.player.up = false;
        }
    }
}
