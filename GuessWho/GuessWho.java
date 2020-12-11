import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//https://www.journaldev.com/709/java-read-file-line-by-line
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import java.util.Collections;

public class GuessWho{
    /*
     *Known issues 
     *  No AI, just ran out of time
     *  Uses number based input and does not let the oponent say if it is true or false
     * 
     * most variables are public static because it would be easier to call them almost everywhere then to keep passing in universal data
     */
    public static boolean checkingSide;
    public static boolean isDoesDoesNot = false;
    public static boolean isInteger = false;
    public static boolean gameOver = false;
    //there are about 30 atributes, so it should not need that large of number, thus another 3 bytes saved
    public static byte atributeType;
    public static boolean computer = false;
    //this is just because the game should not take more than 255 turns, so it saves 3 bytes
    public static byte playerTurn = -127;
    public static PlayerBoard p1Board = new PlayerBoard();
    public static PlayerBoard p2Board = new PlayerBoard();
    public static PlayerBoard opPlayerChars;
    public static PlayerBoard playerChars = new PlayerBoard();
    public static ArrayList<String> questionOptions = new ArrayList<String>();
    public static Scanner in = new Scanner(System.in);
    public static String selectionOption;
    public static String doesDoesNotHaveQuestion;
    public static String pauseForInput;
    //saver color inputs, just easier to keep the idea of numbers instead of changing it partway through
    public static String[] saberColors = {"1: No Lightsaber","2: Blue","3: Green","4: Red","5: Yellow","6: White","7: Purple","8: Green and Yellow"};
    //ABLE TO DO RANDOM *INTS* AND NOT HAVE TO DO MULTIPLICATION
    public static Random rand = new Random();
    public static void main(String[] args) {
        ArrayList<SWCharacter> avalibleChars = new ArrayList<SWCharacter>();
        ArrayList<Integer> randOptions = new ArrayList<Integer>();
        //it starts as an ArrayList before becomeing a PlayerBoard so i can shuffel so each player has different boards orders but the same characters
        ArrayList<SWCharacter> p1Initalization  = new ArrayList<SWCharacter>();
        ArrayList<SWCharacter> p2Initalization  = new ArrayList<SWCharacter>();
        String[] optionPrompStrings = {
            "Guess The Character",
            "Are they a jedi?",//2
            "Are they a droid?",
            "Are they a humanoid?",
            "Are they a wookie?",
            "Are they part of the Dark Side?",
            "Are they part of the Light Side?",
            "Are they a bounty hunter?",
            "Are they a smuggler?",
            "How many kessel speeds?",//10
            "Are they part of the empire?",
            "Are they a rebel?",
            "Are they part of the Resistance?",
            "Are they part of the First Order?",
            "Are they part of the Separatist?",
            "Are they part of the Galactic Republic?",
            "Are they a ewok?",
            "Are they fluffy?",
            "Are they slimey?",
            "What is their lightsaber color?",//20
            "Are they tall?",
            "Are they short?",
            "Are they a pilot?",
            "Are they annoying?",
            "Are they cute?",
            "Are they Banders Fav?",
            "Have they gotten their butt whooped?",
            "Have they been inside a tauntaun?",
            "Are they still living?",
            "Have they lost a limb?",
            "Are they a Space Balls character?"};
        questionOptions =  new ArrayList<String>(Arrays.asList(optionPrompStrings));
        //originally planed to have removable questions, decided to forgo that
        try{
            //https://www.journaldev.com/709/java-read-file-line-by-line
            BufferedReader allFile = new BufferedReader(new FileReader("SWData.txt"));
            String fileLine = allFile.readLine();
            while(fileLine != null){
                //System.out.println(fileLine);
                SWCharacter swchar = new SWCharacter(fileLine);
                avalibleChars.add(swchar);
                fileLine = allFile.readLine();
            }
            allFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        /*
        for(int i = 0; i < avalibleChars.size(); i++){
            System.out.println(avalibleChars.get(i).getName());
        }
        */
        int potCharIndex;
        //made so you get half the chacters to choose from. it is a while loop to garentee that you get 25 characters without duplicates
        while(randOptions.size()<(Math.round((avalibleChars.size()/2)))){
            potCharIndex = rand.nextInt(avalibleChars.size());
            if(!randOptions.contains(potCharIndex)){
                randOptions.add(potCharIndex);
            }
        }
        //both list start out the same before being shuffed to be different in order on line 115
        for(int i = 0; i < randOptions.size();i++){
            p1Initalization.add(avalibleChars.get(randOptions.get(i)));
            p2Initalization.add(avalibleChars.get(randOptions.get(i)));
        }
        Collections.shuffle(p2Initalization);
        /*
        for(int i = 0; i < p1Initalization.length; i++){
            System.out.println("Player 1: "+ p1Initalization[i]+"\nPlayer 2: "+p2Initalization[i]);
        }
        */
        p1Board.fillBoard(p1Initalization);
        p2Board.fillBoard(p2Initalization);
        playGame();
    }
    //"Stolen" from https://intellipaat.com/community/294/java-clear-the-console
    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    public static void playGame(){
        System.out.println("Welcome to the game of Guess Who : Star Wars Edition\nThe name of the game is simple, figure out the character the opponent has chosen before they find your's");
        System.out.println("The options are given and you will type the number associated with the command.");
        System.out.println("Hit <<Enter>> to start the game.");
        pauseForInput = in.nextLine();
        clrscr();
        System.out.println("Type \"PVP\" to play against a person\nType \"PVC\" to play against a computer");
        String pvpPvc = in.nextLine();
        String p1Confirm="";
        while (!p1Confirm.equalsIgnoreCase("yes")){
            System.out.println("Player 1: Pick your character by typing the number next to their name:");
            printChars(p1Board);
            byte p1ChoiceIndex = in.nextByte();
            System.out.println("Type \"Yes\" to confirm your selection");
            p1Confirm = in.nextLine();
            p1Confirm = in.nextLine();
            p1Board.setPlayerChoice(p1ChoiceIndex-1);
        }
        clrscr();
        String p2Confirm="";
        //PVC does not work, so this would just select a random char for player 2
        if(!pvpPvc.equalsIgnoreCase("pvc")){
            while (!p2Confirm.equalsIgnoreCase("yes")){
                System.out.println("Player 2: Pick your character by typing the number next to their name:");
                printChars(p2Board);
                byte p2ChoiceIndex = in.nextByte();
                System.out.println("Type \"Yes\" to confirm your selection");
                p2Confirm = in.nextLine();
                p2Confirm = in.nextLine();
                p2Board.setPlayerChoice(p2ChoiceIndex-1);
            }
        }
        else{
            p2Board.setPlayerChoice(rand.nextInt(p2Board.length()));
        }
        clrscr();
        while(!gameOver){
            playerTurn++;
            testCharacteristic();
        }
        System.out.println("Player "+ ((playerTurn%2 == 0)? "1":"2")+  " has won the game.");
    }
    public static void testCharacteristic(){
        // playerChars is the PlayerBoard of the person guessing
        if(playerTurn%2 == 0) {playerChars = p1Board; opPlayerChars = p2Board;}
        else                  {playerChars = p2Board; opPlayerChars = p1Board;}

        printChars(playerChars);//           |
        System.out.println();//              |
        //                                  \|/ quick way of saying p1 or p2
        System.out.println("Player "+ ((playerChars.equals(p1Board))? "1":"2")+  ": Make Your Choice");
        printOptions(questionOptions);
        //just makes sure you type in the number and not the question
        while(!isInteger){
            System.out.println("Type in the option number.");
            selectionOption = in.nextLine();
            try{
                atributeType = (byte)(Integer.valueOf(selectionOption)-1);
                if(atributeType <= questionOptions.size()){
                    isInteger = true;
                }
                } catch (Exception e){
                System.out.println("That is not a valid option");
            }
        }
        isInteger = false;
        //while not the best wording, this basically says the Ex: Yes I want to know if they ARE jedi, or No, I want to know that they are NOT jedi
        while(!isDoesDoesNot && (atributeType != 19 || atributeType != 9)){
            System.out.println("Type \"Are\" if they do have the atribute or \"Not\" if they do not.");
            doesDoesNotHaveQuestion = in.nextLine();
            if(doesDoesNotHaveQuestion.equalsIgnoreCase("are")){
                checkingSide = true;
                isDoesDoesNot = true;
            }
            else if(doesDoesNotHaveQuestion.equalsIgnoreCase("not")){
                checkingSide = false;
                isDoesDoesNot = true;
            }
        }
        isDoesDoesNot = false;

        // 10,20, and 1 are all that requre a little bit more than just a boolean check and need a second input
        if (atributeType != 10 || atributeType != 20 || atributeType != 1){
            for(byte index = 0; index < playerChars.length(); index++){
                //this if statment checks your question against their selected character to decide who to remove from the list
                if (opPlayerChars.getPlayerChoice().questionB(atributeType) == checkingSide){
                    if(checkingSide != playerChars.returnChar(index).questionB(index)){
                        playerChars.invalidChar(index);
                    }
                }
                else{
                    if(checkingSide != playerChars.returnChar(index).questionB(atributeType)){
                        playerChars.invalidChar(index);
                    }
                }
            }
        }
        else if(atributeType == 1){
            System.out.println("Type the number by the character's name:");
            for(byte index = 0; index < opPlayerChars.length();index++){
                System.out.println((index+1)+": "+opPlayerChars.returnChar(index));
            }
            byte callout = in.nextByte();
            if(opPlayerChars.returnChar(callout).equals(opPlayerChars.getPlayerChoice())){
                gameOver = true;
            }
        }
        else if(atributeType == 10){
            System.out.println("What rank is their Kessel Run");
            byte rank = in.nextByte();
            for(byte index = 0; index < playerChars.length(); index++){
                if (opPlayerChars.getPlayerChoice().questionI(atributeType) == rank){
                    if(rank != playerChars.returnChar(index).questionI(index)){
                        playerChars.invalidChar(index);
                    }
                }
            }
        }
        else if(atributeType == 20){
            System.out.println("Type the number related to their lightsaber color:");
            for(String saberOptions : saberColors){
                System.out.println(saberOptions);
            }
            byte saberColorChoice = in.nextByte();
            for(byte index = 0; index < playerChars.length(); index++){
                if (opPlayerChars.getPlayerChoice().questionI(atributeType) == saberColorChoice){
                    if(saberColorChoice != playerChars.returnChar(index).questionI(index)){
                        playerChars.invalidChar(index);
                    }
                }
            }
        }
        else{
            System.out.println("There has been an error in checking the input");
            //this is so bad input dows not pushing the player
            playerTurn--;
        }
    }
    public static void printOptions(ArrayList<String> avalibleOptions){
        for(byte i = 0; i < avalibleOptions.size();i++){
            System.out.println(String.valueOf(i+1)+". "+avalibleOptions.get(i));
        }
    }
    public static void printChars(PlayerBoard playerOptions){
        for(byte index = 0; index<playerOptions.length();index++){
            System.out.println((index+1)+": "+playerOptions.returnChar(index).getName());
        }
    }
}