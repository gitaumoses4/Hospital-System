package hospitalsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class ImageHeader extends JPanel {

    private final ImageIcon image;
    private final String text;
    private final Font font;
    private final Color textColor;

    public ImageHeader(ImageIcon image, String text, int width, int height, int textSize, int fontStyle, Color textColor) {
        setPreferredSize(new Dimension(width, height));
        this.image = image;
        this.text = text;
        this.font = new Font(Font.DIALOG, fontStyle, textSize);
        this.textColor = textColor;
    }


    private int getTextWidth() {
        return getFontMetrics(font).stringWidth(text);
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);

        
        g.setColor(new Color(0,0,255,100));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(textColor);
        g.setFont(font);
        int width = getTextWidth();
        int stringX = (getWidth() - width) / 2;
        int stringY = (getHeight() + font.getSize()) / 2;
        g.drawString(text, stringX, stringY);
        
    }
}
