package hospitalsystem;

import hospitalsystem.custom.MCalendar;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DashBoard extends JPanel {

    private ImageHeader imageHeader;
    private final MainWindow mainWindow;

    private LogInInformation logInInformation;
    private JPanel topPanel;

    private JLabel welcomeMessage;

    private Calendar logInTime;
    private Calendar currentTime;

    public DashBoard(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        logInTime = Calendar.getInstance();
        currentTime = Calendar.getInstance();
        setLayout(new BorderLayout());
        setOpaque(false);

        logInInformation = new LogInInformation();
        logInInformation.setOpaque(false);

        topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        welcomeMessage = new JLabel("Welcome, " + mainWindow.getUser().getFirstName() + " " + mainWindow.getUser().getLastName());
        welcomeMessage.setFont(Tools.headerFont);
        welcomeMessage.setHorizontalTextPosition(SwingConstants.CENTER);
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);

        add(logInInformation);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (imageHeader == null && getWidth() != 0) {
            imageHeader = new ImageHeader(Tools.getImageIcon(this, "images/background.png"),
                    "Hospital System",
                    getWidth(),
                    60,
                    30,
                    Font.PLAIN,
                    Color.WHITE);
            topPanel.add(imageHeader, BorderLayout.NORTH);
            topPanel.add(welcomeMessage);
            add(topPanel, BorderLayout.NORTH);
        }
    }

    private class LogInInformation extends JPanel {

        private MCalendar calendar;
        private CirclePanel logInTimePanel;
        private CirclePanel currentTimePanel;

        public LogInInformation() {
            logInTimePanel = new CirclePanel("Log in time", Tools.getTime(logInTime));
            calendar = new MCalendar(500, 300);
            currentTimePanel = new CirclePanel("Current time", Tools.getTime(currentTime));
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    currentTimePanel.setText(Tools.getTime(Calendar.getInstance()));
                }
            }, 0, 1000);

            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(0, 10, 0, 10);
            add(logInTimePanel, c);
            c.gridx = 1;
            add(calendar, c);
            c.gridx = 2;
            add(currentTimePanel, c);
        }
    }

    private class CirclePanel extends JPanel {

        private JLabel titleLabel;
        private JLabel textLabel;

        private int strokeWidth = 5;

        public CirclePanel(String title, String text) {
            setOpaque(false);
            JPanel main = new JPanel();

            calculateWidth(title, text);
            main.setLayout(new BorderLayout());
            main.setOpaque(false);
            titleLabel = new JLabel(title);
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            titleLabel.setFont(Tools.defaultBoldFont);
            textLabel = new JLabel(text);
            textLabel.setHorizontalAlignment(SwingConstants.CENTER);
            textLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            textLabel.setFont(Tools.defaultFont);

            main.add(titleLabel, BorderLayout.NORTH);
            main.add(Box.createVerticalStrut(20));
            main.add(textLabel, BorderLayout.SOUTH);

            setLayout(new GridBagLayout());
            add(main);

        }

        public void setText(String text) {
            this.textLabel.setText(text);
        }

        private void calculateWidth(String title, String text) {
            int width = getFontMetrics(Tools.defaultBoldFont).stringWidth(title);
            int width2 = getFontMetrics(Tools.defaultFont).stringWidth(text);
            int w = width > width2 ? width : width2;
            this.setPreferredSize(new Dimension(w * 2, w * 2));
            this.setSize(getPreferredSize());
        }

        @Override
        public void paint(Graphics gr) {
            super.paint(gr);
            Graphics2D g = (Graphics2D) gr;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setStroke(new BasicStroke(strokeWidth));
            g.setColor(new Color(168, 0, 64));
            g.drawOval(strokeWidth, strokeWidth, getWidth() - (strokeWidth * 2), getHeight() - (strokeWidth * 2));
        }
    }
}
