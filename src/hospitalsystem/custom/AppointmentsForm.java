package hospitalsystem.custom;

import hospitalsystem.Tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class AppointmentsForm extends JPanel {

    public JLabel doctorIdLabel = new JLabel("Doctor ID");
    public JLabel specializationLabel = new JLabel("Specialization");
    public JLabel appointmentChargesLabel = new JLabel("Appointment Charges");
    public JLabel appointmentDurationLabel = new JLabel("Appointment Duration");
    public JLabel appointmentDayLabel = new JLabel("Appointment Day");
    public JLabel startTimeLabel = new JLabel("Start Time");
    public JLabel endTimeLabel = new JLabel("End Time");
    public JLabel dateLabel = new JLabel("Date");
    public JLabel appointmentStartTimeLabel = new JLabel("Appointment Start Time");
    public JLabel appointmentEndTimeLabel = new JLabel("Appointment End Time");
    public JLabel patientFirstNameLabel = new JLabel("Patient's First name");
    public JLabel patientsSurNameLabel = new JLabel("Patient's Surname");
    public JLabel contactNumberLabel = new JLabel("Contact Number");
    public JLabel tokenNumberLabel = new JLabel("Token Number");

    public MTextField doctorIdField = new MTextField(15);
    public MTextField specializationField = new MTextField(15);
    public MTextField appointmentChargesField = new MTextField(15);
    public MTextField appointmentDurationField = new MTextField(15);
    public MTextField appointmentDayField = new MTextField(15);
    public MTextField startTimeField = new MTextField(15);
    public MTextField endTimeField = new MTextField(15);
    public MTextField dateField = new MTextField(15);
    public MTextField appointmentStartTimeField = new MTextField(15);
    public MTextField appointmentEndTimeField = new MTextField(15);
    public MTextField patientsFirstNameField = new MTextField(15);
    public MTextField patientsSurNameField = new MTextField(15);
    public MTextField contactNumberField = new MTextField(15);
    public MTextField tokenNumberField = new MTextField(15);

    public JTable appointmentsTable;

    public AppointmentsForm() {
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Manage appointments", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(5, 5, 5, 5))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(doctorIdLabel, doctorIdField, 32, 5, 10));
        panels.add(Tools.formLayout(specializationLabel, specializationField, 32, 5, 10));
        panels.add(Tools.formLayout(appointmentChargesLabel, appointmentChargesField, 32, 5, 10));
        panels.add(Tools.formLayout(appointmentDurationLabel, appointmentDurationField, 32, 5, 10));
        panels.add(Tools.formLayout(appointmentDayLabel, appointmentDayField, 32, 5, 10));
        panels.add(Tools.formLayout(startTimeLabel, startTimeField, 32, 5, 10));
        panels.add(Tools.formLayout(endTimeLabel, endTimeField, 32, 5, 10));
        panels.add(Tools.formLayout(dateLabel, dateField, 32, 5, 10));
        panels.add(Tools.formLayout(appointmentStartTimeLabel, appointmentStartTimeField, 32, 5, 10));
        panels.add(Tools.formLayout(appointmentEndTimeLabel, appointmentEndTimeField, 32, 5, 10));
        panels.add(Tools.formLayout(patientFirstNameLabel, patientsFirstNameField, 32, 5, 10));
        panels.add(Tools.formLayout(patientsSurNameLabel, patientsSurNameField, 32, 5, 10));
        panels.add(Tools.formLayout(contactNumberLabel, contactNumberField, 32, 5, 10));
        panels.add(Tools.formLayout(tokenNumberLabel, tokenNumberField, 32, 5, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 10, 0, 10);
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }

        appointmentsTable = new JTable();
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = panels.size();
        add(new JScrollPane(appointmentsTable), c);
    }
}
