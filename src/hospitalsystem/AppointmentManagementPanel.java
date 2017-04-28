package hospitalsystem;

import hospitalsystem.OptionsPanel.Options;
import hospitalsystem.custom.AppointmentsForm;

/**
 *
 * @author Moses Muigai Gitau
 */
public class AppointmentManagementPanel extends ImageHeaderPanel {

    private AppointmentsForm appointments;
    private final MainWindow mainWindow;
    private final OptionsPanel options;

    public AppointmentManagementPanel(MainWindow mainWindow) {
        super("Maintain Channelling Appointments", 60);

        appointments = new AppointmentsForm();
        options = new OptionsPanel(Options.SAVE, Options.CLOSE);

        mainPanel.add(appointments);
        mainPanel.add(options);
        this.mainWindow = mainWindow;
    }
}
