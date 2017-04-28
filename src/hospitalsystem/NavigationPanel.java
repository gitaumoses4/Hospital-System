package hospitalsystem;

import hospitalsystem.custom.ImageButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class NavigationPanel extends JPanel {

    private ImageButton firstButton;
    private ImageButton previousButton;
    private ImageButton nextButton;
    private ImageButton lastButton;

    public NavigationPanel() {
        setOpaque(false);
        firstButton = new ImageButton(Tools.getImageIcon(this, "images/first.png"), "First", ImageButton.BOTTOM, false);
        firstButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        previousButton = new ImageButton(Tools.getImageIcon(this, "images/previous.png"), "Previous", ImageButton.BOTTOM, false);
        previousButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        nextButton = new ImageButton(Tools.getImageIcon(this, "images/next.png"), "Next", ImageButton.BOTTOM, false);
        nextButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        lastButton = new ImageButton(Tools.getImageIcon(this, "images/last.png"), "Last", ImageButton.BOTTOM, false);
        lastButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);

        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);

        add(firstButton);
        add(Box.createHorizontalStrut(10));
        add(previousButton);
        add(Box.createHorizontalStrut(10));
        add(nextButton);
        add(Box.createHorizontalStrut(10));
        add(lastButton);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(10, 10, 10, 10),
                        BorderFactory.createLineBorder(Color.black)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }
}
