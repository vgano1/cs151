package hw2;

import java.awt.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("deprecation")
public class TextView extends Box implements Observer {
    
    private DataModel model;
    private String value;
    private int a;
    
    public TextView(DataModel model) {
        super(BoxLayout.Y_AXIS);
        this.model = model;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(model.getDataSize() <= this.getComponentCount()) {
            for(Component c: this.getComponents()) {
                JTextField text = (JTextField) c;
                int x = text.getY();
                int y = text.getHeight();
                a = x/y;
                String s = text.getText();
                int textVal = Integer.parseInt(s);
                int dataVal = model.getData(a);
                if(textVal != dataVal) {
                    value = Integer.toString(dataVal);
                    text.setText(value);
                }
            }
        }
    }

}