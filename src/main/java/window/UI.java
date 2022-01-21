package window;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font gameFont;
    Font exceptionFont = new Font("Times New Roman", Font.PLAIN, 120);

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
            drawTitleScreen();
        };
        //Play State
        if (gp.gameState == gp.playState) {
            g2.setFont(gameFont.deriveFont(32F));
            g2.drawString("Words", 50, 50);
        };
    };

    public void drawTitleScreen() {
        //Title Name
        g2.setFont(gameFont.deriveFont(64F));
//        Image background = "Background.png";
//        g2.drawImage("Background.png", 0,0, gp.screenWidth, gp.screenHeight, null);
        g2.drawString("Placeholder", getXForCenteredText("Placeholder"), gp.tileSize+0.5F);
        g2.drawString("New Game", getXForCenteredText("New Game"), gp.tileSize*3);
        g2.drawString("Settings", getXForCenteredText("Settings"), gp.tileSize*4+10F);
        g2.drawString("Exit", getXForCenteredText("Exit"), gp.tileSize*5+20F);
    }

    public int getXForCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2 - length/2;
    }
}
