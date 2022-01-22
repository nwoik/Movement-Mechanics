package inputs;

import objects.Player;
import window.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener{
    private final Player player;
    GamePanel gp;


    public KeyboardInputs(GamePanel gp) {
        this.player = gp.player;
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Title State
        if (gp.gameState == gp.titleState) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> gp.ui.commandNum--;
                case KeyEvent.VK_S -> gp.ui.commandNum++;
                case KeyEvent.VK_ENTER -> gp.gameState = gp.ui.commandNum+1;
            }
        }
        else if (gp.gameState == gp.settingsState) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> gp.ui.commandNum--;
                case KeyEvent.VK_S -> gp.ui.commandNum++;
                case KeyEvent.VK_BACK_SPACE -> gp.gameState = gp.titleState;
//                case KeyEvent.VK_ENTER -> ;
            }
        }
        else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A -> this.player.left = true;
                case KeyEvent.VK_D -> this.player.right = true;
                case KeyEvent.VK_S -> this.player.down = true;
                case KeyEvent.VK_W -> this.player.up = true;
            }
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
