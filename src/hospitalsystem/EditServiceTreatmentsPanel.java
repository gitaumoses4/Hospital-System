package hospitalsystem;

import forms.EditMedicalTreatmentForm;
import forms.EditServiceTreatmentForm;
import hospitalsystem.custom.MTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Moses Muigai Gitau
 */
public class EditServiceTreatmentsPanel extends ImageHeaderPanel {

    private final MainWindow mainWindow;
    private EditServiceTreatmentForm editServiceTreatment;

    private JTable medicalTreatmentsTable = new JTable();
    private OptionsPanel options;
    private NavigationPanel navigation;
    private CriteriaSearchPanel searchPanel;

    public EditServiceTreatmentsPanel(MainWindow mainWindow) {
        super("Service Treatments Maintenance", 60);
        this.mainWindow = mainWindow;

        searchPanel = new CriteriaSearchPanel("Treatment ID,Patient ID,Patient's First Name,Patient's Last Name".split(","));
        editServiceTreatment = new EditServiceTreatmentForm();
        options = new OptionsPanel(OptionsPanel.Options.UPDATE, OptionsPanel.Options.CLOSE);
        navigation = new NavigationPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        mainPanel.add(searchPanel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 6;
        mainPanel.add(editServiceTreatment, c);
        c.gridx = 1;
        c.gridheight = 3;
        JScrollPane scroll;
        mainPanel.add(scroll = new JScrollPane(medicalTreatmentsTable), c);
        scroll.setPreferredSize(new Dimension(450, 300));
        c.gridy = 4;
        c.gridheight = 1;
        mainPanel.add(navigation, c);
        c.gridy = 5;
        mainPanel.add(options, c);
    }
}
