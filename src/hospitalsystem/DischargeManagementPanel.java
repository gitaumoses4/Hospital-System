package hospitalsystem;

import forms.DischargeForm;
import forms.EditMedicalTreatmentForm;
import hospitalsystem.OptionsPanel.Options;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DischargeManagementPanel extends ImageHeaderPanel {

    private final MainWindow mainWindow;
    private DischargeForm dischargeForm;

    private JTable medicalTreatmentsTable = new JTable();
    private OptionsPanel options;
    private NavigationPanel navigation;
    private CriteriaSearchPanel searchPanel;

    public DischargeManagementPanel(MainWindow mainWindow) {
        super("Discharge Details Maintenance", 60);
        this.mainWindow = mainWindow;

        searchPanel = new CriteriaSearchPanel("Discharge ID,Admission ID,Patient ID,Patient's First Name,Patient's Last Name".split(","));
        dischargeForm = new DischargeForm();
        options = new OptionsPanel(OptionsPanel.Options.ADD_NEW, Options.SAVE, Options.UPDATE, Options.DELETE, Options.CLOSE);
        navigation = new NavigationPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        mainPanel.add(searchPanel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 6;
        mainPanel.add(dischargeForm, c);
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
