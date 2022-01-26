package window;

import java.awt.*;

public class MainUI extends UI2 {
    private GamePanel gp;
    private Graphics2D g2D;
    private Font gameFont;
    public MainUI(GamePanel gp, Graphics2D g2D) {
        super(gp, g2D);
    }

    public void drawTitleScreen() {
        //Title Name
        g2D.setFont(gameFont.deriveFont(64F));
        g2D.drawImage(gp.img, 0,0, gp.screenWidth, gp.screenHeight, null);
        g2D.drawString("Placeholder", getXForCenteredText("Placeholder"), gp.tileSize+0.5F);
        //Selectable
        g2D.drawString("New Game", getXForCenteredText("New Game"), gp.tileSize*3);
        g2D.drawString("Settings", getXForCenteredText("Settings"), gp.tileSize*4+10F);
        g2D.drawString("Exit", getXForCenteredText("Exit"), gp.tileSize*5+20F);

        switch (commandNum) {
            case 0 -> g2D.drawString(">", getXForCenteredText("New Game")-gp.tileSize, gp.tileSize*3);
            case 1 -> g2D.drawString(">", getXForCenteredText("Settings")-gp.tileSize, gp.tileSize*4+10F);
            case 2 -> g2D.drawString(">", getXForCenteredText("Exit")-gp.tileSize, gp.tileSize*5+20F);
        }
    }
}
