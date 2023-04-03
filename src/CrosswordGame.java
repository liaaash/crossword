import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CrosswordGame extends JPanel {
    private String[][] cwArr;
    private ArrayList<JTextField> textFieldList = new ArrayList<JTextField>();
    private Clue[] clueList;
    private Letter[] letterList;

    public CrosswordGame() {
        clueList = new Clue[10];
        letterList = new Letter[25];
        Font font = new Font("Courier New", Font.BOLD, 30);
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Crossword Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(2,1));
        frame.add(bigPanel);
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(5, 5));
        grid.setSize(800, 500);
        bigPanel.add(grid);
        cwArr= new String[][]{
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
                    grid.add(z);
                    textFieldList.add(z);
                } else {
                    JTextField b = new JTextField();
                    b.setHorizontalAlignment(JTextField.CENTER);
                    b.setFont(font);
                    b.setBackground(Color.white);
                    b.setDocument(new JTextFieldLimit(1));
                    grid.add(b);
                    textFieldList.add(b);
                }
            }
        }
        JPanel cluePanel = new JPanel();
        initializeAcrossClues();
        initializeVerticalClues();
        for (int i = 0; i < clueList.length; i++) {
            JLabel y = new JLabel(clueList[i].getClueNum() + ". " + clueList[i].getClue());
            cluePanel.add(y);
        }
        bigPanel.add(cluePanel);
        frame.setVisible(true);
    }

    public ArrayList<JTextField> getTextFieldList() {
        return textFieldList;
    }
    public String[][] getCwArr() {
        return cwArr;
    }

    public void initializeAcrossClues() {
        clueList[0] = (new Clue("Scale, as a rock wall", 1));
        clueList[1] = (new Clue("Streaker in the night sky", 6));
        clueList[2] = (new Clue("Twinklers in the night sky", 7));
        clueList[3] = (new Clue("Popular brand of fur-lined boot", 8));
        clueList[4] = (new Clue("Witness", 9));
    }

    public void initializeVerticalClues(){
        clueList[5] = (new Clue("Loops in on a thread", 1));
        clueList[6] = (new Clue("Cross-legged meditation", 2));
        clueList[7] = (new Clue("Mirror _____", 3));
        clueList[8] = (new Clue("Join together", 4));
        clueList[9] = (new Clue("Best-selling group in Korean music history", 5));
    }

    public void initializeLetters() {
        letterList[0] = (new Letter("c"));
        letterList[1] = new Letter("l");
        letterList[2] = new Letter("i");
        letterList[3] = new Letter("m");
        letterList[4] = new Letter("b");
        letterList[5] = (new Letter("c"));
        letterList[6] = (new Letter("o"));
        letterList[7] = (new Letter("m"));
        letterList[8] = (new Letter("e"));
        letterList[9] = (new Letter("t"));
        letterList[10] = (new Letter("s"));
        letterList[11] = (new Letter("t"));
        letterList[12] = (new Letter("a"));
        letterList[13] = (new Letter("r"));
        letterList[14] = (new Letter("s"));
        letterList[15] = (new Letter("x"));
        letterList[16] = (new Letter("u"));
        letterList[17] = (new Letter("g"));
        letterList[18] = (new Letter("g"));
        letterList[19] = (new Letter("x"));
        letterList[20] = (new Letter("x"));
        letterList[21] = (new Letter("s"));
        letterList[22] =(new Letter("e"));
        letterList[23] = (new Letter("e"));
        letterList[24] = (new Letter("x"));
        ArrayList<JTextField> arr;
        for (int i = 0; i < letterList.length; i ++) {
            letterList[i].setTextField(textFieldList.get(i));
        }
    }

    public void checkBoard() {
        int count = 0;
        for (int i = 0; i<letterList.length; i++) {
            if(letterList[i].getTextField().getText().equals(letterList[i].getLetter())){
                letterList[i].getTextField().setBackground(Color.GREEN);
                count++;
            } else {
                letterList[i].getTextField().setBackground(Color.RED);
            }
        }
        if (count == 25) {
            JFrame frame = new JFrame();
            frame.setSize(500, 500);  // (window width, window height)
            frame.setTitle("Crossword Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            frame.add(panel);
            JTextArea x = new JTextArea();
            x.setText("You win! CONGRATS!");
            panel.add(x);
        }
    }

    public void clearBoard() {
        for (JTextField x : textFieldList) {
            x.setText("");
        }
    }


}