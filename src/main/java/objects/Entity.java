package objects;


import java.awt.*;

public abstract class Entity {
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public int HEIGHT = dimension.height;
    public int WIDTH = dimension.width;
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean up, down, left, right;
    public int movementSpeed;


    public Entity(int x, int y, int width, int height, int movementSpeed) {
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

//    public abstract void render(Graphics g);
//    public abstract Rectangle getBounds();
    public abstract void move();

    public abstract void setPos(int x, int y);

    public abstract void addX(int value);

    public abstract void subX(int value);

    public abstract void addY(int value);

    public abstract void subY(int value);

    public abstract boolean contains(int x, int y);

    public abstract void borderPatrol();
}