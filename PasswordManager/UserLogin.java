import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class UserLogin{

    public static void main(String[] args) {
    
        String user = loginUName();
        System.out.println("Process done: "+ user);

    }

    public static String loginUName(){

        String userName = "";
        String passWord = "";


        Scanner s = new Scanner(System.in);

        System.out.println("\n\nWelcome To Your New Passwaord Manager!!\n\t\tPlease Log in(if a new user enter 'New' to Username and hit enter):\n");
        
        while(true){

            
            System.out.println("Username: ");
            userName = s.nextLine();
            
            if (userName.equals("New")){

                System.out.println("\nPlease create an account:\n");
                System.out.println("Username: ");
                userName = s.nextLine();
                System.out.println("Password: ");
                passWord = s.nextLine();

                //code to create file with username as title and and password as text
                FileReading.writeString(userName, passWord);
                FileReading.saveAndClose();
            }

            else{

                System.out.println("Password: ");
                passWord = s.nextLine();
                if (passWord.equals(FileReading.readString(userName))){
                    
                    break;
                }
                else{
                    System.out.println("Sorry wrong password or userneame! \n");
                }
                FileReading.saveAndClose();

        }

            
        }
        return userName;

        }

        
    



    public static void createAccountFile(String userName, String password)
        {    
            
        //This chunk of code creates the txt file with the name of the user (Reference: www.javatpoint.com)
        File file = new File(userName+".txt"); //initialize File object and passing path as argument  
        boolean result;  
        try   
        {  
        result = file.createNewFile();  //creates a new file  
        if(result)      // test if successfully created a new file  
        {  
        System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
        }  
        else  
        {  
        System.out.println("File already exist at location: "+file.getCanonicalPath());  
        }  
        }   
        catch (IOException e)   
        {  
        e.printStackTrace();    //prints exception if any  

        //This chunk of code writes the password to the the txt file
        FileReading.writeString(userName, password);
        FileReading.saveAndClose();

        }         
         

        
            
            
        }

}
