package hospitalsystem;

import forms.AdmissionForm;
import forms.GuardianDetailsForm;
import forms.PersonalDetailsForm;
import hospitalsystem.custom.AppointmentsForm;
import hospitalsystem.custom.MButton;
import hospitalsystem.custom.MTextField;
import hospitalsystem.custom.StepProgress;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class InpatientsManagementPanel extends ImageHeaderPanel {

    private final MainWindow mainWindow;
    private final BoxLayout layout;

    private final NavigationTop top;
    private final PersonalDetailsForm personalDetailsForm;
    private final GuardianDetailsForm guardianDetailsForm;
    private final AdmissionForm admissionForm;
    private final NavigationBottom bottom;

    public InpatientsManagementPanel(MainWindow mainWindow) {
        super("In-patients Maintenance Module", 60);
        this.mainWindow = mainWindow;

        layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        setOpaque(false);
        mainPanel.setLayout(layout);

        top = new NavigationTop();
        personalDetailsForm = new PersonalDetailsForm();
        guardianDetailsForm = new GuardianDetailsForm();
        admissionForm=new AdmissionForm();
        bottom = new NavigationBottom();

        mainPanel.add(top);
        mainPanel.add(personalDetailsForm);
        mainPanel.add(bottom);

        mainPanel.add(Box.createVerticalStrut(Integer.MAX_VALUE));
    }

    private class NavigationTop extends JPanel implements StepProgress.StepListener {

        private static final int NAVIGATION_HEIGHT = 100;

        private MButton launchInpatientSearch;
        private StepProgress progress;
        private JLabel information = new JLabel("Note All non-compulsory fields are marked with an asterisk (*)");

        private GridBagConstraints c = new GridBagConstraints();

        public NavigationTop() {
            setPreferredSize(new Dimension(getPreferredSize().width, NAVIGATION_HEIGHT));
            setOpaque(false);

            setLayout(new GridBagLayout());
            progress = new StepProgress(3, 300, 20);
            progress.addStepListener(this);

            information.setFont(Tools.defaultBoldFont);
            launchInpatientSearch = new MButton("Launch in-patient search wizard.");

            c.insets = new Insets(10, 0, 10, 0);
            add(information, c);
            c.gridy = 1;
            add(progress, c);
        }

        @Override
        public void stepChanged(int step) {
        }

    }

    private class NavigationBottom extends JPanel {

        private NavigationPanel panel;
        private OptionsPanel options;

        public NavigationBottom() {
            setOpaque(false);
            setLayout(new GridBagLayout());

            GridBagConstraints c = new GridBagConstraints();
            panel = new NavigationPanel();
            options = new OptionsPanel();

            add(panel, c);
            c.gridx = 1;
            add(options, c);
        }
    }

}
