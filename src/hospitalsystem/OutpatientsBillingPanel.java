package hospitalsystem;

import forms.OutpatientBillingDetailsForm;
import forms.OutpatientPersonalDetailsForm;
import hospitalsystem.OptionsPanel.Options;
import hospitalsystem.custom.MButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class OutpatientsBillingPanel extends ImageHeaderPanel {

    private OutpatientPersonalDetailsForm personalDetails;
    private OutpatientBillingDetailsForm billingDetails;

    private OptionsPanel options;
    private MButton paymentFormButton;
    private final MainWindow mainWindow;

    public OutpatientsBillingPanel(MainWindow mainWindow) {
        super("Overall Patient's Details Billing Module", 60);

        personalDetails = new OutpatientPersonalDetailsForm();
        billingDetails = new OutpatientBillingDetailsForm();
        paymentFormButton = new MButton("Go to Payment Form");

        options = new OptionsPanel(Options.SAVE, Options.CLOSE);
        JPanel optionsPanel = new JPanel();
        optionsPanel.setOpaque(false);
        optionsPanel.add(options);
        optionsPanel.add(paymentFormButton);

        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        mainPanel.add(personalDetails, c);
        c.gridx = 1;
        mainPanel.add(billingDetails, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(30, 0, 0, 0);
        mainPanel.add(optionsPanel, c);
        this.mainWindow = mainWindow;
    }
}
