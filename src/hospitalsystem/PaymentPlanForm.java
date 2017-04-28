package hospitalsystem;

import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class PaymentPlanForm extends JPanel {

    public JLabel chequeNumberLabel = new JLabel("Cheque Number");
    public JLabel cardNumberLabel = new JLabel("Card Number");
    public JLabel bankNameLabel = new JLabel("Bank Name");
    public JLabel totalReceivedLabel = new JLabel("Total Received");
    public JLabel balanceLabel = new JLabel("Balance");

    public MTextField chequeNumberField = new MTextField(15);
    public MTextField cardNumberField = new MTextField(15);
    public MTextField bankNameField = new MTextField(15);
    public MTextField totalReceivedField = new MTextField(15);
    public MTextField balanceField = new MTextField(15);

    public JRadioButton chequeButton = new JRadioButton("Cheque");
    public JRadioButton cashButton = new JRadioButton("Cash");
    public JRadioButton creditCardButton = new JRadioButton("Credit Card");

    public PaymentPlanForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Payment Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();

        JPanel top = new JPanel();
        top.setOpaque(false);
        ButtonGroup group = new ButtonGroup();
        group.add(chequeButton);
        group.add(cashButton);
        group.add(creditCardButton);

        top.add(chequeButton);
        top.add(cashButton);
        top.add(creditCardButton);

        panels.add(top);
        panels.add(Tools.formLayout(chequeNumberLabel, chequeNumberField));
        panels.add(Tools.formLayout(cardNumberLabel, cardNumberField));
        panels.add(Tools.formLayout(bankNameLabel, bankNameField));
        panels.add(Tools.formLayout(totalReceivedLabel, totalReceivedField));
        panels.add(Tools.formLayout(balanceLabel, balanceField));

        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
