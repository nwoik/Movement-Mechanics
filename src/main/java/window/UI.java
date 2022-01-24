package window;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font gameFont;
    Font exceptionFont = new Font("Times New Roman", Font.PLAIN, 120);
    public int commandNum = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        try {
            InputStream is = getClass().getResourceAsStream("/GameFont-Regular.ttf");
            assert is != null;
            gameFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public  void draw(Graphics2D g2) {
        this.g2 = g2;
        //Title State
        if (gp.gameState == gp.titleState) {
            switch (commandNum) {
                case -1 -> commandNum = 2;
                case 3 -> commandNum = 0;
            }
            drawTitleScreen();
        }
        //Settings State
        else if (gp.gameState == gp.settingsState) {
            switch (commandNum) {
                case -1 -> commandNum = 8;
                case 9 -> commandNum = 0;
            }
            drawSettingsScreen();
        }
        //Play State
        else if (gp.gameState == gp.playState) {
            g2.setFont(gameFont.deriveFont(32F));
            g2.drawString("Words", 50, 50);
        }
        else {
            System.exit(0);
        }
    }

    public void drawTitleScreen() {
        //Title Name
        g2.setFont(gameFont.deriveFont(64F));
        g2.drawImage(gp.img, 0,0, gp.screenWidth, gp.screenHeight, null);
        g2.drawString("Placeholder", getXForCenteredText("Placeholder"), gp.tileSize+0.5F);
        //Selectable
        g2.drawString("New Game", getXForCenteredText("New Game"), gp.tileSize*3);
        g2.drawString("Settings", getXForCenteredText("Settings"), gp.tileSize*4+10F);
        g2.drawString("Exit", getXForCenteredText("Exit"), gp.tileSize*5+20F);

        switch (commandNum) {
            case 0 -> g2.drawString("1", getXForCenteredText("New Game")-gp.tileSize, gp.tileSize*3);
            case 1 -> g2.drawString("1", getXForCenteredText("Settings")-gp.tileSize, gp.tileSize*4+10F);
            case 2 -> g2.drawString("1", getXForCenteredText("Exit")-gp.tileSize, gp.tileSize*5+20F);
        }
    }

    public void drawSettingsScreen() {
        // Header
        g2.setFont(gameFont.deriveFont(64F));
        g2.drawImage(gp.img, 0,0, gp.screenWidth, gp.screenHeight, null);
        g2.drawString("Settings", getXForCenteredText("Settings"), gp.tileSize+10F);
        // Slides
        g2.setFont(gameFont.deriveFont(32F));
        g2.drawString("Audio", getXForCenteredText("Audio"), gp.tileSize+32*2F);
        // Controls Header
        g2.setFont(gameFont.deriveFont(64F));
        g2.drawString("Controls", getXForCenteredText("Controls"), gp.tileSize+32*4F);
        // Controls Options
        g2.setFont(gameFont.deriveFont(32F));
        g2.drawString("Up", getXForCenteredText("Up"), gp.tileSize+32*5F);
        g2.drawString("Down", getXForCenteredText("Down"), gp.tileSize+32*6F);
        g2.drawString("Left", getXForCenteredText("Left"), gp.tileSize+32*7F);
        g2.drawString("Right", getXForCenteredText("Right"), gp.tileSize+32*8F);
        g2.drawString("Weapon 1", getXForCenteredText("Weapon 1"), gp.tileSize+32*9F);
        g2.drawString("Weapon 2", getXForCenteredText("Weapon 2"), gp.tileSize+32*10F);
        g2.drawString("Inventory", getXForCenteredText("Inventory"), gp.tileSize+32*11F);
        g2.drawString("Menu", getXForCenteredText("Menu"), gp.tileSize+32*12F);
        switch (commandNum) {
            case 0 -> g2.drawString("1", getXForCenteredText("Audio")-gp.tileSize, gp.tileSize+32*2F);
            case 1 -> g2.drawString("1", getXForCenteredText("Up")-gp.tileSize, gp.tileSize+32*5F);
            case 2 -> g2.drawString("1", getXForCenteredText("Down")-gp.tileSize, gp.tileSize+32*6F);
            case 3 -> g2.drawString("1", getXForCenteredText("Left")-gp.tileSize, gp.tileSize+32*7F);
            case 4 -> g2.drawString("1", getXForCenteredText("Right")-gp.tileSize, gp.tileSize+32*8F);
            case 5 -> g2.drawString("1", getXForCenteredText("Weapon 1")-gp.tileSize, gp.tileSize+32*9F);
            case 6 -> g2.drawString("1", getXForCenteredText("Weapon 2")-gp.tileSize, gp.tileSize+32*10F);
            case 7 -> g2.drawString("1", getXForCenteredText("Inventory")-gp.tileSize, gp.tileSize+32*11F);
            case 8 -> g2.drawString("1", getXForCenteredText("Menu")-gp.tileSize, gp.tileSize+32*12F);
        }
    }

    public int getXForCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2 - length/2;
    }
}
