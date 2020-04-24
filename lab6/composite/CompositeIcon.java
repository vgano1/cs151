package lab6;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class CompositeIcon implements Icon{
    private ArrayList <Icon> icons;
    private ArrayList <Point> iconLocations;
    private int height = 150;
    private int width = 150;
    
    public CompositeIcon() {
        icons = new ArrayList<Icon>();
        iconLocations = new ArrayList<Point>();
    }
    public void addIcon(Icon icon) {
        icons.add(icon);
        iconLocations.add(new Point());
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        {
            int i = 0;
            for (Icon s : icons)
            {
               Point offset = iconLocations.get(i++);
               s.paintIcon(c, g, x + offset.x, y + offset.y);
            }
         }
        
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
