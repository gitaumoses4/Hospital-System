package forms;

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
public class DoctorsPersonalDetailsForm extends JPanel {

    public JLabel doctorIdLabel = new JLabel("Doctor ID");
    public JLabel firstNameLabel = new JLabel("First Name");
    public JLabel surnameLabel = new JLabel("Surname");
    public JLabel genderLabel = new JLabel("Gender");
    public JLabel dateOfBirthLabel = new JLabel("Date of Birth");
    public JLabel addressLabel = new JLabel("Address");
    public JLabel phoneNumberLabel = new JLabel("Phone Number");
    public JLabel mobileNumberLabel = new JLabel("Mobile Number");
    public JLabel licenseNumberLabel = new JLabel("License Number");

    public MTextField doctorIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField surnameField = new MTextField(15);
    public JCheckBox maleCheck = new JCheckBox("Male");
    public JCheckBox femaleCheck = new JCheckBox("Female");
    public MTextField dateOfBirthField = new MTextField(15);
    public MTextField addressField = new MTextField(15);
    public MTextField phoneNumberField = new MTextField(15);
    public MTextField mobileNumberField = new MTextField(15);
    public MTextField licenseNumberField = new MTextField(15);

    public DoctorsPersonalDetailsForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Personal Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(doctorIdLabel, doctorIdField));
        panels.add(Tools.formLayout(firstNameLabel, firstNameField));
        panels.add(Tools.formLayout(surnameLabel, surnameField));
        JPanel gender = new JPanel();
        gender.add(maleCheck);
        gender.add(femaleCheck);
        ButtonGroup group = new ButtonGroup();
        group.add(maleCheck);
        group.add(femaleCheck);
        gender.setOpaque(false);
        maleCheck.setOpaque(false);
        femaleCheck.setOpaque(false);
        panels.add(Tools.formLayout(genderLabel, gender));
        panels.add(Tools.formLayout(dateOfBirthLabel, dateOfBirthField));
        panels.add(Tools.formLayout(addressLabel, addressField));
        panels.add(Tools.formLayout(phoneNumberLabel, phoneNumberField));
        panels.add(Tools.formLayout(mobileNumberLabel, mobileNumberField));
        panels.add(Tools.formLayout(licenseNumberLabel, licenseNumberField));
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
