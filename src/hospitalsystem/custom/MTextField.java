package hospitalsystem.custom;

import hospitalsystem.Tools;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextField;

/**
 *
 * @author Moses Muigai Gitau
 */
public class MTextField extends JTextField {

    public MTextField(int cols) {
        super(cols);
        setProperties();
    }

    public MTextField() {
        setProperties();
    }

    private void setProperties() {
        this.setBorder(null);
        setFont(Tools.defaultFont.deriveFont(Font.ITALIC | Font.BOLD));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Tools.accent);
        g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
    }
}
