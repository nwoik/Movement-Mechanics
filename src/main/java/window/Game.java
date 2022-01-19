package window;

public class Game {
    private GameWindow gameWindow;
    private final GamePanel gamePanel;
    private final double FPS = 60.0;
    private double lastFrameTime;
    private final double frameDuration = 1000000000.0/FPS;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }

    public void loop() {
        while (true) {
            if (System.nanoTime() - lastFrameTime >= frameDuration) {
                lastFrameTime = System.nanoTime(); // reassign the value for last frame
                gamePanel.repaint();
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.loop();
    }
}
