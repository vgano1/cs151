package lab6;

import java.awt.*;

import javax.swing.Icon;

public class BoxedIcon implements Icon{
    private MarsIcon icon;
    
    public BoxedIcon(MarsIcon icon) {
        this.icon = icon;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.red);
        icon.paintIcon(c, g, 10, 10);
        g.drawRect(0, 0,icon.getIconWidth()+20, icon.getIconHeight()+20);
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth() +20;
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight()+20;
    }
    
}