import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;

public class Start extends JPanel {

    public Start() {
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
                    z.setBackground(Color.black);
                    panel.add(z);
                } else {
                    JTextField b = new JTextField();
                    b.setBackground(Color.white);
                    panel.add(b);

                }
            }
        }
        frame.setVisible(true);
    }
}