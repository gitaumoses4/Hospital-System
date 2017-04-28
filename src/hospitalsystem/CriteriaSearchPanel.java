package hospitalsystem;

import hospitalsystem.custom.MTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Moses Muigai Gitau
 */
public class CriteriaSearchPanel extends JPanel {

    private JLabel criteriaLabel = new JLabel("Criteria");
    private JLabel searchForLabel = new JLabel("Search For");
    private JComboBox criteriaCombo;
    private MTextField searchForField = new MTextField(15);

    public CriteriaSearchPanel() {
        this(null);
    }

    public CriteriaSearchPanel(String[] criteria) {
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50), BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Search", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, Tools.defaultFont.deriveFont(Font.BOLD)), BorderFactory.createEmptyBorder(5, 5, 5, 5))));
        criteriaCombo = new JComboBox(criteria);
        add(Tools.formLayout(criteriaLabel, criteriaCombo, 30, 5, 10));
        add(Tools.formLayout(searchForLabel, searchForField, 30, 5, 10));
    }
}
