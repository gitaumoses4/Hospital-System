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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class PersonalDetailsForm extends JPanel {

    public JLabel patientIdLabel = new JLabel("Patient Id");
    public JLabel firstNameLabel = new JLabel("First name");
    public JLabel surNameLabel = new JLabel("Surname");
    public JLabel genderLabel = new JLabel("Gender");
    public JLabel dateOfBirthLabel = new JLabel("Date of Birth");
    public JLabel dayLabel = new JLabel("Day");
    public JLabel monthLabel = new JLabel("Month");
    public JLabel yearLabel = new JLabel("Year");
    public JLabel addressLabel = new JLabel("Address");
    public JLabel phoneNumberLabel = new JLabel("Phone No. (Home)");
    public JLabel mobileNumberLabel = new JLabel("* Mobile No. ");
    public JLabel patientOccupationLabel = new JLabel("Patient Occupation");
    public JLabel maritalStatusLabel = new JLabel("Marital Status");
    public JLabel accountTypeLabel = new JLabel("Account Type");
    public JLabel companyNameLabel = new JLabel("Company Name");
    public MTextField patientIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField surNameField = new MTextField(15);
    public JCheckBox maleCheck = new JCheckBox("Male");
    public JCheckBox femaleCheck = new JCheckBox("Female");
    public JComboBox dayCombo = new JComboBox(Tools.getDays());
    public JComboBox monthsCombo = new JComboBox(Tools.getMonths());
    public JComboBox yearsCombo = new JComboBox(Tools.getYears());
    public MTextField addressField = new MTextField(15);
    public MTextField phoneNumberField = new MTextField(15);
    public MTextField mobileNumberField = new MTextField(15);
    public MTextField patientOccupationField = new MTextField(15);
    public JCheckBox marriedCheck = new JCheckBox("Married");
    public JCheckBox unmarriedCheck = new JCheckBox("UnMarried");
    public JCheckBox individualCheck = new JCheckBox("Individual");
    public JCheckBox corporateCheck = new JCheckBox("Corporate");
    public MTextField companyNameField = new MTextField(15);

    public PersonalDetailsForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Personal Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
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
        JPanel birthDate = new JPanel();
        birthDate.setOpaque(false);
        birthDate.add(dayLabel);
        birthDate.add(dayCombo);
        birthDate.add(monthLabel);
        birthDate.add(monthsCombo);
        birthDate.add(yearLabel);
        birthDate.add(yearsCombo);
        panels.add(Tools.formLayout(dateOfBirthLabel, birthDate));
        panels.add(Tools.formLayout(addressLabel, addressField));
        panels.add(Tools.formLayout(phoneNumberLabel, phoneNumberField));
        panels.add(Tools.formLayout(mobileNumberLabel, mobileNumberField));
        panels.add(Tools.formLayout(patientOccupationLabel, patientOccupationField));
        JPanel marital = new JPanel();
        marital.setOpaque(false);
        marital.add(marriedCheck);
        marital.add(unmarriedCheck);
        marriedCheck.setOpaque(false);
        unmarriedCheck.setOpaque(false);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(marriedCheck);
        group2.add(unmarriedCheck);
        panels.add(Tools.formLayout(maritalStatusLabel, marital));
        JPanel account = new JPanel();
        account.setOpaque(false);
        account.add(individualCheck);
        account.add(corporateCheck);
        individualCheck.setOpaque(false);
        corporateCheck.setOpaque(false);
        ButtonGroup group3 = new ButtonGroup();
        group3.add(individualCheck);
        group3.add(corporateCheck);
        panels.add(Tools.formLayout(accountTypeLabel, account));
        panels.add(Tools.formLayout(companyNameLabel, companyNameField));
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i % 6;
            int col = i / 6;
            c.gridx = col;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }

    public void setFirstName(String name) {
        firstNameField.setText(name);
    }

    public void setPatientId(String id) {
        patientIdField.setText(id);
    }
}
