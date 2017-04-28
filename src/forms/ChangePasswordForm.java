package forms;

import hospitalsystem.Tools;
import hospitalsystem.custom.MPasswordField;
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
public class ChangePasswordForm extends JPanel {

    public JLabel usernameLabel = new JLabel("Username");
    public JLabel oldPasswordLabel = new JLabel("Old Password");
    public JLabel passwordLabel = new JLabel("New Password");
    public JLabel confirmPasswordLabel = new JLabel("Confirm Password");

    public MTextField usernameField = new MTextField(15);
    public MPasswordField oldPasswordField = new MPasswordField(15);
    public MPasswordField passwordField = new MPasswordField(15);
    public MPasswordField confirmPasswordField = new MPasswordField(15);

    public ChangePasswordForm() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Change Password", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        ArrayList<JPanel> panels = new ArrayList();
        panels.add(Tools.formLayout(usernameLabel, usernameField));
        panels.add(Tools.formLayout(oldPasswordLabel, oldPasswordField));
        panels.add(Tools.formLayout(passwordLabel, passwordField));
        panels.add(Tools.formLayout(confirmPasswordLabel, confirmPasswordField));

        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < panels.size(); i++) {
            int row = i;
            c.gridy = row;
            add(panels.get(i), c);
        }
    }
}
