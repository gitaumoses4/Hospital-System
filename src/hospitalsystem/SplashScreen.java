package hospitalsystem;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *
 * @author Moses Muigai Gitau
 */
public abstract class SplashScreen extends JWindow {

    private JProgressBar progressBar;
    private JLabel progressInformation;
    private JLabel image;
    private ImageIcon icon;

    private Timer timer;

    private int count = 0;

    public SplashScreen(int delay, int milliseconds) {
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        icon = new ImageIcon(getClass().getResource("images/splash.png"));

        image = new JLabel(icon);
        progressInformation = new JLabel("Loading");
        add(image);

        int width = icon.getIconWidth();
        int height = icon.getIconHeight();

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;

        setBounds(x, y, width, height);
        progressBar.setBounds(20, height - 50, 200, 15);
        progressInformation.setBounds(20, height - 30, 200, 20);

        getLayeredPane().add(progressBar);
        getLayeredPane().add(progressInformation);
        getContentPane().setBackground(new Color(0, 0, 0, 0));

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count += (milliseconds / 100);
                progressBar.setValue((count * 100 / milliseconds));
                if (count >= milliseconds) {
                    timer.cancel();
                    splashScreenHidden();
                }
            }
        }, delay, milliseconds / 100);
    }

    public abstract void splashScreenHidden();

    public void setMessage(String message) {
        this.progressInformation.setText(message);
    }
}
