package hospitalsystem;

import database.DatabaseFunctions;
import hospitalsystem.SuccessIndicator.Animator.AnimationListener;
import hospitalsystem.custom.MPasswordField;
import hospitalsystem.custom.MTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class LogIn extends JFrame {

    private final Dimension size = new Dimension(600, 500);

    private final JLabel usernameLabel = new JLabel("Username: ");
    private final JLabel passwordLabel = new JLabel("Password: ");

    private final MTextField usernameField = new MTextField(20);
    private final MPasswordField passwordField = new MPasswordField(20);

    private final JButton logInButton = new JButton("Login");

    private final GridBagLayout layout = new GridBagLayout();
    private final GridBagConstraints c = new GridBagConstraints();

    private final JPanel mainPanel = new JPanel();
    private final ImageHeader header;

    public SuccessIndicator indicator = new SuccessIndicator("Enter your login credentials",
            Color.BLACK, 25, 100, 100, 1500, 5, 5, Color.GREEN, Color.BLACK);

    public LogIn() {
        setTitle("Hospital System Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(size);
        setLocationRelativeTo(null);
        mainPanel.setLayout(layout);
        mainPanel.setBackground(Color.WHITE);
        header = new ImageHeader(
                new ImageIcon(getClass().getResource("images/background.png")),
                "Hospital System",
                getWidth(),
                100,
                50,
                Font.BOLD,
                Color.WHITE);
        init();
        add(header, BorderLayout.NORTH);
        add(mainPanel);
    }

    private void init() {
        Insets insets = new Insets(10, 20, 10, 20);
        c.insets = insets;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        mainPanel.add(indicator, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        mainPanel.add(usernameLabel, c);

        c.gridx = 1;
        mainPanel.add(usernameField, c);

        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(passwordLabel, c);

        c.gridx = 1;
        mainPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        mainPanel.add(logInButton, c);
        logInButton.setPreferredSize(new Dimension(400, 40));
        logInButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            MainWindow mainWindow = new MainWindow(DatabaseFunctions.getUser(username));
            if (validateUser(username, password)) {
                logInButton.setEnabled(false);
                indicator.setText("Log in successful");
                indicator.startAnimation();
                indicator.addAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationUpdate(int value) {
                    }

                    @Override
                    public void animationStarted() {
                    }

                    @Override
                    public void animationEnded() {
                        mainWindow.setVisible(true);
                        dispose();
                    }
                });
            } else {
                Tools.error("Invalid username/password", "Log in error");
            }
        });
    }

    public boolean validateUser(String username, String password) {
        User user = DatabaseFunctions.getUser(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
