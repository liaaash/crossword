import java.awt.*;

public class AcrossClue extends Clue {

    private String type;

    public AcrossClue(String word, String clue, int clueNum, String type){
        super(word, clue, clueNum);
        this.type=type;
    }

    public String toString() {
        return super.toString() + "It is a " + type + " clue.";
    }

}
