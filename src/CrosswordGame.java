import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Color;

public class CrosswordGame extends JPanel implements ActionListener {
    private String[][] cwArr;
    private ArrayList<JTextField> textFieldList = new ArrayList<JTextField>();
    private AcrossClue[] acrossClueList;
    private DownClue[] downClueList;
    private Letter[][] letterList;
    private SpringLayout panelLayout;
    private JButton selectedClue;
    private JButton revealWord;
    private JButton revealBoard;
    private JButton clearBoard;
    private JButton checkBoard;
    private JButton clearWord;

    private ArrayList<String> letterList2;
    private JButton checkWord;
    private Popup p;
    Color lightGreen = new Color(137, 240, 144);
    Color lightRed = new Color(219, 125, 125);
    Color lightBlue = new Color(125, 214, 219);
    //private String

    private boolean mousePressed = false;
    int clueNum = 0;

    public CrosswordGame() {
        acrossClueList = new AcrossClue[5];
        downClueList = new DownClue[5];
        letterList = new Letter[5][5];
        panelLayout = new SpringLayout();
        Font font = new Font("Courier New", Font.BOLD, 30);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        revealWord = new JButton("REVEAL WORD");
        revealWord.addActionListener(this);
        buttonPanel.add(revealWord);
        revealBoard = new JButton("REVEAL BOARD");
        revealBoard.addActionListener(this);
        buttonPanel.add(revealBoard);
        checkBoard = new JButton("CHECK BOARD");
        checkBoard.addActionListener(this);
        buttonPanel.add(checkBoard);
        clearWord = new JButton("CLEAR WORD");
        clearWord.addActionListener(this);
        buttonPanel.add(clearWord);
        clearBoard = new JButton("CLEAR BOARD");
        clearBoard.addActionListener(this);
        buttonPanel.add(clearBoard);

        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Crossword Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.PAGE_AXIS));
        frame.add(bigPanel);
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(5, 5));
        grid.setSize(800, 500);
        bigPanel.add(grid);
        bigPanel.add(buttonPanel);
        cwArr = new String[][]{
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
        JPanel clues = new JPanel();
        clues.setLayout(new BoxLayout(clues, BoxLayout.LINE_AXIS));
        clues.add(initializeClueButtons("across"));
        clues.add(initializeClueButtons("down"));
        bigPanel.add(clues);
        initializeLetters();
        frame.setVisible(true);
    }

    public ArrayList<JTextField> getTextFieldList() {
        return textFieldList;
    }

    public String[][] getCwArr() {
        return cwArr;
    }

    public AcrossClue[] getAcrossClueList() {
        return acrossClueList;
    }

    public DownClue[] getDownClueList() {
        return downClueList;
    }

    public Letter[][] getLetterList() {
        return letterList;
    }

    public JButton getSelectedClue() {
        return selectedClue;
    }

    public void initializeAcrossClues() {
        acrossClueList[0] = (new AcrossClue("climb", "Scale, as a rock wall", 1, acrossClueList, "across"));
        acrossClueList[1] = (new AcrossClue("comet", "Streaker in the night sky", 2, acrossClueList, "across"));
        acrossClueList[2] = (new AcrossClue("stars", "Twinklers in the night sky", 3, acrossClueList, "across"));
        acrossClueList[3] = (new AcrossClue("xuggx", "Popular brand of fur-lined boot", 4, acrossClueList, "across"));
        acrossClueList[4] = (new AcrossClue("xseex", "Witness", 5, acrossClueList, "across"));
    }

    public void initializeDownClues() {
        downClueList[0] = (new DownClue("CCS", "Loops in on a thread", 6, downClueList, "down"));
        downClueList[1] = (new DownClue("lotus", "Cross-legged meditation", 7, downClueList, "down"));
        downClueList[2] = (new DownClue("image", "Mirror _____", 8, downClueList, "down"));
        downClueList[3] = (new DownClue("merge", "Join together", 9, downClueList, "down"));
        downClueList[4] = (new DownClue("bts", "Best-selling group in Korean music history", 10, downClueList, "down"));
    }

    public JPanel initializeClueButtons(String type) {
        JPanel cluesGrid = new JPanel();
        cluesGrid.setLayout(new GridLayout(5, 1));
        Clue[] clueList;
        if (type.equals("across")) {
            initializeAcrossClues();
            clueList = acrossClueList;
        } else {
            initializeDownClues();
            clueList = downClueList;
        }
        for (int i = 0; i < 5; i++) {
            JButton y = new JButton(clueList[i].getClue());
            y.addActionListener(this);
            cluesGrid.add(y);
        }
        return cluesGrid;
    }

    public void initializeLetters() {
        letterList[0][0] = (new Letter("c"));
        letterList[0][1] = new Letter("l");
        letterList[0][2] = new Letter("i");
        letterList[0][3] = new Letter("m");
        letterList[0][4] = new Letter("b");
        letterList[1][0] = (new Letter("c"));
        letterList[1][1] = (new Letter("o"));
        letterList[1][2] = (new Letter("m"));
        letterList[1][3] = (new Letter("e"));
        letterList[1][4] = (new Letter("t"));
        letterList[2][0] = (new Letter("s"));
        letterList[2][1] = (new Letter("t"));
        letterList[2][2] = (new Letter("a"));
        letterList[2][3] = (new Letter("r"));
        letterList[2][4] = (new Letter("s"));
        letterList[3][0] = (new Letter("x"));
        letterList[3][1] = (new Letter("u"));
        letterList[3][2] = (new Letter("g"));
        letterList[3][3] = (new Letter("g"));
        letterList[3][4] = (new Letter("x"));
        letterList[4][0] = (new Letter("x"));
        letterList[4][1] = (new Letter("s"));
        letterList[4][2] = (new Letter("e"));
        letterList[4][3] = (new Letter("e"));
        letterList[4][4] = (new Letter("x"));
        ArrayList<JTextField> arr;
        int x = 0;
        for (int i = 0; i < letterList.length; i++) {
            for (int j = 0; j < letterList[0].length; j++) {
                letterList[i][j].setTextField(textFieldList.get(x));
                x++;
            }
        }
    }

    public void checkBoard() {
        int count = 0;
        int x = 0;
        boolean allCorrect = false;
        for (int i = 0; i < letterList.length; i++) {
            for (int j = 0; j < letterList[0].length; j++) {
                if (letterList[i][j].getTextField().getText().equals(letterList[i][j].getLetter())) {
                    letterList[i][j].getTextField().setBackground(lightGreen);
                    x++;
                    count++;
                } else {
                    letterList[i][j].getTextField().setBackground(lightRed);
                    x++;
                }
            }
        }
        textFieldList.get(15).setBackground(Color.BLACK);
        textFieldList.get(19).setBackground(Color.BLACK);
        textFieldList.get(20).setBackground(Color.BLACK);
        textFieldList.get(24).setBackground(Color.BLACK);
        if (allCorrect) {
            for (int i = 0; i < textFieldList.size(); i++) {
                textFieldList.get(i).setText("");
            }
            textFieldList.get(16).setText("Y");
            textFieldList.get(17).setText("O");
            textFieldList.get(18).setText("U");
            textFieldList.get(21).setText("W");
            textFieldList.get(22).setText("I");
            textFieldList.get(23).setText("N");
        }
    }

    public void clearBoard() {
        for (int i = 0; i < textFieldList.size(); i++) {
            textFieldList.get(i).setText("");
            textFieldList.get(i).setBackground(Color.WHITE);
        }
        textFieldList.get(15).setText("x");
        textFieldList.get(19).setText("x");
        textFieldList.get(20).setText("x");
        textFieldList.get(24).setText("x");
        textFieldList.get(15).setBackground(Color.BLACK);
        textFieldList.get(19).setBackground(Color.BLACK);
        textFieldList.get(20).setBackground(Color.BLACK);
        textFieldList.get(24).setBackground(Color.BLACK);

    }

    public void lightUpDown(int clueNum) {
        for (int i = 0; i < textFieldList.size(); i++) {
            textFieldList.get(i).setBackground(Color.WHITE);
        }
        textFieldList.get(15).setBackground(Color.BLACK);
        textFieldList.get(19).setBackground(Color.BLACK);
        textFieldList.get(20).setBackground(Color.BLACK);
        textFieldList.get(24).setBackground(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                letterList[i][clueNum - 6].getTextField().setBackground(lightBlue);
                textFieldList.get(15).setBackground(Color.BLACK);
                textFieldList.get(19).setBackground(Color.BLACK);
                textFieldList.get(20).setBackground(Color.BLACK);
                textFieldList.get(24).setBackground(Color.BLACK);
            }
        }
    }

    public void lightUpAcross(int clueNum) {
        for (int i = 0; i < textFieldList.size(); i++) {
            textFieldList.get(i).setBackground(Color.WHITE);
        }
        textFieldList.get(15).setBackground(Color.BLACK);
        textFieldList.get(19).setBackground(Color.BLACK);
        textFieldList.get(20).setBackground(Color.BLACK);
        textFieldList.get(24).setBackground(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            letterList[clueNum - 1][i].getTextField().setBackground(lightBlue);
            textFieldList.get(15).setBackground(Color.BLACK);
            textFieldList.get(19).setBackground(Color.BLACK);
            textFieldList.get(20).setBackground(Color.BLACK);
            textFieldList.get(24).setBackground(Color.BLACK);
        }
    }

    public void revealBoard() {
        int x = 0;
        for (int i = 0; i < letterList.length; i++) {
            for (int j = 0; j < letterList[0].length; j++) {
                letterList[i][j].getTextField().setText(letterList[i][j].getLetter());
                x++;
            }
        }
    }

    public void revealWord(int clueNum) {
        initializeAcrossClues();
        initializeDownClues();
        if (clueNum <= 5) {
            String[] word = acrossClueList[clueNum - 1].getWord().split("");
            for (int i = 0; i < 5; i++) {
                letterList[clueNum - 1][i].getTextField().setText(word[i]);
                textFieldList.get(15).setBackground(Color.BLACK);
                textFieldList.get(19).setBackground(Color.BLACK);
                textFieldList.get(20).setBackground(Color.BLACK);
                textFieldList.get(24).setBackground(Color.BLACK);
            }
        } else if (clueNum > 5) {
            String[] word = downClueList[clueNum - 6].getWord().split("");
            for (int i = 0; i < 5; i++) {
                letterList[i][clueNum - 6].getTextField().setText(word[i]);
                textFieldList.get(15).setBackground(Color.BLACK);
                textFieldList.get(19).setBackground(Color.BLACK);
                textFieldList.get(20).setBackground(Color.BLACK);
                textFieldList.get(24).setBackground(Color.BLACK);
            }
        }

    }

    public void clearWord(int clueNum) {
        if (clueNum <= 5) {
            for (int i = 0; i < 5; i++) {
                letterList[clueNum - 1][i].getTextField().setText("");
                textFieldList.get(15).setBackground(Color.BLACK);
                textFieldList.get(19).setBackground(Color.BLACK);
                textFieldList.get(20).setBackground(Color.BLACK);
                textFieldList.get(24).setBackground(Color.BLACK);
            }
        } else if (clueNum > 5) {
            for (int i = 0; i < 5; i++) {
                letterList[i][clueNum - 6].getTextField().setText("");
                textFieldList.get(15).setBackground(Color.BLACK);
                textFieldList.get(19).setBackground(Color.BLACK);
                textFieldList.get(20).setBackground(Color.BLACK);
                textFieldList.get(24).setBackground(Color.BLACK);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        if (button.getText().equals("Scale, as a rock wall")) {
            selectedClue = button;
            clueNum = 1;
            lightUpAcross(1);
        } else if (button.getText().equals("Streaker in the night sky")) {
            lightUpAcross(2);
            clueNum = 2;
            selectedClue = button;
        } else if (button.getText().equals("Twinklers in the night sky")) {
            lightUpAcross(3);
            clueNum = 3;
            selectedClue = button;
        } else if (button.getText().equals("Popular brand of fur-lined boot")) {
            lightUpAcross(4);
            clueNum = 4;
            selectedClue = button;
        } else if (button.getText().equals("Witness")) {
            lightUpAcross(5);
            clueNum = 5;
            selectedClue = button;
        } else if (button.getText().equals("Loops in on a thread")) {
            lightUpDown(6);
            clueNum = 6;
            selectedClue = button;
        } else if (button.getText().equals("Cross-legged meditation")) {
            lightUpDown(7);
            clueNum = 7;
            selectedClue = button;
        } else if (button.getText().equals("Mirror _____")) {
            lightUpDown(8);
            clueNum = 8;
            selectedClue = button;
        } else if (button.getText().equals("Join together")) {
            lightUpDown(9);
            clueNum = 9;
            selectedClue = button;
        } else if (button.getText().equals("Best-selling group in Korean music history")) {
            lightUpDown(10);
            clueNum = 10;
            selectedClue = button;
        } else if (button.getText().equals("REVEAL WORD")) {
            revealWord(clueNum);
        } else if (button.getText().equals("REVEAL BOARD")) {
            revealBoard();
        } else if (button.getText().equals("CHECK BOARD")) {
            checkBoard();
        } else if (button.getText().equals("CLEAR BOARD")) {
            clearBoard();
        } else if (button.getText().equals("CLEAR WORD")) {
            clearWord(clueNum);
        }
    }
}