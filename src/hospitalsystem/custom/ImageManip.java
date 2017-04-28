package hospitalsystem.custom;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * @author Moses Muigai Gitau
 */
public class ImageManip {

    public ImageManip() {
    }

    public static BufferedImage changeColor(ImageIcon imageIcon, Color from, Color to) {
        BufferedImage initial = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = initial.createGraphics();
        imageIcon.paintIcon(null, g, 0, 0);
        g.dispose();
        for (int i = 0; i < imageIcon.getIconWidth(); i++) {
            for (int j = 0; j < imageIcon.getIconHeight(); j++) {
                Color c = new Color(initial.getRGB(i, j));
                if (c.equals(from)) {
                    initial.setRGB(i, j, to.getRGB());
                }
            }
        }
        return initial;
    }

    public static BufferedImage makeTransparent(ImageIcon imageIcon, Color from) {
        Color to = new Color(from.getRed(), from.getGreen(), from.getBlue(), 0);
        return changeColor(imageIcon, from, to);
    }

    /**
     * Removes gray background from application's icons.
     *
     * @param imageIcon
     * @return
     */
    public static BufferedImage removeGray(ImageIcon imageIcon) {
        Color from = new Color(128, 128, 128, 255);
        return makeTransparent(imageIcon, from);
    }
}
