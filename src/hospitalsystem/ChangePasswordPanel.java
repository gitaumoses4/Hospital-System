package hospitalsystem;

import forms.ChangePasswordForm;
import hospitalsystem.OptionsPanel.Options;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author Moses Muigai Gitau
 */
public class ChangePasswordPanel extends ImageHeaderPanel {

    private ChangePasswordForm changePasswordForm;
    private OptionsPanel options;
    private final MainWindow mainWindow;

    public ChangePasswordPanel(MainWindow mainWindow) {
        super("Change Password Module", 60);

        changePasswordForm = new ChangePasswordForm();
        options = new OptionsPanel(Options.SAVE, Options.CLOSE);

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        mainPanel.add(changePasswordForm, c);
        c.gridy = 1;
        mainPanel.add(options, c);
        this.mainWindow = mainWindow;
    }
}
