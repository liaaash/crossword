import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Letter {
    private String letter;
    private JTextField textField;


    public Letter(String letter) {
        this.letter = letter;
        textField = null;
    }

    public void setTextField(JTextField field) {
        textField = field;
    }

    public String getLetter() {
        return letter;
    }


    public JTextField getTextField() {
        return textField;
    }

}
