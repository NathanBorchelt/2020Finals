import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PasswordManager {
    
    public static PasswordGenerator passwordGenerator = new PasswordGenerator();

    public static ArrayList<String> userInformation = new ArrayList<>();
    public static ArrayList<String> userCatagories = new ArrayList<>();
    public static ArrayList<ArrayList<ArrayList<String>>> allpasswords= new ArrayList<>();

    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        viewUserPasswords("Borchelt.txt");
        //https://www.guru99.com/buffered-reader-in-java.html
        
    }

    public static void viewUserPasswords(String userName) throws IOException {

        String catagory;
        int catIndex;

        String catagoriesPrompt = "Type help for more commands, or type the command you want.";
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(new File(userName)));
            String contentLine = reader.readLine();
            while (contentLine != null) {
                userInformation.add(contentLine);
                contentLine = reader.readLine();
	   }

        } catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println(userInformation.toString());
        userCatagories = makeCatagories(userInformation.get(1).toString());
        //System.out.println(userCats.toString());
        allpasswords = divisionOfCatagories(userInformation.get(2));
        //System.out.println(allpasswords.toString());
        System.out.println(catagoriesPrompt);
        String initalInput = in.nextLine();
        initalInput.replaceAll("[\\n\\t ]", "");
        initalInput.toLowerCase();
        while (!initalInput.equalsIgnoreCase("quit")){
            clrscr();
            switch(initalInput){
                case "1":
                    showCatagories();
                    break;
                case "Catagories":
                    showCatagories();
                    break;
                case "2":
                    System.out.println("Type the catagory you want or \"help\" to list all the catagories");
                    catagory = in.nextLine();
                    catIndex = callCatagoryIndex(catagory);
                    if(catagory.equals("help")){
                        showCatagories();}
                    if (catIndex!=-1){
                        System.out.println("Type \"sites\" to know all avalible sites, or type the site name to see username and password");
                        String siteQuestion = in.nextLine();
                        if(siteQuestion.equalsIgnoreCase("sites")){
                            showSites(catagory);
                        }
                        else{
                            int siteIndex = getSubGroupIndex(catIndex, siteQuestion);
                            if (siteIndex!=-1){
                                ArrayList<String> passwordInformation = returnPassword(allpasswords, catagory, siteIndex);
                                System.out.println("The information of " + passwordInformation.get(0) + " is\nUsername:\t"+passwordInformation.get(1)+"\nPassword:\t"+passwordInformation.get(2));
                            }
                            else{System.out.println("That is not a valid site");}
                            break;
                        }
                    }
                    else{System.out.println("That is not a catagory");}
                    break;
                case "Password":
                    System.out.println("Type the catagory you want or \"help\" to list all the catagories");
                    catagory = in.nextLine();
                    catIndex = callCatagoryIndex(catagory);
                    if(catagory.equals("help")){
                        showCatagories();}
                    if (catIndex!=-1){
                        System.out.println("Type \"sites\" to know all avalible sites, or type the site name to see username and password");
                        String siteQuestion = in.nextLine();
                        if(siteQuestion.equalsIgnoreCase("sites")){
                            showSites(catagory);
                        }
                        else{
                            int siteIndex = getSubGroupIndex(catIndex, siteQuestion);
                            if (siteIndex!=-1){
                                ArrayList<String> passwordInformation = returnPassword(allpasswords, catagory, siteIndex);
                                System.out.println("The information of " + passwordInformation.get(0) + " is\nUsername:\t"+passwordInformation.get(1)+"\nPassword:\t"+passwordInformation.get(2));
                            }
                            else{System.out.println("That is not a valid site");}
                            break;
                        }
                    }
                    else{System.out.println("That is not a catagory");}
                    break;
                case "delete":
                    System.out.println("Type the catagory you want or \"help\" to list all the catagories");
                    catagory = in.nextLine();
                    catIndex = callCatagoryIndex(catagory);
                    if(catagory.equals("help")){
                        showCatagories();}
                    if (catIndex!=-1){
                        System.out.println("Type \"sites\" to know all avalible sites, or type the site name to see username and password");
                        String siteQuestion = in.nextLine();
                        if(siteQuestion.equalsIgnoreCase("sites")){
                            showSites(catagory);
                        }
                        else{
                            int siteIndex = getSubGroupIndex(catIndex, siteQuestion);
                            if (siteIndex!=-1){
                                allpasswords.get(catIndex).remove(siteIndex);
                            }
                            if(allpasswords.get(catIndex).size() == 0){
                                allpasswords.remove(catIndex);
                                userCatagories.remove(catIndex);
                            }
                        }
                    }
                    break;
                case "3":
                    System.out.println("Type the catagory you want or \"help\" to list all the catagories");
                    catagory = in.nextLine();
                    catIndex = callCatagoryIndex(catagory);
                    if(catagory.equals("help")){
                        showCatagories();}
                    if (catIndex!=-1){
                        System.out.println("Type \"sites\" to know all avalible sites, or type the site name to see username and password");
                        String siteQuestion = in.nextLine();
                        if(siteQuestion.equalsIgnoreCase("sites")){
                            showSites(catagory);
                        }
                        else{
                            int siteIndex = getSubGroupIndex(catIndex, siteQuestion);
                            if (siteIndex!=-1){
                                allpasswords.get(catIndex).remove(siteIndex);
                            }
                            if(allpasswords.get(catIndex).size() == 0){
                                allpasswords.remove(catIndex);
                                userCatagories.remove(catIndex);
                            }
                        }
                    }
                    break;
                    case "4":
                        System.out.println("What is the new catagory");
                        String newCat = in.nextLine();
                        if(callCatagoryIndex(newCat)==-1)
                            addCatagory(newCat);
                        else{
                            System.out.println("This catagory already exist");
                        }
                    case "5":
                        System.out.println("What catagory do you want to add a user information set");
                        String addUserSetCatName = in.nextLine();
                        int addUserSetCatIndex = callCatagoryIndex(addUserSetCatName);
                        if(addUserSetCatIndex != -1){
                            newUserInfo(addUserSetCatIndex);
                        }
                        else{
                            System.out.println("That is not a valid catagory");
                        }
                case "help":
                    System.out.println("Type:\n1:\tShow ALL Password Catagories\n2:\tShow a specific password\n3:\tDelete a password\n4:\tAdd a new catagory\n5:\tAdd a new user information set\nhelp:\tto see this menu");
                    break;

            }
            System.out.println(catagoriesPrompt);
            initalInput = in.nextLine();
        }
        File userFile = new File(userName);
        userFile.delete();
        FileReading.writeString(userName,userInformation.get(0));
        FileReading.writeString(userName,userCatagories.toString());
        FileReading.writeString(userName,allpasswords.toString());
        FileReading.saveAndClose();

    }

    public static ArrayList<String> returnPassword(ArrayList<ArrayList<ArrayList<String>>> allCatagoryOptions, String catagoryName, String siteName){
        ArrayList<String> siteUserPass = new ArrayList<>(); 
        int outIndex = callCatagoryIndex(catagoryName);
        int midIndex = getSubGroupIndex(catagoryName, siteName);
        if(midIndex != -1 && outIndex != -1){
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(0));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(1));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(2));
            return siteUserPass;
        }
        return new ArrayList<>(Arrays.asList("There is nothing under that search."));
    }

    public static ArrayList<String> returnPassword(ArrayList<ArrayList<ArrayList<String>>> allCatagoryOptions, int outIndex, int midIndex){
        ArrayList<String> siteUserPass = new ArrayList<>(); 
        //int outIndex = callCatagoryIndex(catagoryName);
        //int midIndex = getSubGroupIndex(catagoryName, siteName);
        if(midIndex != -1 && outIndex != -1){
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(0));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(1));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(2));
            return siteUserPass;
        }
        return new ArrayList<>(Arrays.asList("There is nothing under that search."));
    }

    public static ArrayList<String> returnPassword(ArrayList<ArrayList<ArrayList<String>>> allCatagoryOptions, String catagoryName, int midIndex){
        ArrayList<String> siteUserPass = new ArrayList<>(); 
        int outIndex = callCatagoryIndex(catagoryName);
        if(midIndex != -1 && outIndex != -1){
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(0));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(1));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(2));
            return siteUserPass;
        }
        return new ArrayList<>(Arrays.asList("There is nothing under that search."));
    }

    public static ArrayList<String> returnPassword(ArrayList<ArrayList<ArrayList<String>>> allCatagoryOptions, int outIndex, String siteName){
        ArrayList<String> siteUserPass = new ArrayList<>(); 
        //int outIndex = callCatagoryIndex(catagoryName);
        int midIndex = getSubGroupIndex(outIndex , siteName);
        if(midIndex != -1 && outIndex != -1){
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(0));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(1));
            siteUserPass.add(allCatagoryOptions.get(outIndex).get(midIndex).get(2));
            return siteUserPass;
        }
        return new ArrayList<>(Arrays.asList("There is nothing under that search."));
    }

    public static int callCatagoryIndex(String catagoryName){
        System.out.println(userCatagories.indexOf(catagoryName));
        return userCatagories.indexOf(catagoryName);
    }

    public static int getSubGroupIndex(String catName, String siteName){
        int outerMostCatagoryIndex = callCatagoryIndex(catName);
        for(byte i = 0; i < allpasswords.get(outerMostCatagoryIndex).size(); i++){
            if(allpasswords.get(outerMostCatagoryIndex).get(i).get(0).equals(siteName)){
                return i;
            }
        }
        return -1;
    }

    public static int getSubGroupIndex(int catIndex, String siteName){
        //int outerMostCatagoryIndex = callCatagoryIndex(catName);
        for(byte i = 0; i < allpasswords.get(catIndex).size(); i++){
            if(allpasswords.get(catIndex).get(i).get(0).equals(siteName)){
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<String> makeCatagories(String fileLine){
        //fileLine = fileLine.replaceAll("[", "");
        //fileLine = fileLine.replaceAll("]", "");
        //System.out.println(fileLine);
        String[] fileLineArray = fileLine.split(",");
        //System.out.println(Arrays.toString(fileLineArray));
        //System.out.println(fileLineArray[0]);
        for(byte i = 0; i < fileLineArray.length; i++){
            fileLineArray[i] = fileLineArray[i].replaceAll("\\[", "");
            fileLineArray[i] = fileLineArray[i].replaceAll("\\]", "");
        }
        ArrayList<String> returnArrayList = new ArrayList<>();
        for(String catString : fileLineArray){
            returnArrayList.add(catString);
        }
        //System.out.println(returnArrayList.toString());
        return returnArrayList;
    }
    public static ArrayList<ArrayList<ArrayList<String>>> divisionOfCatagories(String passwordInformation){
        //byte arrayListSplit;
        ArrayList<ArrayList<ArrayList<String>>> outputArrayArrayArrayList = new ArrayList<>();
        //following two lines clean up file intake
        passwordInformation = passwordInformation.replaceAll(" ", "");
        passwordInformation = passwordInformation.replaceAll("\\[", "");
        passwordInformation = passwordInformation.substring(0, passwordInformation.length()-1);
        //this splits it based off of the catagory, because all catagores end with a double right bracket
        List<String> passwordArrayStep1 = new ArrayList<>(Arrays.asList(passwordInformation.split("\\]\\]")));
        //this loop takes each catagory and turns them into each group of information
        for(byte index = 0; index < passwordArrayStep1.size(); index++){
            //the 2d arraylist here is used to make the catagory arraylist
            outputArrayArrayArrayList.add(new ArrayList<ArrayList<String>>());
            //arrayListSplit = (byte) passwordArrayStep1.indexOf(" ");
            //this ArrayList/List is the set of site,username, and password
            List<String> groupSplit = new ArrayList<>(Arrays.asList(passwordArrayStep1.get(index).split("\\]")));
            //this is what splits the user information
            for(byte layer2Index = 0; layer2Index<groupSplit.size();layer2Index++){
                outputArrayArrayArrayList.get(index).add(new ArrayList<>(Arrays.asList(groupSplit.get(layer2Index).split(","))));
                //this exsist to clean up, otherwise all but the first will have 4 items in the list
                if(outputArrayArrayArrayList.get(index).get(layer2Index).get(0).equals("")){
                    outputArrayArrayArrayList.get(index).get(layer2Index).remove(0);
                }
        }
        /* //TESTING Output
        for(byte i = 0; i < passwordArrayStep1.size();i++){
            System.out.println(passwordArrayStep1.get(i));
        }
        */
        }   
        return outputArrayArrayArrayList;
    }
    public static void showCatagories(){
        //attempting to try to allow both string input and number input
        for(byte catagoryIndex = 0; catagoryIndex < userCatagories.size(); catagoryIndex++){
            System.out.println(String.valueOf(catagoryIndex+1) + "\t" + userCatagories.get(catagoryIndex));
        }
    }

    //https://intellipaat.com/community/294/java-clear-the-console
    public static void clrscr(){
        //Clears Screen in jav
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public static void showSites(String catagory){
        int catIndex = callCatagoryIndex(catagory);
        System.out.println("Here are all the sites under the" + catagory);
        for(byte i = 0; i < allpasswords.get(catIndex).size(); i++){
            System.out.println(String.valueOf(i+1) +" "+ allpasswords.get(catIndex).get(i).get(0));
        }
    }

    public static void addCatagory(String catName){
        userCatagories.add(catName);
        allpasswords.add(new ArrayList<ArrayList<String>>());
    }
    public static void newUserInfo(int catagoryIndex){
        System.out.println("What site is this info for:");
        String newSite = in.nextLine();
        newSite.replaceAll(" ", "");
        System.out.println("What is the username for "+ newSite);
        String newUserNameForNewSite = in.nextLine();
        newUserNameForNewSite.replaceAll(" ", "");
        System.out.println("What is the password for " + newUserNameForNewSite);
        String newPasswordforNewUsernameForNewSite = in.nextLine();
        newPasswordforNewUsernameForNewSite.replaceAll(" ", "");
        allpasswords.get(catagoryIndex).add(new ArrayList<String>());
        allpasswords.get(catagoryIndex).get(allpasswords.get(catagoryIndex).size()-1).add(newSite);
        allpasswords.get(catagoryIndex).get(allpasswords.get(catagoryIndex).size()-1).add(newUserNameForNewSite);
        allpasswords.get(catagoryIndex).get(allpasswords.get(catagoryIndex).size()-1).add(newPasswordforNewUsernameForNewSite);

    }

}