import java.util.ArrayList;
public class PlayerBoard {
    /*
     * this is how each player gets their board with all their characters
     * using arrray list so that i do not have to add a "validity" atribute to ever character, thus making one less thing that i need to check
     * 
     * really, bytes are used for saving memory because it uses 8 bits(+/- 127) vs ints 32-bits, and considering this game should never take more than 255 characters, it should be fine.
    */
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
    // personal preferance to use length() vs size() eventhough it is ArrayList based
    public byte length(){
        return (byte) playerBoard.size();
    }

    public void invalidChar(byte index){
        playerBoard.remove(index);
    }

}
