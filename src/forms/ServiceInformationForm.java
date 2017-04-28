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
public class ServiceInformationForm extends JPanel {

    public JLabel serviceIdLabel = new JLabel("Service ID");
    public JLabel serviceNameLabel = new JLabel("Service Name");
    public JLabel amountOrRateLabel = new JLabel("Amount or Rate");
    public JLabel averageLengthOfStayLabel = new JLabel("Average Length Of Stay");
    public JLabel additionalNotesLabel = new JLabel("Additional Notes");

    public MTextField serviceIdField = new MTextField(15);
    public MTextField serviceNameField = new MTextField(15);
    public MTextField amountOrRateField = new MTextField(15);
    public MTextField averageLengthOfStayField = new MTextField(15);
    public MTextField additionalNotesField = new MTextField(15);

    public ServiceInformationForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Medicine Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(serviceIdLabel, serviceIdField));
        panels.add(Tools.formLayout(serviceNameLabel, serviceNameField));
        panels.add(Tools.formLayout(amountOrRateLabel, amountOrRateField));
        panels.add(Tools.formLayout(averageLengthOfStayLabel, averageLengthOfStayField));
        panels.add(Tools.formLayout(additionalNotesLabel, additionalNotesField));

        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
