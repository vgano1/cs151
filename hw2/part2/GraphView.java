package hw2;

import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("deprecation")
public class GraphView extends JPanel implements Observer{
    
    private DataModel model;
    private static final int HEIGHT = 20;
    private ArrayList<Integer> values;
    private Integer a;
    
    public GraphView(DataModel model) {
        super();
        this.model = model;
        values = model.getDataList();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0; i<values.size(); i++) {
            Rectangle r = new Rectangle(0,i*20,values.get(i),HEIGHT);
            g2.draw(r);
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        a = values.size();
        this.repaint();
    }
    
    public ArrayList<Integer> getValues(){
        return values;
    }
    
    public int getHeight() {
        return HEIGHT;
    }
    
    public int getBoundary() {
        return ((a*HEIGHT)+HEIGHT)+60;
    }
}