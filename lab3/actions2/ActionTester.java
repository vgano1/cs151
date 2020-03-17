package lab3v2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester
{
   static int a = 0;
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 20;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");

      helloButton.addActionListener(event ->
         textField.setText("Hello " + a));

      JButton goodbyeButton = new JButton("Say Goodbye");

      goodbyeButton.addActionListener(event ->
         textField.setText("Goodbye "+a));

      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);
      
      helloButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              a++;
              helloButton.setEnabled(false);
              goodbyeButton.setEnabled(true);
          }
      });
      
      
      goodbyeButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              goodbyeButton.setEnabled(false);
              helloButton.setEnabled(true);
          }
      });

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
