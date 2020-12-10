import java.util.Random;
import java.util.ArrayList;
public class PasswordGenerator{

    public static ArrayList<ArrayList<Character>> validASCIIChars = new ArrayList<ArrayList<Character>>();
    public static Random rand = new Random();

    public PasswordGenerator(){
        char[] validSpecLets = {'!','@','#','$','%','&','-','+','?'};
        for(byte i = 0; i < 4;i++){
            validASCIIChars.add(new ArrayList<Character>());
        }
        for(byte i = (int) '0'; i<(((int)'9')+1);i++){
            validASCIIChars.get(0).add((char)i);
        }
        for(char let : validSpecLets){
            validASCIIChars.get(1).add(let);
        }
        for(byte i = (int)'A'; i < (((int)'Z')+1);i++){
            validASCIIChars.get(2).add((char)i);
        }
        for(byte i = (int)'a'; i < (((int)'z')+1);i++){
            validASCIIChars.get(2).add((char)i);
        }     
    }

    public String generatePassword(short length){
        String newPassword = "";
        for(short i = 0; i < length; i++){
            byte charTypeSelection = (byte) rand.nextInt(validASCIIChars.size());
            newPassword += validASCIIChars.get(charTypeSelection).get(rand.nextInt(validASCIIChars.get(charTypeSelection).size()));
        }
        return newPassword;
    }

    public String generatePassword(){
        byte length = (byte)(rand.nextInt(56)+8);
        String newPassword = "";
        for(short i = 0; i < length; i++){
            byte charTypeSelection = (byte) rand.nextInt(validASCIIChars.size());
            newPassword += validASCIIChars.get(charTypeSelection).get(rand.nextInt(validASCIIChars.get(charTypeSelection).size()));
        }
        return newPassword;
    }

    public void setNewSeed(long newSeed){
        rand.setSeed(newSeed);
    }
    public void setNewSeed(){
        rand.setSeed(rand.nextLong());
    }
}