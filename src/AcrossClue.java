import java.awt.*;

public class AcrossClue extends Clue {
    private String type;

    public AcrossClue(String word, String clue, int clueNum, Clue[] clueList, String type){
        super(word, clue, clueNum, clueList);
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return super.toString() + "It is a " + type + " clue.";
    }



}
