package window;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI2 {
    private final GamePanel gp;
    private Graphics2D g2D;
    private Font gameFont;
    public int commandNum = 0;

    public UI2(GamePanel gp, Graphics2D g2D) {
        this.gp = gp;
        this.g2D = g2D;

        try {
            InputStream is = getClass().getResourceAsStream("/GameFont-Regular.ttf");
            assert is != null;
            gameFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            gameFont = new Font("Times New Roman", Font.PLAIN, 120);
        }
    }

    /**
    public void draw(Graphics2D g2) {
        this.g2D = g2;

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
            g2D.setFont(gameFont.deriveFont(32F));
            g2D.drawString("Words", 50, 50);
        }
        else {
            System.exit(0);
        }
    }**/





    public int getXForCenteredText(String text) {
        int length = (int)g2D.getFontMetrics().getStringBounds(text, g2D).getWidth();
        return gp.screenWidth/2 - length/2;
    }
}
