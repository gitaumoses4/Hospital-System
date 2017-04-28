package hospitalsystem;

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
public class BillingDetailsForm extends JPanel {

    public JLabel invoiceIdLabel = new JLabel("Invoice ID");
    public JLabel billingDateLabel = new JLabel("Billing Date");
    public JLabel admissionIdLabel = new JLabel("Admission ID");
    public JLabel patientIdLabel = new JLabel("Patient ID");
    public JLabel patientNameLabel = new JLabel("Patient Name");
    public JLabel accountTypeLabel = new JLabel("Account Type");
    public JLabel totalCostLabel = new JLabel("Total Cost");
    public JLabel discountLabel = new JLabel("Discount");
    public JLabel totalPayableLabel = new JLabel("Total Payable");
    public JLabel totalPaidLabel = new JLabel("Total Paid so far");
    public JLabel balanceOwingLabel = new JLabel("Balance Owing");

    public MTextField invoiceIdField = new MTextField(15);
    public MTextField billingDateField = new MTextField(15);
    public MTextField admissionIdField = new MTextField(15);
    public MTextField patientIdField = new MTextField(15);
    public MTextField patientNameField = new MTextField(15);
    public MTextField accountTypeField = new MTextField(15);
    public MTextField totalCostField = new MTextField(15);
    public MTextField discountField = new MTextField(15);
    public MTextField totalPayableField = new MTextField(15);
    public MTextField totalPaidField = new MTextField(15);
    public MTextField balanceOwingField = new MTextField(15);

    public BillingDetailsForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Billing Details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();

        panels.add(Tools.formLayout(invoiceIdLabel, invoiceIdField));
        panels.add(Tools.formLayout(billingDateLabel, billingDateField));
        panels.add(Tools.formLayout(admissionIdLabel, admissionIdField));
        panels.add(Tools.formLayout(patientIdLabel, patientIdField));
        panels.add(Tools.formLayout(patientNameLabel, patientNameField));
        panels.add(Tools.formLayout(accountTypeLabel, accountTypeField));
        panels.add(Tools.formLayout(totalCostLabel, totalCostField));
        panels.add(Tools.formLayout(discountLabel, discountField));
        panels.add(Tools.formLayout(totalPayableLabel, totalPayableField));
        panels.add(Tools.formLayout(totalPaidLabel, totalPaidField));
        panels.add(Tools.formLayout(balanceOwingLabel, balanceOwingField));

        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
