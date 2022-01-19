package objects;

public class Entity {
    public int x;
    public int y;
    public int width;
    public int height;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setPos(int x, int y) {
        System.out.println(x + ", " + y);
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
}
