
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.border.AbstractBorder;

public class CustomTopandBottom extends AbstractBorder {

    private Color color;

    public CustomTopandBottom(Color color) {
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawLine(x, y, x + width - 1, y); // top line
        g.drawLine(x, y + height - 1, x + width - 1, y + height - 1); // bottom line
    }
}
