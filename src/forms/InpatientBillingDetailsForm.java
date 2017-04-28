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
public class InpatientBillingDetailsForm extends JPanel {

    public JLabel doctorChargesLabel = new JLabel("Doctor's Charges");
    public JLabel medicalTreatmentChargesLabel = new JLabel("Medical Treatment Charges");
    public JLabel serviceTreatmentChargesLabel = new JLabel("Service Treatment Charges");
    public JLabel roomChargesLabel = new JLabel("Room Charges");
    public JLabel hospitalChargesLabel = new JLabel("Hospital Charges");
    public JLabel totalLabel = new JLabel("Total");
    public JLabel vatLabel = new JLabel("VAT");
    public JLabel discountLabel = new JLabel("Discount");
    public JLabel netTotalLabel = new JLabel("Net Total");
    public MTextField doctorChargesField = new MTextField(15);
    public MTextField medicalTreatmentChargesField = new MTextField(15);
    public MTextField serviceTreatmentChargesField = new MTextField(15);
    public MTextField roomChargesField = new MTextField(15);
    public MTextField hospitalChargesField = new MTextField(15);
    public MTextField totalField = new MTextField(15);
    public MTextField vatField = new MTextField(15);
    public MTextField discountField = new MTextField(15);
    public MTextField netTotalField = new MTextField(15);

    public InpatientBillingDetailsForm() {
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Billing Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(5, 5, 5, 5))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(doctorChargesLabel, doctorChargesField, 40, 5, 10));
        panels.add(Tools.formLayout(medicalTreatmentChargesLabel, medicalTreatmentChargesField, 40, 5, 10));
        panels.add(Tools.formLayout(serviceTreatmentChargesLabel, serviceTreatmentChargesField, 40, 5, 10));
        panels.add(Tools.formLayout(roomChargesLabel, roomChargesField, 40, 5, 10));
        panels.add(Tools.formLayout(hospitalChargesLabel, hospitalChargesField, 40, 5, 10));
        panels.add(Tools.formLayout(totalLabel, totalField, 40, 5, 10));
        panels.add(Tools.formLayout(vatLabel, vatField, 40, 5, 10));
        panels.add(Tools.formLayout(discountLabel, discountField, 40, 5, 10));
        panels.add(Tools.formLayout(netTotalLabel, netTotalField, 40, 5, 10));
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
