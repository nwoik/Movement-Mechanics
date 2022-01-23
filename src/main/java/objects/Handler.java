package objects;

import window.Game;
import window.GamePanel;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<Entity> entities = new LinkedList<Entity>();

    public void render(Graphics g) {
        for (Entity entity : entities) {
            entity.render(g);
        }
    }

    public void move() {
        for (Entity entity : entities) {
            entity.move();
        }
    }

    public void borderPatrol() {
        for (Entity entity: entities) {
            entity.borderPatrol();
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
}
