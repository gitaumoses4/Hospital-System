package hospitalsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Moses Muigai Gitau
 */
public class Tools {

    public static final Color accent = new Color(128, 0, 64);
    private static final DateFormat longFormat = new SimpleDateFormat("EEEEEE, MMMMMM dd, yyyy");
    private static final DateFormat shortFormat = new SimpleDateFormat("EEE dd-MMM-yyyy");
    private static final DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
    public static final int ICON_SIZE = 32;

    public static final Font defaultFont = new Font("Segoe UI", Font.PLAIN, 14);
    public static Font defaultBoldFont = new Font("Segoe UI", Font.PLAIN, 20);
    public static final Font headerFont = new Font("Segoe UI", Font.PLAIN, 30);

    public static String getLongDate(Calendar calendar) {
        return longFormat.format(calendar.getTime());
    }

    public static String getShortDate(Calendar calendar) {
        return shortFormat.format(calendar.getTime());
    }

    public static String getTime(Calendar calendar) {
        return timeFormat.format(calendar.getTime());
    }

    public static void error(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void error(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static String createStaffId(int number) {
        String prefix = "EMP";
        String suffix = String.valueOf(number);
        int i = suffix.length();
        while (i < 4) {
            suffix = "0" + suffix;
            i++;
        }
        return prefix + suffix;
    }

    public static ImageIcon getImageIcon(Object object, String location) {
        return new ImageIcon(object.getClass().getResource(location));
    }

    public static String[] getDays() {
        String days = "";
        for (int i = 1; i <= 31; i++) {
            days += i + "";
            if (i != 31) {
                days += " ";
            }
        }
        return days.split(" ");
    }

    public static String[] getMonths() {
        String months = "January February March April May June July August September October November December";
        return months.split(" ");
    }

    public static String[] getYears() {
        String years = "";
        for (int i = 1900; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
            if (i != 1900) {
                years += " ";
            }
            years += i + "";
        }
        return years.split(" ");
    }

    public static String[] getGenders() {
        return "Male Female".split(" ");
    }

    public static String[] getMaritalStatus() {
        return "Married Unmarried".split(" ");
    }

    public static String[] getAccountTypes() {
        return "Individual Corporate".split(" ");
    }

    public static JPanel formLayout(JComponent first, JComponent second, boolean fixed) {
        if (fixed) {
            return formLayout(first, second);
        }
        JPanel parent = new JPanel(new BorderLayout());
        parent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        parent.setOpaque(false);

        parent.add(first, BorderLayout.WEST);
        parent.add(second, BorderLayout.EAST);
        return parent;
    }

    public static JPanel formLayout(JComponent first, JComponent second) {
        JPanel parent = new JPanel(new BorderLayout());
        parent.setPreferredSize(new Dimension(400, 50));
        parent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        parent.setSize(parent.getPreferredSize());
        parent.setMinimumSize(parent.getPreferredSize());
        parent.setOpaque(false);

        parent.add(first, BorderLayout.WEST);
        parent.add(second, BorderLayout.EAST);
        return parent;
    }

    public static JPanel formLayout(JComponent first, JComponent second, int height, int verticalPadding, int horizontalPadding) {
        JPanel parent = new JPanel(new BorderLayout());
        parent.setPreferredSize(new Dimension(400, height));
        parent.setBorder(BorderFactory.createEmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
        parent.setSize(parent.getPreferredSize());
        parent.setMinimumSize(parent.getPreferredSize());
        parent.setOpaque(false);

        parent.add(first, BorderLayout.WEST);
        parent.add(second, BorderLayout.EAST);
        return parent;
    }
}
