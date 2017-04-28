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
public class MedicalTreatmentsForm extends JPanel {

    public JLabel patientIdLabel = new JLabel("Patient's ID");
    public JLabel firstNameLabel = new JLabel("First Name");
    public JLabel surnameLabel = new JLabel("Surname");
    public JLabel medicineIdLabel = new JLabel("Medicine ID");
    public JLabel medicineNameLabel = new JLabel("Medicine Name");
    public JLabel dateOfIssueLabel = new JLabel("Date of Issue");
    public JLabel unitPriceLabel = new JLabel("Unit Price");
    public JLabel quantityLabel = new JLabel("Quantity");
    public JLabel totalLabel = new JLabel("Total");

    public MTextField patientIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField surnameField = new MTextField(15);
    public MTextField medicineIdField = new MTextField(15);
    public MTextField medicineNameField = new MTextField(15);
    public MTextField dateOfIssueField = new MTextField(15);
    public MTextField unitPriceField = new MTextField(15);
    public MTextField quantityField = new MTextField(15);
    public MTextField totalField = new MTextField(15);

    public MedicalTreatmentsForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Personal Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(patientIdLabel, patientIdField, 40, 5, 10));
        panels.add(Tools.formLayout(firstNameLabel, firstNameField, 40, 5, 10));
        panels.add(Tools.formLayout(surnameLabel, surnameField, 40, 5, 10));
        panels.add(Tools.formLayout(medicineIdLabel, medicineIdField, 40, 5, 10));
        panels.add(Tools.formLayout(medicineNameLabel, medicineNameField, 40, 5, 10));
        panels.add(Tools.formLayout(dateOfIssueLabel, dateOfIssueField, 40, 5, 10));
        panels.add(Tools.formLayout(unitPriceLabel, unitPriceField, 40, 5, 10));
        panels.add(Tools.formLayout(quantityLabel, quantityField, 40, 5, 10));
        panels.add(Tools.formLayout(totalLabel, totalField, 40, 5, 10));
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
