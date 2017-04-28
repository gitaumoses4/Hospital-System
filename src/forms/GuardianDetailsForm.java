package forms;

import hospitalsystem.InpatientsManagementPanel;
import hospitalsystem.Tools;
import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class GuardianDetailsForm extends JPanel {

    public JLabel guardianIdLabel = new JLabel("Guardian Id");
    public JLabel patientIdLabel = new JLabel("Patient Id");
    public JLabel firstNameLabel = new JLabel("First name");
    public JLabel surNameLabel = new JLabel("Surname");
    public JLabel genderLabel = new JLabel("Gender");
    public JLabel addressLabel = new JLabel("Address");
    public JLabel phoneNumberLabel = new JLabel("Phone Number");
    public JLabel mobileNumberLabel = new JLabel("Mobile Number");
    public JLabel occupationLabel = new JLabel("Occupation");
    public JLabel relationshipToPatientLabel = new JLabel("Relationship to patient");
    public MTextField guardianIdField = new MTextField(15);
    public MTextField patientIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField surNameField = new MTextField(15);
    public JCheckBox maleCheck = new JCheckBox("Male");
    public JCheckBox femaleCheck = new JCheckBox("Female");
    public MTextField addressField = new MTextField(15);
    public MTextField phoneNumberField = new MTextField(15);
    public MTextField mobileNumberField = new MTextField(15);
    public MTextField occupationField = new MTextField(15);
    public MTextField relationshipToPatientField = new MTextField(15);

    public GuardianDetailsForm() {
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Guardian Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(guardianIdLabel, guardianIdField));
        panels.add(Tools.formLayout(patientIdLabel, patientIdField));
        panels.add(Tools.formLayout(firstNameLabel, firstNameField));
        panels.add(Tools.formLayout(surNameLabel, surNameField));
        JPanel gender = new JPanel();
        gender.setOpaque(false);
        gender.add(maleCheck);
        gender.add(femaleCheck);
        maleCheck.setOpaque(false);
        femaleCheck.setOpaque(false);
        ButtonGroup group = new ButtonGroup();
        group.add(maleCheck);
        group.add(femaleCheck);
        panels.add(Tools.formLayout(genderLabel, gender));
        panels.add(Tools.formLayout(addressLabel, addressField));
        panels.add(Tools.formLayout(phoneNumberLabel, phoneNumberField));
        panels.add(Tools.formLayout(mobileNumberLabel, mobileNumberField));
        panels.add(Tools.formLayout(occupationLabel, occupationField));
        panels.add(Tools.formLayout(relationshipToPatientLabel, relationshipToPatientField));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i % (panels.size() / 2);
            int col = i / (panels.size() / 2);
            c.gridx = col;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
