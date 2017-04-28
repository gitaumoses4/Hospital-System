package hospitalsystem;

import forms.InpatientBillingDetailsForm;
import forms.InpatientAdmissionDetailsForm;
import hospitalsystem.OptionsPanel.Options;
import hospitalsystem.custom.MButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class InpatientBillingPanel extends ImageHeaderPanel {

    private InpatientBillingDetailsForm billingDetails;
    private InpatientAdmissionDetailsForm admissionDetails;
    private OptionsPanel options;
    private MButton paymentFormButton;
    private final MainWindow mainWindow;

    public InpatientBillingPanel(MainWindow mainWindow) {
        super("Overall Patient's Details Billing Module", 60);

        billingDetails = new InpatientBillingDetailsForm();
        admissionDetails = new InpatientAdmissionDetailsForm();
        options = new OptionsPanel(Options.SAVE, Options.CLOSE);

        paymentFormButton = new MButton("Go to Payments Form");

        JPanel optionsPanel = new JPanel();
        optionsPanel.setOpaque(false);
        optionsPanel.add(options);
        optionsPanel.add(paymentFormButton);

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 3;
        mainPanel.add(admissionDetails, c);
        c.gridx = 1;
        c.gridheight = 2;
        mainPanel.add(billingDetails, c);
        c.gridy = 2;
        c.gridheight = 1;
        mainPanel.add(optionsPanel, c);
        this.mainWindow = mainWindow;
    }

}
