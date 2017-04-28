package hospitalsystem;

import hospitalsystem.Interfaces;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class MainWindow extends JFrame {

    private final ToolBar toolBar;
    private final NavigationBar navigationBar;
    private ContentPanel contentPanel = null;

    private final JPanel mainPanel;
    private final JMenuBar menuBar;

    private final Color borderColor = Color.GRAY;

    private final User user;

    private final JMenu inpatientsMenu = new JMenu("Inpatients");
    private final JMenu outpatientsMenu = new JMenu("Outpatients");
    private final JMenu channellingMenu = new JMenu("Channelling");
    private final JMenu paymentsMenu = new JMenu("Payments");
    private final JMenu maintenanceMenu = new JMenu("Maintenance");
    private final JMenu userAccountMenu = new JMenu("User Account");

    private final JMenu patientsAdmission = new JMenu("Patient Admission");
    private final JMenuItem stepOne = new JMenuItem("Step 1- Inpatients Maintenance");
    private final JMenuItem stepTwo = new JMenuItem("Step 2 - Guardians Maintenance");
    private final JMenuItem stepThree = new JMenuItem("Step 3 - Register / Admit Patient");

    private final JMenu treatments = new JMenu("Treatments");
    private final JMenu medicalTreatments = new JMenu("Medical Treatments");
    private final JMenuItem addMedicalTreatment = new JMenuItem("Add Medical Treatment");
    private final JMenuItem editMedicalTreatment = new JMenuItem("Edit Medical Treatment");
    private final JMenu serviceTreatments = new JMenu("Service Treatments");
    private final JMenuItem addServiceTreatment = new JMenuItem("Add Service Treatment");
    private final JMenuItem editServiceTreatment = new JMenuItem("Edit Service Treatment");

    private final JMenuItem viewOverallBill = new JMenuItem("View Overall Patients Bill");
    private final JMenuItem dischargePatient = new JMenuItem("Discharge Patient");

    private final JMenuItem outpatientsMaintenance = new JMenuItem("Outpatients Maintenance");
    private final JMenu outpatientsTreatments = new JMenu("Treatments");
    private final JMenu outpatientsMedicalTreatments = new JMenu("Medical Treatments");
    private final JMenuItem outpatientsAddMedicalTreatment = new JMenuItem("Add Medical Treatment");
    private final JMenuItem outpatientsEditMedicalTreatment = new JMenuItem("Edit Medical Treatment");
    private final JMenu outpatientsServiceTreatments = new JMenu("Service Treatments");
    private final JMenuItem outpatientsAddServiceTreatment = new JMenuItem("Add Service Treatment");
    private final JMenuItem outpatientsEditServiceTreatment = new JMenuItem("Edit Service Treatment");

    private final JMenuItem outpatientsViewOverallBill = new JMenuItem("View Overall Patients Bill");

    private final JMenuItem manageAppointments = new JMenuItem("Manage Appointments");
    private final JMenu inpatientsPayment = new JMenu("Inpatients");
    private final JMenu outpatientsPayment = new JMenu("Outpatients");

    private final JMenuItem inpatientManagePayment = new JMenuItem("Manage Patients Bill");
    private final JMenuItem outpatientManagePayment = new JMenuItem("Manage Patients Bill");

    private final JMenu doctorsMaintenanceMenu = new JMenu("Doctor's Maintenance");
    private final JMenuItem doctorsMaintenance = new JMenuItem("Doctor's Maintenance");
    private final JMenuItem doctorsScheduleMaintenance = new JMenuItem("Doctors Schedule Maintenance");
    private final JMenuItem medicineMaintenance = new JMenuItem("Medicine Maintenance");
    private final JMenuItem servicesMaintenance = new JMenuItem("Hospital Services Maintenance");
    private final JMenuItem departmentMaintenance = new JMenuItem("Departments Maintenance");
    private final JMenuItem wardMaintenance = new JMenuItem("Wards Maintenance");
    private final JMenuItem roomMaintenance = new JMenuItem("Rooms Maintenance");

    private final JMenuItem userAccountManagement = new JMenuItem("Manage User Accounts");
    private final JMenuItem changePassword = new JMenuItem("Change Password");
    private final JMenuItem logOut = new JMenuItem("Log Out");
    private final JMenuItem exit = new JMenuItem("Exit");

    public MainWindow(User user) {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 700));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.user = user;

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        mainPanel = new JPanel(new BorderLayout());
        toolBar = new ToolBar(this);
        toolBar.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        navigationBar = new NavigationBar(this);
        navigationBar.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        contentPanel = new ContentPanel(this);
        contentPanel.setBorder(BorderFactory.createLineBorder(borderColor, 1));

        mainPanel.add(navigationBar, BorderLayout.WEST);
        mainPanel.add(contentPanel);

        add(toolBar, BorderLayout.NORTH);
        add(mainPanel);
        init();
    }

    private void init() {
        setUpMenu();
    }

    private void setUpMenu() {
        menuBar.add(inpatientsMenu);
        inpatientsMenu.add(patientsAdmission);
        patientsAdmission.add(stepOne);
        stepOne.addActionListener(menuListener);
        patientsAdmission.add(stepTwo);
        stepTwo.addActionListener(menuListener);
        patientsAdmission.add(stepThree);
        stepThree.addActionListener(menuListener);
        inpatientsMenu.add(treatments);
        treatments.add(medicalTreatments);
        treatments.add(serviceTreatments);
        medicalTreatments.add(addMedicalTreatment);
        addMedicalTreatment.addActionListener(menuListener);
        medicalTreatments.add(editMedicalTreatment);
        editMedicalTreatment.addActionListener(menuListener);
        serviceTreatments.add(addServiceTreatment);
        addServiceTreatment.addActionListener(menuListener);
        serviceTreatments.add(editServiceTreatment);
        editServiceTreatment.addActionListener(menuListener);
        inpatientsMenu.add(viewOverallBill);
        viewOverallBill.addActionListener(menuListener);
        inpatientsMenu.add(dischargePatient);
        dischargePatient.addActionListener(menuListener);

        menuBar.add(outpatientsMenu);
        outpatientsMenu.add(outpatientsMaintenance);
        outpatientsMaintenance.addActionListener(menuListener);
        outpatientsMenu.add(outpatientsTreatments);
        outpatientsTreatments.add(outpatientsMedicalTreatments);
        outpatientsTreatments.add(outpatientsServiceTreatments);
        outpatientsMedicalTreatments.add(outpatientsAddMedicalTreatment);
        outpatientsAddMedicalTreatment.addActionListener(menuListener);
        outpatientsMedicalTreatments.add(outpatientsEditMedicalTreatment);
        outpatientsEditMedicalTreatment.addActionListener(menuListener);
        outpatientsServiceTreatments.add(outpatientsAddServiceTreatment);
        outpatientsAddServiceTreatment.addActionListener(menuListener);
        outpatientsServiceTreatments.add(outpatientsEditServiceTreatment);
        outpatientsEditServiceTreatment.addActionListener(menuListener);
        outpatientsMenu.add(outpatientsViewOverallBill);
        outpatientsViewOverallBill.addActionListener(menuListener);

        menuBar.add(channellingMenu);
        channellingMenu.add(manageAppointments);
        manageAppointments.addActionListener(menuListener);

        menuBar.add(paymentsMenu);
        paymentsMenu.add(inpatientsPayment);
        inpatientsPayment.add(inpatientManagePayment);
        inpatientManagePayment.addActionListener(menuListener);

        paymentsMenu.add(outpatientsPayment);
        outpatientsPayment.add(outpatientManagePayment);
        outpatientManagePayment.addActionListener(menuListener);

        menuBar.add(maintenanceMenu);
        maintenanceMenu.add(doctorsMaintenanceMenu);
        doctorsMaintenanceMenu.add(doctorsMaintenance);
        doctorsMaintenance.addActionListener(menuListener);
        doctorsMaintenanceMenu.add(doctorsScheduleMaintenance);
        doctorsScheduleMaintenance.addActionListener(menuListener);
        maintenanceMenu.add(medicineMaintenance);
        medicineMaintenance.addActionListener(menuListener);
        maintenanceMenu.add(servicesMaintenance);
        servicesMaintenance.addActionListener(menuListener);
        maintenanceMenu.add(departmentMaintenance);
        departmentMaintenance.addActionListener(menuListener);
        maintenanceMenu.add(wardMaintenance);
        wardMaintenance.addActionListener(menuListener);
        maintenanceMenu.add(roomMaintenance);
        roomMaintenance.addActionListener(menuListener);

        menuBar.add(userAccountMenu);
        userAccountMenu.add(userAccountManagement);
        userAccountManagement.addActionListener(menuListener);
        userAccountMenu.add(changePassword);
        changePassword.addActionListener(menuListener);
        userAccountMenu.add(logOut);
        logOut.addActionListener(menuListener);
        userAccountMenu.add(exit);
        exit.addActionListener(menuListener);
    }

    public static void main(String[] args) {
        MainWindow m = new MainWindow(
                new User("EMP0000",
                        "Moses",
                        "Muigai",
                        "gitaumoses4@gmail.com",
                        User.Type.ADMINISTRATOR.toString(),
                        "admin",
                        "admin"));
        m.setVisible(true);
    }

    public User getUser() {
        return this.user;
    }

    public void showLogIn() {
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
        dispose();
    }
    private ActionListener menuListener = (ActionEvent e) -> {
        Object o = e.getSource();
        Interfaces toShow = null;
        if (o == this.stepOne) {
            toShow = Interfaces.INPATIENTS_MANAGEMENT;
        } else if (o == this.stepTwo) {
            toShow = Interfaces.INPATIENTS_MANAGEMENT;
        } else if (o == this.stepThree) {
            toShow = Interfaces.INPATIENTS_MANAGEMENT;
        } else if (o == this.addMedicalTreatment) {
            toShow = Interfaces.MEDICAL_TREATMENTS;
        } else if (o == this.editMedicalTreatment) {
            toShow = Interfaces.EDIT_MEDICAL_TREATMENTS;
        } else if (o == this.addServiceTreatment) {
            toShow = Interfaces.SERVICE_TREATMENTS;
        } else if (o == this.editServiceTreatment) {
            toShow = Interfaces.EDIT_SERVICE_TREATMENTS;
        } else if (o == this.viewOverallBill) {
            toShow = Interfaces.INPATIENTS_BILLING;
        } else if (o == this.dischargePatient) {
            toShow = Interfaces.DISCHARGE_MANAGEMENT;
        } else if (o == this.outpatientsMaintenance) {
            toShow = Interfaces.INPATIENTS_MANAGEMENT;
        } else if (o == this.outpatientsAddMedicalTreatment) {
            toShow = Interfaces.MEDICAL_TREATMENTS;
        } else if (o == this.outpatientsEditMedicalTreatment) {
            toShow = Interfaces.EDIT_MEDICAL_TREATMENTS;
        } else if (o == this.outpatientsAddServiceTreatment) {
            toShow = Interfaces.SERVICE_TREATMENTS;
        } else if (o == this.outpatientsEditServiceTreatment) {
            toShow = Interfaces.EDIT_SERVICE_TREATMENTS;
        } else if (o == this.outpatientsViewOverallBill) {
            toShow = Interfaces.OUTPATIENTS_BILLING;
        } else if (o == this.manageAppointments) {
            toShow = Interfaces.APPOINTMENT_MANAGEMENT;
        } else if (o == this.inpatientManagePayment) {
            toShow = Interfaces.INPATIENTS_BILLING;
        } else if (o == this.outpatientManagePayment) {
            toShow = Interfaces.OUTPATIENTS_BILLING;
        } else if (o == this.doctorsMaintenance) {
            toShow = Interfaces.DOCTORS_MAINTENANCE;
        } else if (o == this.doctorsScheduleMaintenance) {
            toShow = Interfaces.DOCTORS_SCHEDULE_MAINTENANCE;
        } else if (o == this.medicineMaintenance) {
            toShow = Interfaces.MEDICINE_MAINTENANCE;
        } else if (o == this.servicesMaintenance) {
            toShow = Interfaces.HOSPITAL_SERVICES_MAINTENANCE;
        } else if (o == this.departmentMaintenance) {
            toShow = Interfaces.DEPARTMENT_MAINTENANCE;
        } else if (o == this.wardMaintenance) {
            toShow = Interfaces.WARD_MAINTENANCE;
        } else if (o == this.roomMaintenance) {
            toShow = Interfaces.ROOM_MAINTENANCE;
        } else if (o == this.userAccountManagement) {
            toShow = Interfaces.USER_ACCOUNTS;
        } else if (o == this.changePassword) {
            toShow = Interfaces.CHANGE_PASSWORD;
        }
        if (this.contentPanel != null) {
            contentPanel.show(toShow);
        }
    };

    public void show(Interfaces toShow) {
        contentPanel.show(toShow);
    }
}
