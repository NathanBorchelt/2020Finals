import java.util.ArrayList;
public class PlayerBoard {
    private ArrayList<SWCharacter> playerBoard;
    private SWCharacter playerChoice;

    
    public void setPlayerChoice(byte index){
        this.playerChoice = this.playerBoard.get(index);
    }
    
    public void setPlayerChoice(int index){
        this.playerChoice = this.playerBoard.get(index);
    }

    public SWCharacter getPlayerChoice() {
        return playerChoice;
    }

    public void fillBoard(ArrayList<SWCharacter> swChars){
        this.playerBoard = swChars;
    }

    public SWCharacter returnChar(byte index){
        try{
            return playerBoard.get(index);
        }
        catch(Exception e){
            return null;
        }
    }
    public byte length(){
        return (byte) playerBoard.size();
    }

    public void invalidChar(byte index){
        playerBoard.remove(index);
    }

}
