package forms;

import hospitalsystem.Tools;
import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DischargeForm extends JPanel {

    public JLabel dischargeIdLabel = new JLabel("Discharge ID");
    public JLabel admissionIdLabel = new JLabel("Admission ID");
    public JLabel patientIdLabel = new JLabel("Patient ID");
    public JLabel firstNameLabel = new JLabel("First Name");
    public JLabel surnameLabel = new JLabel("Surname");
    public JLabel admissionDateLabel = new JLabel("Admission Date");
    public JLabel admissionTimeLabel = new JLabel("Admission Time");
    public JLabel dischargeDateLabel = new JLabel("Discharge Date");
    public JLabel dischargeTimeLabel = new JLabel("Discharge Time");
    public JLabel additionalNotesLabel = new JLabel("Additional Notes");

    public MTextField dischargeIdField = new MTextField(15);
    public MTextField admissionIdField = new MTextField(15);
    public MTextField patientIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField surnameField = new MTextField(15);
    public MTextField admissionDateField = new MTextField(15);
    public MTextField admissionTimeField = new MTextField(15);
    public MTextField dischargeDateField = new MTextField(15);
    public MTextField dischargeTimeField = new MTextField(15);
    public MTextField additionalNotesField = new MTextField(15);

    public DischargeForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Discharge Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();

        panels.add(Tools.formLayout(dischargeIdLabel, dischargeIdField, 35, 5, 10));
        panels.add(Tools.formLayout(admissionIdLabel, admissionIdField, 35, 5, 10));
        panels.add(Tools.formLayout(patientIdLabel, patientIdField, 35, 5, 10));
        panels.add(Tools.formLayout(firstNameLabel, firstNameField, 35, 5, 10));
        panels.add(Tools.formLayout(surnameLabel, surnameField, 35, 5, 10));
        panels.add(Tools.formLayout(admissionDateLabel, admissionDateField, 35, 5, 10));
        panels.add(Tools.formLayout(admissionTimeLabel, admissionTimeField, 35, 5, 10));
        panels.add(Tools.formLayout(dischargeDateLabel, dischargeDateField, 35, 5, 10));
        panels.add(Tools.formLayout(dischargeTimeLabel, dischargeTimeField, 35, 5, 10));
        panels.add(Tools.formLayout(additionalNotesLabel, additionalNotesField, 35, 5, 10));

        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
