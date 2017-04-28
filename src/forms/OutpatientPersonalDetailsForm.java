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
public class OutpatientPersonalDetailsForm extends JPanel {

    public JLabel patientIdLabel = new JLabel("Patient's ID");
    public JLabel firstNameLabel = new JLabel("First Name");
    public JLabel surnameLabel = new JLabel("Surname");
    public JLabel accountTypeLabel = new JLabel("Account Type");

    public MTextField patientIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField surnameField = new MTextField(15);
    public MTextField accountTypeField = new MTextField(15);

    public OutpatientPersonalDetailsForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Personal Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(patientIdLabel, patientIdField, 40, 5, 10));
        panels.add(Tools.formLayout(firstNameLabel, firstNameField, 40, 5, 10));
        panels.add(Tools.formLayout(surnameLabel, surnameField, 40, 5, 10));
        panels.add(Tools.formLayout(accountTypeLabel, accountTypeField, 40, 5, 10));
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
