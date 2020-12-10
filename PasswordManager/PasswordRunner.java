import java.io.IOException;

public class PasswordRunner {
    public static void main(String[] args) throws IOException {
        PasswordManager.viewUserPasswords( UserLogin.loginUName()+".txt");
    }
}