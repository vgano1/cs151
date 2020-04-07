package lab5;

import java.awt.event.*;

import javax.swing.*;


public class Model{
    private JButton addButton;
    private JTextField textField;
    private JTextArea textArea;
    public Model() {
        JFrame f = new JFrame("Add Name");
        addButton = new JButton("add");
        addButton.setBounds(0,0,500,30);
        f.add(addButton);
        
        textField= new JTextField();
        textField.setBounds(0,155,500,28);
        f.add(textField);
        
        textArea = new JTextArea();
        textArea.setBounds(0,30,500,130);
        f.add(textArea); 
        textArea.setColumns(20); 
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(false); 
        f.setSize(500,220); 
        f.setLayout(null);
        f.setVisible(true);
        
        addButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Controller control = new Controller(textArea,textField);
            }
        });
    }
    
}
