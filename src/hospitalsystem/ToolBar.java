package hospitalsystem;

import hospitalsystem.custom.ImageLabel;
import hospitalsystem.custom.ImageButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Moses Muigai Gitau
 */
public class ToolBar extends JPanel {

    private final MainWindow mainWindow;
    private final User user;
    private final WelcomePanel welcomePanel;
    private final ExitPanel exitPanel;

    private static final int TOOL_BAR_HEIGHT = 80;

    public ToolBar(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.setPreferredSize(new Dimension(this.getPreferredSize().width, TOOL_BAR_HEIGHT));
        setLayout(new BorderLayout());
        user = mainWindow.getUser();

        welcomePanel = new WelcomePanel(user.getFirstName(), user.getLastName());
        exitPanel = new ExitPanel();
        add(welcomePanel, BorderLayout.WEST);
        add(exitPanel, BorderLayout.EAST);
        setBackground(Color.WHITE);
    }

    private class WelcomePanel extends JPanel {

        private ImageIcon profile = new ImageIcon(getClass().getResource("images/profile.png"));
        private ImageLabel profileIcon;
        private JLabel welcomeMessage;
        private JLabel dateMessage;

        public WelcomePanel(String firstname, String lastname) {
            JPanel main = new JPanel();
            main.setOpaque(false);
            profileIcon = new ImageLabel(profile, Tools.ICON_SIZE, Tools.ICON_SIZE);
            welcomeMessage = new JLabel("Welcome, " + firstname + " " + lastname);
            welcomeMessage.setFont(Tools.defaultFont);
            dateMessage = new JLabel("Date: " + Tools.getLongDate(Calendar.getInstance()));
            dateMessage.setFont(Tools.defaultFont);
            profileIcon.setHorizontalAlignment(SwingConstants.CENTER);
            profileIcon.setVerticalAlignment(SwingConstants.CENTER);
            main.add(profileIcon);

            JPanel other = new JPanel(new GridLayout(2, 1));
            other.setOpaque(false);
            other.add(welcomeMessage);
            other.add(dateMessage);
            main.add(other);

            setLayout(new GridBagLayout());
            add(main);
            setOpaque(false);
        }
    }

    private class ExitPanel extends JPanel {

        private final ImageIcon logOut = Tools.getImageIcon(this, "images/logout.png");
        private final ImageIcon exit = Tools.getImageIcon(this, "images/exit.png");

        private ImageButton exitButton;
        private ImageButton logOutButton;

        public ExitPanel() {
            JPanel main = new JPanel();
            main.setOpaque(false);
            exitButton = new ImageButton(exit, "Exit", ImageButton.RIGHT, false);
            exitButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
            exitButton.setFont(Tools.defaultFont);
            exitButton.addActionListener((ActionEvent e) -> {
                int option = JOptionPane.showConfirmDialog(mainWindow, "Do you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            });
            logOutButton = new ImageButton(logOut, "Logout", ImageButton.RIGHT, false);
            logOutButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
            logOutButton.setFont(Tools.defaultFont);
            logOutButton.addActionListener((ActionEvent e) -> {
                int option = JOptionPane.showConfirmDialog(mainWindow, "Do you want to log out?", "Log out", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    mainWindow.showLogIn();
                }
            });

            main.add(exitButton);
            main.add(logOutButton);

            setLayout(new GridBagLayout());
            add(main);
            setOpaque(false);
        }
    }
}
