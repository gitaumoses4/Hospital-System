package hospitalsystem;

import forms.WardInformationForm;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Moses Muigai Gitau
 */
public class WardMaintenancePanel extends ImageHeaderPanel {

    private final MainWindow mainWindow;
    private WardInformationForm wardInformationForm;

    private JTable wardTable = new JTable();
    private OptionsPanel options;
    private NavigationPanel navigation;
    private CriteriaSearchPanel searchPanel;

    public WardMaintenancePanel(MainWindow mainWindow) {
        super("Wards Maintenance Module", 60);
        this.mainWindow = mainWindow;

        searchPanel = new CriteriaSearchPanel("Ward ID,Ward Number".split(","));
        wardInformationForm = new WardInformationForm();
        options = new OptionsPanel();
        navigation = new NavigationPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        mainPanel.add(searchPanel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 6;
        mainPanel.add(wardInformationForm, c);
        c.gridx = 1;
        c.gridheight = 3;
        JScrollPane scroll;
        mainPanel.add(scroll = new JScrollPane(wardTable), c);
        scroll.setPreferredSize(new Dimension(450, 300));
        c.gridy = 4;
        c.gridheight = 1;
        mainPanel.add(navigation, c);
        c.gridy = 5;
        mainPanel.add(options, c);
    }
}
