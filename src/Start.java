import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
public class Start extends JPanel {

    public Start() {
        Font font = new Font("Courier New", Font.BOLD, 30);
        JFrame frame = new JFrame();
        frame.setSize(800, 500);  // (window width, window height)
        frame.setTitle("Crossword Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        frame.add(panel);
        String[][] cwArr= new String[][]{
                {"C", "L", "I", "M", "B"},
                {"C", "O", "M", "E", "T"},
                {"S", "T", "A", "R", "S"},
                {"X", "U", "G", "G", "X"},
                {"X", "S", "E", "E", "X"}
        };
        for (String[] x : cwArr) {
            for (String y : x) {
                if (y.equals("X")) {
                    JTextField z = new JTextField(y);
                    z.setHorizontalAlignment(JTextField.CENTER);
                    z.setFont(font);
                    z.setBackground(Color.black);
                    z.setDocument(new JTextFieldLimit(0));
                    panel.add(z);
                } else {
                    JTextField b = new JTextField();
                    b.setHorizontalAlignment(JTextField.CENTER);
                    b.setFont(font);
                    b.setBackground(Color.white);
                    b.setDocument(new JTextFieldLimit(1));
                    panel.add(b);
                }
            }
        }
        frame.setVisible(true);
    }
}