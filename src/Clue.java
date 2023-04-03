public class Clue {
    private String clue;
    private Letter[] word;
    private int clueNum;
    public Clue(String clue, int clueNum) {
        this.clue = clue;
        this.clueNum = clueNum;
        word = null;
    }

    public String getClue() {
        return clue;
    }

    public int getClueNum() {
        return clueNum;
    }
    


}
