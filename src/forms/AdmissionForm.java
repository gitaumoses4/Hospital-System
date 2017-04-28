package forms;

import hospitalsystem.Tools;
import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class AdmissionForm extends JPanel {

    public JLabel admissionIdLabel = new JLabel("Admission ID");
    public JLabel patientIdLabel = new JLabel("Patient ID");
    public JLabel guardianIdLabel = new JLabel("Guardian ID");
    public JLabel admissionDateLabel = new JLabel("Admission Date");
    public JLabel admissionTimeLabel = new JLabel("Admission Time");
    public JLabel patientStatusLabel = new JLabel("Patient Status");
    public JLabel reasonsForStatusLabel = new JLabel("Reasons for Status");
    public JLabel referredDoctorIdLabel = new JLabel("Referred Doctor ID");
    public JLabel referredDoctorNameLabel = new JLabel("Referred Doctor Name");
    public JLabel assignedDoctorIdLabel = new JLabel("Assigned Doctor ID");
    public JLabel assignedDoctorNameLabel = new JLabel("Assigned Doctor Name");
    public JLabel departmentIdLabel = new JLabel("Department ID");
    public JLabel departmentNameLabel = new JLabel("Department Name");
    public JLabel wardIdLabel = new JLabel("Ward ID");
    public JLabel wardNumberLabel = new JLabel("Ward number");
    public JLabel roomNumberLabel = new JLabel("Room number");
    public JLabel additionalNotesLabel = new JLabel("Additional Notes");

    public MTextField admissionIdField = new MTextField(15);
    public MTextField patientIdField = new MTextField(15);
    public MTextField guardianIdField = new MTextField(15);
    public MTextField admissionDateField = new MTextField(15);
    public MTextField admissionTimeField = new MTextField(15);
    public MTextField patientStatusField = new MTextField(15);
    public MTextField reasonsForStatusField = new MTextField(15);
    public MTextField referredDoctorIdField = new MTextField(15);
    public MTextField referredDoctorNameField = new MTextField(15);
    public MTextField assignedDoctorIdField = new MTextField(15);
    public MTextField assignedDoctorNameField = new MTextField(15);
    public MTextField departmentIdField = new MTextField(15);
    public MTextField departmentNameField = new MTextField(15);
    public MTextField wardIdField = new MTextField(15);
    public MTextField wardNumberField = new MTextField(15);
    public MTextField roomNumberField = new MTextField(15);
    public MTextField additionalNotesField = new MTextField(15);

    public AdmissionForm() {
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Admission Details"), BorderFactory.createEmptyBorder(5, 5, 5, 5))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(admissionIdLabel, admissionIdField, 35, 0, 10));
        panels.add(Tools.formLayout(patientIdLabel, patientIdField, 35, 0, 10));
        panels.add(Tools.formLayout(guardianIdLabel, guardianIdField, 35, 0, 10));
        panels.add(Tools.formLayout(admissionDateLabel, admissionDateField, 35, 0, 10));
        panels.add(Tools.formLayout(admissionTimeLabel, admissionTimeField, 35, 0, 10));
        panels.add(Tools.formLayout(patientStatusLabel, patientStatusField, 35, 0, 10));
        panels.add(Tools.formLayout(reasonsForStatusLabel, reasonsForStatusField, 35, 0, 10));
        panels.add(Tools.formLayout(referredDoctorIdLabel, referredDoctorIdField, 35, 0, 10));
        panels.add(Tools.formLayout(referredDoctorNameLabel, referredDoctorNameField, 35, 0, 10));
        panels.add(Tools.formLayout(assignedDoctorIdLabel, assignedDoctorIdField, 35, 0, 10));
        panels.add(Tools.formLayout(assignedDoctorNameLabel, assignedDoctorNameField, 35, 0, 10));
        panels.add(Tools.formLayout(departmentIdLabel, departmentIdField, 35, 0, 10));
        panels.add(Tools.formLayout(departmentNameLabel, departmentNameField, 35, 0, 10));
        panels.add(Tools.formLayout(wardIdLabel, wardIdField, 35, 0, 10));
        panels.add(Tools.formLayout(wardNumberLabel, wardNumberField, 35, 0, 10));
        panels.add(Tools.formLayout(roomNumberLabel, roomNumberField, 35, 0, 10));
        panels.add(Tools.formLayout(additionalNotesLabel, additionalNotesField, 35, 0, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i % (int) Math.ceil(panels.size() / 2.0);
            int col = i / (int) Math.ceil(panels.size() / 2.0);
            c.gridx = col;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
