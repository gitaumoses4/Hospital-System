package hospitalsystem;

import forms.UserAccountInformationForm;
import forms.UserInformationForm;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Moses Muigai Gitau
 */
public class UserAccountsPanel extends ImageHeaderPanel {

    private final MainWindow mainWindow;
    private UserInformationForm userInformation;
    private UserAccountInformationForm userAccountInformation;

    private JTable usersTable = new JTable();
    private OptionsPanel options;
    private NavigationPanel navigation;
    private CriteriaSearchPanel searchPanel;

    public UserAccountsPanel(MainWindow mainWindow) {
        super("Manage User Accounts", 60);
        this.mainWindow = mainWindow;

        searchPanel = new CriteriaSearchPanel("User Id,First name,Last name,Designation".split(","));
        userInformation = new UserInformationForm();
        userAccountInformation = new UserAccountInformationForm();
        options = new OptionsPanel();
        navigation = new NavigationPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 2;
        mainPanel.add(searchPanel, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 3;
        mainPanel.add(userInformation, c);
        c.gridy = 4;
        c.gridheight = 3;
        mainPanel.add(userAccountInformation, c);
        c.gridy=1;
        c.gridx = 1;
        c.gridheight = 3;
        JScrollPane scroll;
        mainPanel.add(scroll = new JScrollPane(usersTable), c);
        scroll.setPreferredSize(new Dimension(450, 300));
        c.gridy = 4;
        c.gridheight = 1;
        mainPanel.add(navigation, c);
        c.gridy = 5;
        mainPanel.add(options, c);
    }
}
