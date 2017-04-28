package hospitalsystem;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class ContentPanel extends JPanel {

    private final MainWindow mainWindow;
    private final CardLayout cardLayout;

    private final DashBoard dashBoard;
    private final InpatientsManagementPanel inpatients;
    private final AppointmentManagementPanel appointments;
    private final InpatientBillingPanel inpatientBilling;
    private final OutpatientsBillingPanel outpatientBilling;
    private final SearchEngine searchEngine;
    private final MedicalTreatmentsPanel medicalTreatments;
    private final EditMedicalTreatmentsPanel editMedicalTreatment;
    private final ServiceTreatmentsPanel serviceTreatments;
    private final EditServiceTreatmentsPanel editServiceTreatment;
    private final DischargeManagementPanel dischargeManagement;
    private final DoctorsMaintenancePanel doctorsMaintenance;
    private final DoctorsScheduleMaintenancePanel doctorsScheduleMaintenance;
    private final MedicineMaintenancePanel medicineMaintenance;
    private final HospitalServicesMaintenancePanel servicesMaintenance;
    private final DepartmentsMaintenancePanel departmentMaintenance;
    private final WardMaintenancePanel wardMaintenance;
    private final RoomMaintenancePanel roomMaintenance;
    private final UserAccountsPanel userAccounts;
    private final ChangePasswordPanel changePassword;

    public ContentPanel(MainWindow mainWindow) {
        setBackground(Color.WHITE);
        this.mainWindow = mainWindow;
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        dashBoard = new DashBoard(mainWindow);

        inpatients = new InpatientsManagementPanel(mainWindow);

        appointments = new AppointmentManagementPanel(mainWindow);

        inpatientBilling = new InpatientBillingPanel(mainWindow);

        outpatientBilling = new OutpatientsBillingPanel(mainWindow);

        searchEngine = new SearchEngine(mainWindow);

        medicalTreatments = new MedicalTreatmentsPanel(mainWindow);

        editMedicalTreatment = new EditMedicalTreatmentsPanel(mainWindow);

        serviceTreatments = new ServiceTreatmentsPanel(mainWindow);

        editServiceTreatment = new EditServiceTreatmentsPanel(mainWindow);

        dischargeManagement = new DischargeManagementPanel(mainWindow);

        doctorsMaintenance = new DoctorsMaintenancePanel(mainWindow);

        doctorsScheduleMaintenance = new DoctorsScheduleMaintenancePanel(mainWindow);

        medicineMaintenance = new MedicineMaintenancePanel(mainWindow);

        servicesMaintenance = new HospitalServicesMaintenancePanel(mainWindow);

        departmentMaintenance = new DepartmentsMaintenancePanel(mainWindow);

        wardMaintenance = new WardMaintenancePanel(mainWindow);

        roomMaintenance = new RoomMaintenancePanel(mainWindow);

        userAccounts = new UserAccountsPanel(mainWindow);

        changePassword = new ChangePasswordPanel(mainWindow);

        add(dashBoard, Interfaces.DASHBOARD.toString());
        add(inpatients, Interfaces.INPATIENTS_MANAGEMENT.toString());
        add(appointments, Interfaces.APPOINTMENT_MANAGEMENT.toString());
        add(inpatientBilling, Interfaces.INPATIENTS_BILLING.toString());
        add(outpatientBilling, Interfaces.OUTPATIENTS_BILLING.toString());
        add(searchEngine, Interfaces.SEARCH_ENGINE.toString());
        add(medicalTreatments, Interfaces.MEDICAL_TREATMENTS.toString());
        add(editMedicalTreatment, Interfaces.EDIT_MEDICAL_TREATMENTS.toString());
        add(serviceTreatments, Interfaces.SERVICE_TREATMENTS.toString());
        add(editServiceTreatment, Interfaces.EDIT_SERVICE_TREATMENTS.toString());
        add(dischargeManagement, Interfaces.DISCHARGE_MANAGEMENT.toString());
        add(doctorsMaintenance, Interfaces.DOCTORS_MAINTENANCE.toString());
        add(doctorsScheduleMaintenance, Interfaces.DOCTORS_SCHEDULE_MAINTENANCE.toString());
        add(medicineMaintenance, Interfaces.MEDICINE_MAINTENANCE.toString());
        add(servicesMaintenance, Interfaces.HOSPITAL_SERVICES_MAINTENANCE.toString());
        add(departmentMaintenance, Interfaces.DEPARTMENT_MAINTENANCE.toString());
        add(wardMaintenance, Interfaces.WARD_MAINTENANCE.toString());
        add(roomMaintenance, Interfaces.ROOM_MAINTENANCE.toString());
        add(userAccounts, Interfaces.USER_ACCOUNTS.toString());
        add(changePassword, Interfaces.CHANGE_PASSWORD.toString());

        cardLayout.show(this, Interfaces.DASHBOARD.toString());
    }

    public void show(Interfaces interfaces) {
        cardLayout.show(this, interfaces.toString());
    }

}
