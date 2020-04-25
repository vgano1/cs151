package hw2;

import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class Hw2P2 { 
    
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        String textVal;
        int value;
        
        
        BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
        DataModel model = new DataModel();
        TextView textView = new TextView(model);
        GraphView graphView = new GraphView(model);
        
        JFrame frame1 = new JFrame();
        JFrame frame2 = new JFrame();
        
        
        
        model.addObserver(textView);
        model.addObserver(graphView);
        
        while(br.ready()) {
            textVal = br.readLine();
            value = Integer.parseInt(textVal);
            model.addValue(value);
            JTextField text = new JTextField();
            text.setText(textVal);
            text.getDocument().addDocumentListener(new DocumentListener() {
                

                @Override
                public void insertUpdate(DocumentEvent e) {
                    try {
                        int x = text.getY();
                        int y = text.getHeight();
                        int i = x/y;
                        int val = 0;
                        if(e.getLength() == 0) {
                            val=0;
                            model.modifyValue(i,val);
                        }
                        else {
                            String stringVal = text.getText();
                            val = Integer.parseInt(stringVal);
                            model.modifyValue(i, val);
                        }
                    }
                    catch(IllegalStateException|ArithmeticException|NumberFormatException ex) {
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    try {
                        int x = text.getY();
                        int y = text.getHeight();
                        int i = x/y;
                        int val = 0;
                        if(e.getLength() == 1) {
                            val=0;
                            model.modifyValue(i,val);
                        }
                        else {
                            String stringVal = text.getText();
                            val = Integer.parseInt(stringVal);
                            model.modifyValue(i, val);
                        }
                    }
                    catch(IllegalStateException|ArithmeticException|NumberFormatException ex) {
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    try {
                        int x = text.getY();
                        int y = text.getHeight();
                        int i = x/y;
                        int val = 0;
                        String stringVal = text.getText();
                        val = Integer.parseInt(stringVal);
                        model.modifyValue(i, val);
                    }
                    catch(IllegalStateException|ArithmeticException|NumberFormatException ex) {
                        
                    }
                    
                }
                
            });
            textView.add(text);
        }
        br.close();
        
        graphView.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int val = e.getX();
                int x = e.getY();
                int y = graphView.getHeight();
                int i = x/y;
                model.modifyValue(i, val);
            }
        });
        
        frame1.setContentPane(textView);
        frame1.pack();
        frame1.setVisible(true);
        frame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ArrayList <Integer> dataValues;
                dataValues = model.getDataList();
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter(args[0]));
                    for(int i=0;i<dataValues.size();i++) {
                        writer.println(dataValues.get(i));
                    }
                    writer.close();
                }
                catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame2.setContentPane(graphView);
        frame2.setBounds(100,0,0,graphView.getBoundary());
        frame2.setVisible(true);
        frame2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ArrayList <Integer> dataValues;
                dataValues = model.getDataList();
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter(args[0]));
                    for(int i=0;i<dataValues.size();i++) {
                        writer.println(dataValues.get(i));
                    }
                    writer.close();
                }
                catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

