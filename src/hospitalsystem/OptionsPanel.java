package hospitalsystem;

import hospitalsystem.custom.ImageButton;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class OptionsPanel extends JPanel {

    private ArrayList<ImageButton> buttons = new ArrayList();

    private ImageIcon[] icons = new ImageIcon[]{
        Tools.getImageIcon(this, "images/add_new.png"),
        Tools.getImageIcon(this, "images/search.png"),
        Tools.getImageIcon(this, "images/save.png"),
        Tools.getImageIcon(this, "images/update.png"),
        Tools.getImageIcon(this, "images/delete.png"),
        Tools.getImageIcon(this, "images/close.png"),};

    private String[] titles = new String[]{"Add New", "Search", "Save", "Update", "Delete", "Close"};

    private Options[] options = new Options[]{Options.ADD_NEW, Options.SEARCH, Options.SAVE, Options.UPDATE, Options.DELETE, Options.CLOSE};

    public OptionsPanel() {
        setOpaque(false);
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);
        for (int i = 0; i < titles.length; i++) {
            ImageButton button = new ImageButton(icons[i],
                    titles[i],
                    false);
            button.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
            add(button);
            add(Box.createHorizontalStrut(10));
            buttons.add(button);
        }
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(10, 10, 10, 10),
                        BorderFactory.createLineBorder(Color.black)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    public OptionsPanel(Options... options) {
        setOpaque(false);
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);
        for (int i = 0; i < titles.length; i++) {
            for (Options option : options) {
                if (option.equals(this.options[i])) {
                    ImageButton button = new ImageButton(icons[i],
                            titles[i],
                            false);
                    button.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
                    add(button);
                    add(Box.createHorizontalStrut(10));
                    buttons.add(button);
                }
            }
        }
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(10, 10, 10, 10),
                        BorderFactory.createLineBorder(Color.black)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    public enum Options {

        ADD_NEW, SEARCH, SAVE, UPDATE, DELETE, CLOSE
    }
}
