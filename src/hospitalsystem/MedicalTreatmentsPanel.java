package hospitalsystem;

import forms.MedicalTreatmentsForm;
import hospitalsystem.OptionsPanel.Options;
import hospitalsystem.custom.MTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Moses Muigai Gitau
 */
public class MedicalTreatmentsPanel extends ImageHeaderPanel {

    private MedicalTreatmentsForm medicalTreatments;
    private JTable medicalInformationTable;

    private JLabel netTotalLabel = new JLabel("Net Total");
    private MTextField netTotalField = new MTextField(15);

    private OptionsPanel options;
    private final MainWindow mainWindow;

    public MedicalTreatmentsPanel(MainWindow mainWindow) {
        super("Add Medical Treatments", 60);
        this.mainWindow = mainWindow;

        medicalTreatments = new MedicalTreatmentsForm();
        medicalInformationTable = new JTable();

        options = new OptionsPanel(Options.ADD_NEW, Options.DELETE, Options.CLOSE);

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 4;
        mainPanel.add(medicalTreatments, c);
        c.gridx = 1;
        c.gridheight = 3;
        mainPanel.add(new JScrollPane(medicalInformationTable), c);
        c.gridy = 3;
        c.gridheight = 1;
        mainPanel.add(Tools.formLayout(netTotalLabel, netTotalField), c);
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 2;
        mainPanel.add(options, c);
    }
}
