package hospitalsystem.custom;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class ImageLabel extends JLabel {

    private final ImageIcon icon;

    public ImageLabel(ImageIcon icon, int width, int height) {
        this.icon = icon;
        setPreferredSize(new Dimension(width, height));
        setSize(getPreferredSize());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gr.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
