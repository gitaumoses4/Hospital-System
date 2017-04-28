package hospitalsystem;

import forms.MedicalTreatmentsForm;
import forms.ServiceTreatmentsForm;
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
public class ServiceTreatmentsPanel extends ImageHeaderPanel {

    private ServiceTreatmentsForm serviceTreatments;
    private JTable medicalInformationTable;

    private JLabel netTotalLabel = new JLabel("Net Total");
    private MTextField netTotalField = new MTextField(15);

    private OptionsPanel options;
    private final MainWindow mainWindow;

    public ServiceTreatmentsPanel(MainWindow mainWindow) {
        super("Add Service Treatments", 60);
        this.mainWindow = mainWindow;

        serviceTreatments = new ServiceTreatmentsForm();
        medicalInformationTable = new JTable();

        options = new OptionsPanel(OptionsPanel.Options.ADD_NEW, OptionsPanel.Options.DELETE, OptionsPanel.Options.CLOSE);

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 4;
        mainPanel.add(serviceTreatments, c);
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
