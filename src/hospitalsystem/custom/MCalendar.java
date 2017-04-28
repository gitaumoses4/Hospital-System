package hospitalsystem.custom;

import hospitalsystem.Tools;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;

/**
 *
 * @author Moses Muigai Gitau
 */
public class MCalendar extends JPanel {

    private final String WEEK_DAYS[] = new String[]{"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};

    private int rowSize;
    private int colSize;

    private Calendar calendar = Calendar.getInstance();

    private Font font = Tools.defaultFont;
    private Font boldFont = Tools.defaultBoldFont;

    private Color highlightColor = new Color(158, 251, 142);

    private final int today;

    public MCalendar(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setSize(getPreferredSize());
        setOpaque(false);
        today = calendar.get(Calendar.DATE);
    }

    public String getMonth() {
        return new SimpleDateFormat("MMMMMM").format(calendar.getTime());
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rowSize = (int) (Math.round((getHeight() - 1) / 8.0));
        colSize = (int) (Math.round((getWidth() - 1) / 7.0));

        g.drawRect(0, 0, getWidth() - 1, rowSize);
        Point monthPosition = getTextPosition(getMonth(), boldFont, 0, 0, getWidth() - 1, rowSize);
        g.setFont(boldFont.deriveFont(Font.BOLD));
        g.drawString(getMonth(), monthPosition.x, monthPosition.y);

        g.setFont(boldFont);
        for (int i = 0; i < WEEK_DAYS.length; i++) {
            Rectangle r = new Rectangle(i * colSize, rowSize, i == 6 ? (getWidth() - 1 - (i * colSize)) : colSize, rowSize);
            g.drawRect(r.x, r.y, r.width, r.height);
            Point p = getTextPosition(WEEK_DAYS[i], boldFont, r.x, r.y, r.width, r.height);
            g.drawString(WEEK_DAYS[i], p.x, p.y);
        }
        calendar.set(Calendar.DATE, 1);
        boolean started = false;
        boolean completed = false;
        boolean stop = false;
        int day = 1;
        for (int j = 0; j < 6; j++) {
            if (stop) {
                break;
            }
            for (int i = 0; i < WEEK_DAYS.length; i++) {
                Rectangle r = new Rectangle(i * colSize, rowSize * (j + 2), i == 6 ? (getWidth() - 1 - (i * colSize)) : colSize,
                        j == 5 ? (getHeight() - 1 - ((j + 2) * rowSize)) : rowSize);
                if (day > calendar.getActualMaximum(Calendar.DATE)) {
                    completed = true;
                }
                if ((completed && i <= 6) || !completed) {
                    if (day == today) {
                        g.setColor(highlightColor);
                        g.fillRect(r.x, r.y, r.width, r.height);
                    }
                    g.setColor(Color.BLACK);
                    g.drawRect(r.x, r.y, r.width, r.height);

                    if (completed && i == 6) {
                        stop = true;
                        break;
                    }
                }
                if (j == 0 && !started) {
                    if (calendar.get(Calendar.DAY_OF_WEEK) == i + 1) {
                        started = true;
                    }
                }
                if (started) {
                    if (!completed) {
                        Point p = getTextPosition(String.valueOf(day), boldFont, r.x, r.y, r.width, r.height);
                        g.drawString(String.valueOf(day), p.x, p.y);
                        day++;
                    }
                }
            }
        }
    }

    public Point getTextPosition(String text, Font font, int x, int y, int width, int height) {
        int textWidth = getFontMetrics(font).stringWidth(text);
        x += (width - textWidth) / 2;
        y += (height + font.getSize()) / 2;
        return new Point(x, y);
    }
}
