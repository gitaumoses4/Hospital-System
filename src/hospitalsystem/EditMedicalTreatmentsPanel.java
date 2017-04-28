package hospitalsystem;

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
public class EditMedicalTreatmentsPanel extends ImageHeaderPanel {

    private final MainWindow mainWindow;
    private EditMedicalTreatmentForm editMedicalTreatment;

    private JTable medicalTreatmentsTable = new JTable();
    private OptionsPanel options;
    private NavigationPanel navigation;
    private CriteriaSearchPanel searchPanel;

    public EditMedicalTreatmentsPanel(MainWindow mainWindow) {
        super("Medical Treatments Maintenance", 60);
        this.mainWindow = mainWindow;

        searchPanel = new CriteriaSearchPanel("Treatment ID,Patient ID,Patient's First Name,Patient's Last Name".split(","));
        editMedicalTreatment = new EditMedicalTreatmentForm();
        options = new OptionsPanel(Options.UPDATE, Options.CLOSE);
        navigation = new NavigationPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        mainPanel.add(searchPanel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 6;
        mainPanel.add(editMedicalTreatment, c);
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
