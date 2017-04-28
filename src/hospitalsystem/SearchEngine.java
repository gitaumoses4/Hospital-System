package hospitalsystem;

import hospitalsystem.OptionsPanel.Options;
import hospitalsystem.custom.ImageButton;
import hospitalsystem.custom.MTextField;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Moses Muigai Gitau
 */
public class SearchEngine extends ImageHeaderPanel {

    public JLabel informationTableLabel = new JLabel("Information Table");
    public JLabel searchCriteriaLabel = new JLabel("Search Criteria");
    public JLabel searchTextLabel = new JLabel("Search Text");

    public JComboBox informationTableCombo = new JComboBox();
    public JComboBox searchCriteriaCombo = new JComboBox();
    public MTextField searchTextField = new MTextField(15);

    public JTable table = new JTable();
    private final MainWindow mainWindow;

    private ImageButton closeButton;

    public SearchEngine(MainWindow mainWindow) {
        super("Search Engine", 60);

        closeButton = new ImageButton(Tools.getImageIcon(this, "images/close.png"), "Close", false);
        closeButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        JPanel navigation = new JPanel();
        BoxLayout box = new BoxLayout(navigation, BoxLayout.X_AXIS);
        navigation.setLayout(box);
        navigation.setOpaque(false);
        navigation.add(Tools.formLayout(informationTableLabel, informationTableCombo, false));
        navigation.add(Tools.formLayout(searchCriteriaLabel, searchCriteriaCombo, false));
        navigation.add(Tools.formLayout(searchTextLabel, searchTextField, false));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(navigation, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table));

        JPanel south = new JPanel();
        south.setOpaque(false);
        south.add(closeButton);
        mainPanel.add(south, BorderLayout.SOUTH);

        this.mainWindow = mainWindow;
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
}
