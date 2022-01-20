package objects;

import window.GamePanel;

import java.awt.*;

public class Rectangle extends Entity {
    public Rectangle(int x, int y, int width, int height, int movementSpeed) {
        super(x, y, width, height, movementSpeed);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.movementSpeed = movementSpeed;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void move() {

    }

    @Override
    public void setPos(int x, int y) {

    }

    @Override
    public void addX(int value) {

    }

    @Override
    public void subX(int value) {

    }

    @Override
    public void addY(int value) {

    }

    @Override
    public void subY(int value) {

    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public void borderPatrol() {

    }


}
