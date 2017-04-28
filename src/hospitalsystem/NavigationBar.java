package hospitalsystem;

import hospitalsystem.custom.ImageButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class NavigationBar extends JPanel {

    private MainWindow mainWindow;
    private static int NAVIGATION_WIDTH = 250;

    private Color titleColor = Color.WHITE;
    private Color titleBackground = Color.BLACK;
    private int titleHeight = 60;

    private BoxLayout layout;

    private TitleLabel recordExplorer;
    private ImageButton manageInpatients;
    private ImageButton manageOutpatients;
    private ImageButton chanellingServices;
    private ImageButton managePayments;
    private ImageButton reportsQuickLaunch;
    private ImageButton searchEngine;

    private TitleLabel userAccountManagement;
    private ImageButton changePassword;
    private ImageButton logOut;

    public NavigationBar(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(NAVIGATION_WIDTH, getPreferredSize().height));
        setSize(getPreferredSize());

        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        recordExplorer = new TitleLabel("Record Explorer");
        add(recordExplorer);

        manageInpatients = new ImageButton(Tools.getImageIcon(this, "images/inpatients.png"), "Manage Inpatients", ImageButton.RIGHT, getWidth(), false);
        manageInpatients.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        manageInpatients.addActionListener(navigationListener);
        manageOutpatients = new ImageButton(Tools.getImageIcon(this, "images/outpatients.png"), "Manage Outpatients", ImageButton.RIGHT, getWidth(), false);
        manageOutpatients.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        manageOutpatients.addActionListener(navigationListener);
        chanellingServices = new ImageButton(Tools.getImageIcon(this, "images/chanelling_services.png"), "Chanelling Services", ImageButton.RIGHT, getWidth(), false);
        chanellingServices.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        chanellingServices.addActionListener(navigationListener);
        managePayments = new ImageButton(Tools.getImageIcon(this, "images/payments.png"), "Manage Payments", ImageButton.RIGHT, getWidth(), false);
        managePayments.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        managePayments.addActionListener(navigationListener);
        reportsQuickLaunch = new ImageButton(Tools.getImageIcon(this, "images/reports.png"), "Reports Quick Launch", ImageButton.RIGHT, getWidth(), false);
        reportsQuickLaunch.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        searchEngine = new ImageButton(Tools.getImageIcon(this, "images/search.png"), "Search Engine", ImageButton.RIGHT, getWidth(), false);
        searchEngine.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        searchEngine.addActionListener(navigationListener);

        add(manageInpatients);
        add(Box.createVerticalStrut(10));
        add(manageOutpatients);
        add(Box.createVerticalStrut(10));
        add(chanellingServices);
        add(Box.createVerticalStrut(10));
        add(managePayments);
        // add(Box.createVerticalStrut(10));
        // add(reportsQuickLaunch);
        add(Box.createVerticalStrut(10));
        add(searchEngine);
        add(Box.createVerticalStrut(10));

        userAccountManagement = new TitleLabel("User Account Management");
        add(userAccountManagement);
        add(Box.createVerticalStrut(10));

        changePassword = new ImageButton(Tools.getImageIcon(this, "images/change_password.png"), "Change Password", ImageButton.RIGHT, getWidth(), false);
        changePassword.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        logOut = new ImageButton(Tools.getImageIcon(this, "images/logout.png"), "Log out", ImageButton.RIGHT, getWidth(), false);
        logOut.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);

        add(changePassword);
        add(Box.createVerticalStrut(10));
        add(logOut);
        add(Box.createVerticalStrut(10));

        add(Box.createVerticalStrut(Integer.MAX_VALUE));
    }

    private class TitleLabel extends JPanel {

        private String text;

        private JLabel textLabel;

        public TitleLabel(String text) {
            setPreferredSize(new Dimension(NavigationBar.NAVIGATION_WIDTH, titleHeight));
            setSize(getPreferredSize());
            setMinimumSize(getSize());
            setMaximumSize(getSize());
            this.text = text;

            textLabel = new JLabel(text);
            textLabel.setFont(Tools.defaultBoldFont);
            textLabel.setForeground(titleColor);

            setBackground(titleBackground);

            setLayout(new GridBagLayout());
            add(textLabel);
        }
    }

    private ActionListener navigationListener = (ActionEvent e) -> {
        Object o = e.getSource();
        Interfaces toShow = null;
        if (o == manageInpatients) {
            toShow = Interfaces.INPATIENTS_MANAGEMENT;
        } else if (o == manageOutpatients) {
            toShow = Interfaces.INPATIENTS_MANAGEMENT;
        } else if (o == this.chanellingServices) {
            toShow = Interfaces.APPOINTMENT_MANAGEMENT;
        } else if (o == this.managePayments) {

        } else if (o == this.searchEngine) {
            toShow = Interfaces.SEARCH_ENGINE;
        }
        if (toShow != null) {
            mainWindow.show(toShow);
        }
    };
}
