package objects;


import window.GamePanel;
import window.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Player extends Entity {
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public int HEIGHT = dimension.height;
    public int WIDTH = dimension.width;
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean up, down, left, right;
    public int movementSpeed;

    public Player(int x, int y, int width, int height, int movementSpeed) {
        super(x, y, width, height, movementSpeed);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        this.movementSpeed = movementSpeed;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void move() {
        if (this.right) {
            addX(this.movementSpeed);
        }

        if (this.left) {
            subX(this.movementSpeed);
        }

        if (this.down) {
            addY(this.movementSpeed);
        }

        if (this.up) {
            subY(this.movementSpeed);
        }
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void addX(int value) {
        this.x += value;
    }

    @Override
    public void subX(int value) {
        this.x -= value;
    }

    @Override
    public void addY(int value) {
        this.y += value;
    }

    @Override
    public void subY(int value) {
        this.y -= value;
    }

    @Override
    public boolean contains(int x, int y) {
        return this.x < x && x < this.x + this.width && this.y < y && y < this.y + this.height;
    }

    @Override
    public void borderPatrol() {
        if (this.x <= 0) {
            this.left = false;
            this.x = 0;
        }
        if (this.x + this.width >= WIDTH) {
            this.right = false;
            this.x = WIDTH - this.width;
        }
        if (this.y <= 0) {
            this.up = false;
            this.y = 0;
        }
        if (this.y + this.height >= HEIGHT) {
            this.down = false;
            this.y = HEIGHT - this.height;
        }
    }
}