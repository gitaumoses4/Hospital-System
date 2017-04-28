package hospitalsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class ImageHeaderPanel extends JPanel {

    private ImageHeader imageHeader;
    private final String headerText;
    private final int headerSize;

    protected final JPanel mainPanel;

    public ImageHeaderPanel(String headerText, int headerSize) {
        this.headerText = headerText;
        this.headerSize = headerSize;
        setLayout(new BorderLayout());
        setOpaque(false);

        imageHeader = new ImageHeader(Tools.getImageIcon(this, "images/background.png"),
                headerText,
                this.getPreferredSize().width,
                headerSize,
                headerSize * 2 / 3,
                Font.PLAIN,
                Color.WHITE);
        add(imageHeader, BorderLayout.NORTH);
        mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        add(mainPanel);
    }

}
