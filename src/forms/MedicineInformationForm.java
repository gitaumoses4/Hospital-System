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
public class MedicineInformationForm extends JPanel {

    public JLabel medicineIdLabel = new JLabel("Medicine ID");
    public JLabel medicineNameLabel = new JLabel("Medicine Name");
    public JLabel dosageFormLabel = new JLabel("Dosage Form");
    public JLabel unitPriceLabel = new JLabel("Unit Price");
    public JLabel unitsInStockLabel = new JLabel("Units in Stock");
    public JLabel reorderLevelLabel = new JLabel("Reorder Level");
    public JLabel additionalNotesLabel = new JLabel("Additional Notes");

    public MTextField medicineIdField = new MTextField(15);
    public MTextField medicineNameField = new MTextField(15);
    public JComboBox dosageFormCombo = new JComboBox("Injection Pills Syrup Balm Spray Cream".split(" "));
    public MTextField unitPriceField = new MTextField(15);
    public MTextField unitsInStockField = new MTextField(15);
    public MTextField reorderLevelField = new MTextField(15);
    public MTextField additionalNotesField = new MTextField(15);

    public MedicineInformationForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Medicine Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(medicineIdLabel, medicineIdField));
        panels.add(Tools.formLayout(medicineNameLabel, medicineNameField));
        panels.add(Tools.formLayout(dosageFormLabel, dosageFormCombo));
        panels.add(Tools.formLayout(unitPriceLabel, unitPriceField));
        panels.add(Tools.formLayout(unitsInStockLabel, unitsInStockField));
        panels.add(Tools.formLayout(reorderLevelLabel, reorderLevelField));
        panels.add(Tools.formLayout(additionalNotesLabel, additionalNotesField));
        
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}