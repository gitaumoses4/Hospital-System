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
public class RoomInformationForm extends JPanel {

    public JLabel roomIdLabel = new JLabel("Room ID");
    public JLabel roomNumberLabel = new JLabel("Room Number");
    public JLabel departmentIdLabel = new JLabel("Department ID");
    public JLabel departmentNameLabel = new JLabel("Department Name");
    public JLabel wardIdLabel = new JLabel("Ward ID");
    public JLabel wardNumberLabel = new JLabel("Ward Number");
    public JLabel roomCostLabel = new JLabel("Room Cost");
    public JLabel additionalNotesLabel = new JLabel("Additional Notes");

    public MTextField roomIdField = new MTextField(15);
    public MTextField roomNumberField = new MTextField(15);
    public MTextField departmentIdField = new MTextField(15);
    public MTextField departmentNameField = new MTextField(15);
    public MTextField wardIdField = new MTextField(15);
    public MTextField wardNumberField = new MTextField(15);
    public MTextField roomCostField = new MTextField(15);
    public MTextField additionalNotesField = new MTextField(15);

    public RoomInformationForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Room Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();

        panels.add(Tools.formLayout(roomIdLabel, roomIdField));
        panels.add(Tools.formLayout(roomNumberLabel, roomNumberField));
        panels.add(Tools.formLayout(departmentIdLabel, departmentIdField));
        panels.add(Tools.formLayout(departmentNameLabel, departmentNameField));
        panels.add(Tools.formLayout(wardIdLabel, wardIdField));
        panels.add(Tools.formLayout(wardNumberLabel, wardNumberField));
        panels.add(Tools.formLayout(roomCostLabel, roomCostField));
        panels.add(Tools.formLayout(additionalNotesLabel, additionalNotesField));

        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
