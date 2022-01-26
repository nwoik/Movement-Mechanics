package window;

import java.awt.*;

public class SettingsUI extends UI2 {
    private GamePanel gp;
    private Graphics2D g2D;
    private Font gameFont;
    public SettingsUI(GamePanel gp, Graphics2D g2D) {
        super(gp, g2D);
    }

    public void drawSettingsScreen() {
        // Header
        g2D.setFont(gameFont.deriveFont(64F));
        g2D.drawImage(gp.img, 0,0, gp.screenWidth, gp.screenHeight, null);
        g2D.drawString("Settings", getXForCenteredText("Settings"), gp.tileSize+10F);
        // Slides
        g2D.setFont(gameFont.deriveFont(32F));
        g2D.drawString("Audio", getXForCenteredText("Audio"), gp.tileSize+32*2F);
        // Controls Header
        g2D.setFont(gameFont.deriveFont(64F));
        g2D.drawString("Controls", getXForCenteredText("Controls"), gp.tileSize+32*4F);
        // Controls Options
        g2D.setFont(gameFont.deriveFont(32F));
        g2D.drawString("Up", getXForCenteredText("Up"), gp.tileSize+32*5F);
        g2D.drawString("Down", getXForCenteredText("Down"), gp.tileSize+32*6F);
        g2D.drawString("Left", getXForCenteredText("Left"), gp.tileSize+32*7F);
        g2D.drawString("Right", getXForCenteredText("Right"), gp.tileSize+32*8F);
        g2D.drawString("Weapon 1", getXForCenteredText("Weapon 1"), gp.tileSize+32*9F);
        g2D.drawString("Weapon 2", getXForCenteredText("Weapon 2"), gp.tileSize+32*10F);
        g2D.drawString("Inventory", getXForCenteredText("Inventory"), gp.tileSize+32*11F);
        g2D.drawString("Menu", getXForCenteredText("Menu"), gp.tileSize+32*12F);
        switch (commandNum) {
            case 0 -> g2D.drawString(">", getXForCenteredText("Audio")-gp.tileSize, gp.tileSize+32*2F);
            case 1 -> g2D.drawString(">", getXForCenteredText("Up")-gp.tileSize, gp.tileSize+32*5F);
            case 2 -> g2D.drawString(">", getXForCenteredText("Down")-gp.tileSize, gp.tileSize+32*6F);
            case 3 -> g2D.drawString(">", getXForCenteredText("Left")-gp.tileSize, gp.tileSize+32*7F);
            case 4 -> g2D.drawString(">", getXForCenteredText("Right")-gp.tileSize, gp.tileSize+32*8F);
            case 5 -> g2D.drawString(">", getXForCenteredText("Weapon 1")-gp.tileSize, gp.tileSize+32*9F);
            case 6 -> g2D.drawString(">", getXForCenteredText("Weapon 2")-gp.tileSize, gp.tileSize+32*10F);
            case 7 -> g2D.drawString(">", getXForCenteredText("Inventory")-gp.tileSize, gp.tileSize+32*11F);
            case 8 -> g2D.drawString(">", getXForCenteredText("Menu")-gp.tileSize, gp.tileSize+32*12F);
        }
    }


}
