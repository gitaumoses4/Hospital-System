package hospitalsystem;

import forms.DoctorsEmployeeDetailsForm;
import forms.DoctorsPersonalDetailsForm;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DoctorsMaintenancePanel extends ImageHeaderPanel {

    private DoctorsPersonalDetailsForm personalDetails;
    private DoctorsEmployeeDetailsForm employeeDetails;

    private OptionsPanel options;
    private NavigationPanel navigation;
    private final MainWindow mainWindow;

    public DoctorsMaintenancePanel(MainWindow mainWindow) {
        super("Doctor's Maintenance Module", 60);

        personalDetails = new DoctorsPersonalDetailsForm();
        employeeDetails = new DoctorsEmployeeDetailsForm();

        options = new OptionsPanel();
        navigation = new NavigationPanel();

        GridBagConstraints c = new GridBagConstraints();
        mainPanel.setLayout(new GridBagLayout());

        c.gridheight = 4;
        mainPanel.add(personalDetails, c);
        c.gridheight = 2;
        c.gridx = 1;
        mainPanel.add(employeeDetails, c);
        c.gridy = 2;
        c.gridheight = 1;
        mainPanel.add(navigation, c);
        c.gridy = 3;
        mainPanel.add(options, c);
        this.mainWindow = mainWindow;
    }
}
