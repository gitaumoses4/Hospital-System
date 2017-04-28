package hospitalsystem.custom;

import hospitalsystem.Tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Moses Muigai Gitau
 */
public class MButton extends JButton implements MouseListener {

    private int horizontalPadding = 20;
    private int verticalPadding = 10;

    private Color background = Color.WHITE;
    private Color foreground = Color.BLACK;

    private boolean hovered = false;

    public MButton(String text) {
        super(text.toUpperCase());
        setFont(Tools.defaultFont);
        setBackground(background);
        setForeground(foreground);
        setProperties();
        addMouseListener(this);
    }

    private void setProperties() {
        int width = getFontMetrics(getFont()).stringWidth(getText());
        setSize(width + (horizontalPadding * 2), getFont().getSize() + (verticalPadding * 2));
        if (hovered) {
            setSize(getWidth() + 1, getHeight() + 1);
        }
        setPreferredSize(getSize());
        setMinimumSize(getSize());
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        setProperties();
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.setColor(getForeground());
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.setFont(getFont());
        Point p = getTextPosition(getText(), getFont(), 0, 0, getWidth() - 1, getHeight() - 1);
        g.drawString(getText(), p.x, p.y);
    }

    public Point getTextPosition(String text, Font font, int x, int y, int width, int height) {
        int textWidth = getFontMetrics(font).stringWidth(text);
        x += (width - textWidth) / 2;
        y += (height + font.getSize()) / 2;
        return new Point(x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!hovered) {
            setSize(getWidth() + 1, getHeight() + 1);
            repaint();
            hovered = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (hovered) {
            setSize(getWidth() - 1, getHeight() - 1);
            repaint();
            hovered = false;
        }
    }
}
