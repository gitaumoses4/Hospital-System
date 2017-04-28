package hospitalsystem;

import hospitalsystem.custom.ImageButton;
import hospitalsystem.custom.MButton;
import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class DoctorsScheduleMaintenancePanel extends ImageHeaderPanel {

    public JLabel doctorIdLabel = new JLabel("Doctor's ID");
    public MTextField doctorIdField = new MTextField(15);

    public MButton setUpChannellingTimesButton = new MButton("SET UP DOCTOR'S CHANNELLING TIMES");

    public ImageButton closeButton;

    public JTable scheduleTable = new JTable();
    private final MainWindow mainWindow;

    public DoctorsScheduleMaintenancePanel(MainWindow mainWindow) {
        super("Doctor's Schedule Maintenance", 60);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Doctor's Schedule Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(20, 20, 20, 20))));

        closeButton = new ImageButton(Tools.getImageIcon(this, "images/close.png"), "Close", ImageButton.BOTTOM, false);
        closeButton.setIconDimensions(Tools.ICON_SIZE, Tools.ICON_SIZE);
        this.mainWindow = mainWindow;

        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        mainPanel.add(Tools.formLayout(doctorIdLabel, doctorIdField), c);
        c.gridx = 1;
        mainPanel.add(setUpChannellingTimesButton, c);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 2;
        JScrollPane scroll;
        mainPanel.add(scroll = new JScrollPane(scheduleTable), c);
        scroll.setPreferredSize(new Dimension(getPreferredSize().width,300));
        c.insets=new Insets(30,0,0,0);
        c.gridy = 2;
        mainPanel.add(closeButton, c);
    }
}
