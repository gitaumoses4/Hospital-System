package forms;

import hospitalsystem.Tools;
import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class InpatientAdmissionDetailsForm extends JPanel {

    public JLabel admissionIdLabel = new JLabel("Admission ID");
    public JLabel patientIdLabel = new JLabel("Patient ID");
    public JLabel firstNameLabel = new JLabel("First name");
    public JLabel surnameLabel = new JLabel("Surname");
    public JLabel accountTypeLabel = new JLabel("Account Type");
    public JLabel assignedDoctorIdLabel = new JLabel("Assigned Doctor ID");
    public JLabel departmentIdLabel = new JLabel("Department ID");
    public JLabel departmentNameLabel = new JLabel("Department name");
    public JLabel wardNumberLabel = new JLabel("Ward No");
    public JLabel roomIdLabel = new JLabel("Room ID");
    public JLabel admissionDateLabel = new JLabel("Admission Date");
    public JLabel todaysDateLabel = new JLabel("Todays Date");
    public JLabel lengthOfStayLabel = new JLabel("Length of Stay(Days)");
    public MTextField admissionIdField = new MTextField(15);
    public MTextField patientIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField surnameField = new MTextField(15);
    public MTextField accountTypeField = new MTextField(15);
    public MTextField assignedDoctorIdField = new MTextField(15);
    public MTextField departmentIdField = new MTextField(15);
    public MTextField departmentNameField = new MTextField(15);
    public MTextField wardNumberField = new MTextField(15);
    public MTextField roomIdField = new MTextField(15);
    public MTextField admissionDateField = new MTextField(15);
    public MTextField todaysDateField = new MTextField(15);
    public MTextField lengthOfStayField = new MTextField(15);

    public InpatientAdmissionDetailsForm() {
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Admission Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(5, 5, 5, 5))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(admissionIdLabel, admissionIdField, 40, 5, 10));
        panels.add(Tools.formLayout(patientIdLabel, patientIdField, 40, 5, 10));
        panels.add(Tools.formLayout(firstNameLabel, firstNameField, 40, 5, 10));
        panels.add(Tools.formLayout(surnameLabel, surnameField, 40, 5, 10));
        panels.add(Tools.formLayout(accountTypeLabel, accountTypeField, 40, 5, 10));
        panels.add(Tools.formLayout(assignedDoctorIdLabel, assignedDoctorIdField, 40, 5, 10));
        panels.add(Tools.formLayout(departmentIdLabel, departmentIdField, 40, 5, 10));
        panels.add(Tools.formLayout(departmentNameLabel, departmentNameField, 40, 5, 10));
        panels.add(Tools.formLayout(wardNumberLabel, wardNumberField, 40, 5, 10));
        panels.add(Tools.formLayout(roomIdLabel, roomIdField, 40, 5, 10));
        panels.add(Tools.formLayout(admissionDateLabel, admissionDateField, 40, 5, 10));
        panels.add(Tools.formLayout(todaysDateLabel, todaysDateField, 40, 5, 10));
        panels.add(Tools.formLayout(lengthOfStayLabel, lengthOfStayField, 40, 5, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 10, 0, 10);
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
