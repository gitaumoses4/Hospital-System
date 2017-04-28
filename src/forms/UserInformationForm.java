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
public class UserInformationForm extends JPanel {

    public JLabel userIdLabel = new JLabel("Staff / User ID");
    public JLabel firstNameLabel = new JLabel("First Name");
    public JLabel lastnameLabel = new JLabel("Last Name");
    public JLabel emailLabel = new JLabel("Email");
    public JLabel designationLabel = new JLabel("Designation");

    public MTextField userIdField = new MTextField(15);
    public MTextField firstNameField = new MTextField(15);
    public MTextField lastNameField = new MTextField(15);
    public MTextField emailField = new MTextField(15);
    public JComboBox designationCombo = new JComboBox("Administrator,Inpatient Staff,Outpatient Staff,Cashier,Receptionist".split(","));

    public UserInformationForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Staff / User Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();

        panels.add(Tools.formLayout(userIdLabel, userIdField, 32, 5, 10));
        panels.add(Tools.formLayout(firstNameLabel, firstNameField, 32, 5, 10));
        panels.add(Tools.formLayout(lastnameLabel, lastNameField, 32, 5, 10));
        panels.add(Tools.formLayout(emailLabel, emailField, 32, 5, 10));
        panels.add(Tools.formLayout(designationLabel, designationCombo));

        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
