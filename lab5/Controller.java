package lab5;

import javax.swing.*;

public class Controller{
    
    public Controller(JTextArea textArea, JTextField textField) {
        textArea.setText(textArea.getText()+textField.getText()+"\n");
        textField.setText("");
    }
}
