package forms;

import hospitalsystem.Tools;
import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DoctorsEmployeeDetailsForm extends JPanel {

    public JLabel doctorSpecializationLabel = new JLabel("Doctor's Specialization");
    public JLabel doctorCategoryLabel = new JLabel("Doctor's Category");
    public JLabel serviceChargesLabel = new JLabel("Service Charges (Per Day)");
    public JLabel channellingChargesLabel = new JLabel("Chanelling Charges");
    public JLabel appointmentDurationLabel = new JLabel("Appointment Duration(Minutes)");
    public JLabel referringChargesLabel = new JLabel("Referring Charges");

    public MTextField doctorSpecializationField = new MTextField(15);
    public JComboBox doctorCategoryCombo = new JComboBox(new String[]{"Permanent", "Visiting", "Referring"});
    public MTextField serviceChargesField = new MTextField(15);
    public MTextField channellingChargesField = new MTextField(15);
    public JComboBox appointmentDurationCombo = new JComboBox("10 15 20 25 30 25 40 25 50 55 60".split(" "));
    public MTextField referringChargesField = new MTextField(15);

    public DoctorsEmployeeDetailsForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Employee's Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();

        panels.add(Tools.formLayout(doctorSpecializationLabel, doctorSpecializationField));
        panels.add(Tools.formLayout(doctorCategoryLabel, doctorCategoryCombo));
        panels.add(Tools.formLayout(serviceChargesLabel, serviceChargesField));
        panels.add(Tools.formLayout(appointmentDurationLabel, appointmentDurationCombo));
        panels.add(Tools.formLayout(referringChargesLabel, referringChargesField));
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
