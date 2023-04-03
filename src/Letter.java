import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Letter {
    private String letter;
    private CrosswordGame cwGame;
    private JTextField textField;


    public Letter(String letter) {
        this.letter = letter;
        textField = null;
        cwGame = new CrosswordGame();
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
