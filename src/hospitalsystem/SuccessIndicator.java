package hospitalsystem;

import hospitalsystem.SuccessIndicator.Animator.AnimationListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JComponent;

/**
 *
 * @author Moses Muigai Gitau
 */
public class SuccessIndicator extends JComponent {

    private int circleAngle = 0;
    private Tick tick;
    private int duration;

    private int circleStrokeWidth;
    private int tickStrokeWidth;
    private Color circleColor;
    private Color lineColor;
    private String text;
    private Color fontColor;
    private int fontSize;

    private int width;
    private int height;

    private Font font;

    private ArrayList<AnimationListener> listeners = new ArrayList();

    public SuccessIndicator(String text, Color fontColor, int fontSize, int width, int height, int duration, int circleStrokeWidth, int tickStrokeWidth, Color circleColor, Color lineColor) {
        this.text = text;
        this.font = new Font(Font.DIALOG, Font.PLAIN, fontSize);
        setPreferredSize(new Dimension(width + circleStrokeWidth + circleStrokeWidth + getTextWidth(),
                height + circleStrokeWidth + circleStrokeWidth)
        );
        setSize(width, height);
        this.fontColor = fontColor;
        this.fontSize = fontSize;
        this.width = width;
        this.height = height;
        this.circleStrokeWidth = circleStrokeWidth;
        this.tickStrokeWidth = tickStrokeWidth;
        tick = new Tick(width, height);
        this.duration = duration;
        this.circleColor = circleColor;
        this.lineColor = lineColor;
    }

    private int getTextWidth() {
        return getFontMetrics(font).stringWidth(text);
    }

    public SuccessIndicator(String text, int width, int height, int duration) {
        this(text, Color.BLACK, width / 3, width, height, duration, 5, 5, Color.GREEN, Color.GREEN);
    }

    public void startAnimation() {
        animateTick(0, tick.getMaxLength(), duration);
        animateCircle(0, 360, duration);
    }

    public void animateTick(int start, int end, int duration) {
        Animator animator = new Animator(start, end, duration);
        animator.addAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationUpdate(int value) {
                tick.createPath(value);
                repaint();
            }

            @Override
            public void animationStarted() {
            }

            @Override
            public void animationEnded() {
            }

        });
        animator.startAnimation();
    }

    public void animateCircle(int start, int end, int duration) {
        Animator animator = new Animator(start, end, duration);
        animator.addAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationUpdate(int value) {
                circleAngle = value;
                repaint();
                SuccessIndicator.this.fireAnimationUpdate(value);
            }

            @Override
            public void animationStarted() {
                SuccessIndicator.this.fireAnimationStarted();
            }

            @Override
            public void animationEnded() {
                SuccessIndicator.this.fireAnimationEnded();
            }

        });
        animator.startAnimation();
    }

    public void setText(String text) {
        this.text = text;
        repaint();
    }

    public void setFontColor(Color color) {
        this.fontColor = color;
        repaint();
    }

    public void setFontSize(int size) {
        this.fontSize = size;
        font = new Font(Font.DIALOG, Font.PLAIN, fontSize);
        repaint();
    }

    private void fireAnimationUpdate(int value) {
        for (AnimationListener l : listeners) {
            l.onAnimationUpdate(value);
        }
    }

    private void fireAnimationStarted() {
        for (AnimationListener l : listeners) {
            l.animationStarted();
        }
    }

    private void fireAnimationEnded() {
        for (AnimationListener l : listeners) {
            l.animationEnded();
        }
    }

    public void addAnimationListener(AnimationListener listener) {
        this.listeners.add(listener);
    }

    public void removeAnimationListener(AnimationListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(lineColor);
        g.setStroke(new BasicStroke(tickStrokeWidth));
        Polygon p = tick.getPolygon();
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);

        g.setColor(circleColor);
        g.setStroke(new BasicStroke(circleStrokeWidth));
        g.drawArc(circleStrokeWidth, circleStrokeWidth, width, height, 90, -circleAngle);

        g.setFont(font);
        int stringX = width + circleStrokeWidth + circleStrokeWidth;
        int stringY = (height + fontSize) / 2;
        g.setColor(fontColor);
        g.drawString(text, stringX, stringY);
    }

    private class Tick {

        Polygon polygon = new Polygon();

        int startX;
        int startY;

        private int firstLength;

        private double firstAngle = 45;
        private double lastAngle = 45;

        private int maxLength;

        public Tick(int width, int height) {
            startX = circleStrokeWidth + circleStrokeWidth / 2 + width / 6;
            startY = circleStrokeWidth + circleStrokeWidth / 2 + height / 2;
            firstLength = width / 4;
            maxLength = width * 4 / 5;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public void createPath(int length) {
            if (length <= firstLength) {
                int x = getX(startX, length, firstAngle);
                int y = getY(startY, length, firstAngle);
                int xPoints[] = {startX, x};
                int yPoints[] = {startY, y};
                polygon.xpoints = xPoints;
                polygon.ypoints = yPoints;
                polygon.npoints = 2;
            } else {
                int x = getX(startX, firstLength, firstAngle);
                int y = getY(startY, firstLength, firstAngle);

                int x1 = getX(x, length - firstLength, 180 - lastAngle);
                int y1 = getY(y, length - firstLength, 180 - lastAngle);

                int xPoints[] = {startX, x, x1};
                int yPoints[] = {startY, y, y1};
                polygon.xpoints = xPoints;
                polygon.ypoints = yPoints;
                polygon.npoints = 3;
            }

        }

        public Polygon getPolygon() {
            return polygon;
        }

        private int getX(int startX, int length, double angle) {
            return (int) (startX + (length * (Math.sin(Math.toRadians(angle)))));
        }

        private int getY(int startY, int length, double angle) {
            return (int) (startY + ((length * (Math.cos(Math.toRadians(angle))))));
        }
    }

    public static class Animator extends java.util.TimerTask {

        private int start;
        private int end;
        private int duration;

        private int change;
        private int value;

        private ArrayList<AnimationListener> listeners = new ArrayList();
        private Timer timer;

        public Animator(int start, int end, int duration) {
            this.start = start;
            this.end = end;
            this.duration = duration;
            if (start < end) {
                value = start;
                change = duration / (end - start);
            } else {
                value = end;
                change = duration / (start - end);
            }
        }

        public void startAnimation() {
            this.timer = new Timer();
            timer.scheduleAtFixedRate(this, 0, change);
            this.fireAnimationStarted();
        }

        @Override
        public void run() {
            if (start < end && value <= end) {
                value++;
            } else if (start > end && value >= start) {
                value--;
            }
            if (start < end) {
                if (value == end) {
                    timer.cancel();
                    this.fireAnimationEnded();
                }
            } else {
                if (value == end) {
                    timer.cancel();
                    this.fireAnimationEnded();
                }
            }
            fireAnimationUpdate();
        }

        private void fireAnimationUpdate() {
            for (AnimationListener l : listeners) {
                l.onAnimationUpdate(value);
            }
        }

        private void fireAnimationStarted() {
            for (AnimationListener l : listeners) {
                l.animationStarted();
            }
        }

        private void fireAnimationEnded() {
            for (AnimationListener l : listeners) {
                l.animationEnded();
            }
        }

        public void addAnimationListener(AnimationListener listener) {
            this.listeners.add(listener);
        }

        public void removeAnimationListener(AnimationListener listener) {
            this.listeners.remove(listener);
        }

        public static interface AnimationListener {

            public void onAnimationUpdate(int value);

            public void animationStarted();

            public void animationEnded();
        }
    }

    public static void main(String[] args) {
        Animator animator = new Animator(0, 2000, 200);
        animator.startAnimation();
        animator.addAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationUpdate(int value) {
            }

            @Override
            public void animationStarted() {
            }

            @Override
            public void animationEnded() {
            }

        });
    }

}
