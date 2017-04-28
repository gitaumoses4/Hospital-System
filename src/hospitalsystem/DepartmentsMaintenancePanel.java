package hospitalsystem;

import forms.DepartmentsInformationForm;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DepartmentsMaintenancePanel extends ImageHeaderPanel {

    private final MainWindow mainWindow;
    private DepartmentsInformationForm departmentsInformation;

    private JTable departmentsTable = new JTable();
    private OptionsPanel options;
    private NavigationPanel navigation;
    private CriteriaSearchPanel searchPanel;

    public DepartmentsMaintenancePanel(MainWindow mainWindow) {
        super("Departments Maintenance Module", 60);
        this.mainWindow = mainWindow;

        searchPanel = new CriteriaSearchPanel("Department ID,Department Name".split(","));
        departmentsInformation = new DepartmentsInformationForm();
        options = new OptionsPanel();
        navigation = new NavigationPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        mainPanel.add(searchPanel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 6;
        mainPanel.add(departmentsInformation, c);
        c.gridx = 1;
        c.gridheight = 3;
        JScrollPane scroll;
        mainPanel.add(scroll = new JScrollPane(departmentsTable), c);
        scroll.setPreferredSize(new Dimension(450, 300));
        c.gridy = 4;
        c.gridheight = 1;
        mainPanel.add(navigation, c);
        c.gridy = 5;
        mainPanel.add(options, c);
    }
}
