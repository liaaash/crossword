public class Clue {
    private String clue;
    private String word;
    private int clueNum;
    public Clue(String clue, int clueNum) {
        this.clue = clue;
        this.clueNum = clueNum;
        word = null;
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
