import java.util.ArrayList;

public class AcrossClue extends Clue{
    private CrosswordGame cwGame;
    private
    public AcrossClue(String clue, int clueNum) {
        super(clue, clueNum);
        cwGame = new CrosswordGame();
    }

    public ArrayList<Letter> getAnswerLetter(int clueNum) {
        ArrayList<Letter> letters = new ArrayList<Letter>();
        if (clueNum == 1) {
            for(int i = 0; i<5; i++) {
                letters.add(cwGame.getLetterList()[i]);
            }
        }else if(clueNum==2){
            for(int i = 5; i<10; i++){
                letters.add(cwGame.getLetterList()[i]);
            }
        }else if(clueNum==3){
            for(int i = 10; i<15; i++){
                letters.add(cwGame.getLetterList()[i]);
             }
        }else if(clueNum==4){
            for(int i = 15; i<20; i++){
                letters.add(cwGame.getLetterList()[i]);
            }
        }else if(clueNum==5){
            for(int i = 20; i<25; i++){
                letters.add(cwGame.getLetterList()[i]);
            }
        }
        for(int i = 0; i<letters.size(); i++){
            if(letters.get(i).getLetter().equals("X")){
                letters.remove(i);
            }
        }
        return letters;
    }

}
