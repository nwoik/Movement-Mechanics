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

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        this.movementSpeed = 5;
    }

    public void move(int value) {
        if (this.right) {
            addX(value);
        }

        if (this.left) {
            subX(value);
        }

        if (this.down) {
            addY(value);
        }

        if (this.up) {
            subY(value);
        }
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addX(int value) {
        this.x += value;
    }

    public void subX(int value) {
        this.x -= value;
    }

    public void addY(int value) {
        this.y += value;
    }

    public void subY(int value) {
        this.y -= value;
    }

    public boolean contains(int x, int y) {
        return this.x < x && x < this.x + this.width && this.y < y && y < this.y + this.height;
    }

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