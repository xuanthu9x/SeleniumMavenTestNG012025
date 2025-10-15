package PageFactory_Login;

import LoginTest.HandlePage.BassTest;
import LoginTest.HandlePage.HandleLoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BassTest {
    @Test
    public void LoginSuccess(){

        LoginPage login = new LoginPage(driver);
        login.LoginWithRememberMe("admin@example.com", "123456");
        login.verifyLoginSuccess();
    }

    @Test ()
    public void EmailEmpty(){
        LoginPage login = new LoginPage(driver);
        login.Login("", "123456");
        login.verifyEmailEmptyWarning();

    }

    @Test()
    public void PasswordEmpty(){
        LoginPage login = new LoginPage(driver);
        login.Login("admin@example.com", "");
        login.verifyPasswordEmptyWarning();
    }
    @Test ()
    public void EmailWrong(){
        LoginPage login = new LoginPage(driver);
        login.Login("admin1@exmample.com","123456");
        login.verifyEmailWrong();
    }

    @Test ()
    public void PassWrong(){
        LoginPage login = new LoginPage(driver);
        login.Login("admin@example.com", "abcdef");
        login.verifyPasswordWrong();
    }
    @Test ()
    public void emailFormatWrong(){
        LoginPage login = new LoginPage(driver);
        login.Login("abc", "123456");
        login.verifyEmailFormat();
    }
}
