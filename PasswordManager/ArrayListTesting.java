import java.util.ArrayList;

public class ArrayListTesting{
    public static void main(String[] args) {
        /*
        ArrayList<String> catagory = new ArrayList<>();
        ArrayList<ArrayList<String>> passwordArrays = new ArrayList<>();

        passwordArrays.add(new ArrayList<String>());
        passwordArrays.add(new ArrayList<String>());
        passwordArrays.add(new ArrayList<String>());
        passwordArrays.add(new ArrayList<String>());

        catagory.add("String Test");
        passwordArrays.get(0).add("website");
        passwordArrays.get(0).add("username");
        passwordArrays.get(0).add("password");

        System.out.println(passwordArrays.toString());
        */
    
        ArrayList<ArrayList<ArrayList<String>>> passwordArrays = new ArrayList<>();

        passwordArrays.add(new ArrayList<ArrayList<String>>());
        passwordArrays.add(new ArrayList<ArrayList<String>>());
        passwordArrays.add(new ArrayList<ArrayList<String>>());
        passwordArrays.add(new ArrayList<ArrayList<String>>());
        //passwordArrays.get(0).add("Catagory");
        passwordArrays.get(0).add(new ArrayList<String>());
        passwordArrays.get(0).get(0).add("pass");
        passwordArrays.get(0).get(0).add("pass");
        passwordArrays.get(0).get(0).add("pass");
        System.out.println(passwordArrays.toString());
    }
}