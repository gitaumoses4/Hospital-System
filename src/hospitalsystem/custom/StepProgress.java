package hospitalsystem.custom;

import hospitalsystem.Tools;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Moses Muigai Gitau
 */
public class StepProgress extends JComponent implements MouseListener, MouseMotionListener {

    private final int numberOfSteps;

    private ArrayList<Rectangle> points = new ArrayList();

    private int circleRadius = 20;
    private int circleStroke = 3;

    private Color circleFill = Color.BLACK;
    private Color textFill = Color.WHITE;

    private int currentStep = 1;

    private ArrayList<Boolean> hover = new ArrayList();
    private ArrayList<StepListener> listeners = new ArrayList();

    /**
     *
     * @param numberOfSteps
     */
    public StepProgress(int numberOfSteps) {
        this(numberOfSteps, ((20 * 2) + 5) * numberOfSteps, (20 * 2) + 5);
    }

    public StepProgress(int numberOfSteps, int width, int circleRadius) {
        this.numberOfSteps = numberOfSteps;
        this.circleRadius = circleRadius;
        setMinimumSize(new Dimension(width, (circleRadius * 2) + 5));
        setPreferredSize(getMinimumSize());
        setSize(getPreferredSize());
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void addStepListener(StepListener l) {
        this.listeners.add(l);
    }

    public void removeStepListener(StepListener l) {
        this.listeners.remove(l);
    }

    private void fireStepChanged(int step) {
        for (StepListener l : listeners) {
            l.stepChanged(step);
        }
    }

    public Point[] lineBetween(Rectangle s, Rectangle e) {
        Rectangle start = s.x > e.x ? e : s;
        Rectangle end = s.x < e.x ? e : s;
        int x1, x2, y1, y2;

        x1 = start.x + start.width;
        x2 = end.x;

        y1 = start.y + start.height / 2;
        y2 = end.y + end.height / 2;

        return new Point[]{new Point(x1, y1), new Point(x2, y2)};
    }

    public void createLocations() {
        if (hover.isEmpty()) {
            for (int i = 0; i < numberOfSteps; i++) {
                hover.add(false);
            }
        }
        points.clear();
        int length = getWidth() / (numberOfSteps - 1);
        for (int i = 0; i < numberOfSteps; i++) {
            int x, y, width = circleRadius * 2, height = circleRadius * 2;
            y = (getHeight() / 2) - circleRadius;
            x = length * i;
            if (i == 0) {
                x = 0;
            } else if (i == numberOfSteps - 1) {
                x -= (circleRadius * 2);
            } else {
                x -= circleRadius;
            }
            points.add(new Rectangle(x + circleStroke, y + circleStroke, width - (circleStroke * 2), height - (circleStroke * 2)));
            if (hover.get(i)) {
                points.get(i).width += 2;
                points.get(i).height += 2;
            }
        }
    }

    public void nextStep() {
        if (currentStep > 1) {
            currentStep--;
            fireStepChanged(currentStep);
            repaint();
        }
    }

    public void previousStep() {
        if (currentStep < points.size()) {
            currentStep++;
            fireStepChanged(currentStep);
            repaint();
        }
    }

    public void setStep(int step) {
        if (step > 0) {
            this.currentStep = step;
            fireStepChanged(currentStep);
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D gr = (Graphics2D) g;
        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        createLocations();
        int index = 1;
        g.setFont(Tools.defaultFont.deriveFont(circleRadius));
        for (Rectangle rect : points) {
            gr.setStroke(new BasicStroke(circleStroke));
            Point p = getTextPosition(String.valueOf(index), Tools.defaultFont.deriveFont(circleRadius), rect.x, rect.y, rect.width, rect.height);
            if (index <= currentStep) {
                if (index > 1) {
                    Point[] line = lineBetween(points.get(index - 1), points.get(index - 2));
                    Point a = line[0];
                    Point b = line[1];
                    gr.setColor(circleFill);
                    gr.drawLine(a.x, a.y, b.x, b.y);
                }
                gr.setColor(circleFill);
                gr.fillOval(rect.x, rect.y, rect.width, rect.height);
                gr.setColor(textFill);
                gr.drawString(String.valueOf(index), p.x, p.y);
            } else {
                if (index > 1) {
                    Point[] line = lineBetween(points.get(index - 1), points.get(index - 2));
                    Point a = line[0];
                    Point b = line[1];
                    gr.setStroke(new BasicStroke(1));
                    gr.setColor(circleFill);
                    gr.drawLine(a.x, a.y, b.x, b.y);
                }
                gr.setColor(circleFill);
                gr.drawOval(rect.x, rect.y, rect.width, rect.height);
                gr.drawString(String.valueOf(index), p.x, p.y);
            }
            index++;
        }
    }

    public Point getTextPosition(String text, Font font, int x, int y, int width, int height) {
        int textWidth = getFontMetrics(font).stringWidth(text);
        x += (width - textWidth) / 2;
        y += (height + font.getSize()) / 2;
        return new Point(x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).contains(p)) {
                setStep(i + 1);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).contains(p)) {
                hover.set(i, Boolean.TRUE);
            } else {
                hover.set(i, Boolean.FALSE);
            }
        }
        repaint();
    }

    public interface StepListener {

        public void stepChanged(int step);
    }
}
