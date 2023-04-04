public class Clue {

    private String clue;
    private String word;
    private int clueNum;
    private Clue[] clueList;

    public Clue(String word, String clue, int clueNum, Clue[] clueList) {
        this.clue = clue;
        this.clueNum = clueNum;
        this.word = word;
        this.clueList =  clueList;
    }

    public String getClue() {
        return clue;
    }
    public String getWord() { return word; }

    public int getClueNum() {
        return clueNum;
    }

    public String toString() {
        return ("The clue is: " + clue + " and is number: " + clueNum + ".");
    }
}
