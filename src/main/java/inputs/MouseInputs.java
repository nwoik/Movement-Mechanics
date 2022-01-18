package inputs;

import window.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse dragged at " + e.getPoint());
        if (this.gamePanel.square.contains(e.getX(), e.getY())) {
            this.gamePanel.square.setPos(e.getX()-this.gamePanel.square.length/2, e.getY()-this.gamePanel.square.length/2); // centers the shape being dragged
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
