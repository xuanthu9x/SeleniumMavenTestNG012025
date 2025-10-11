package LoginTest.TestCase;

import LoginTest.HandlePage.BassTest;
import LoginTest.HandlePage.HandleLoginPage;
import org.testng.annotations.Test;

public class LoginTC extends BassTest {

    @Test
    public void LoginSuccess(){

        HandleLoginPage login = new HandleLoginPage(driver);
        HandleLoginPage.LoginWithRememberMe("admin@example.com", "123456");

        HandleLoginPage.verifyLoginSuccess();
    }

    @Test ()
    public void EmailEmpty(){
        HandleLoginPage login = new HandleLoginPage(driver);
        HandleLoginPage.Login("", "123456");
        HandleLoginPage.verifyEmailEmptyWarning();

    }

    @Test()
    public void PasswordEmpty(){
          HandleLoginPage login = new HandleLoginPage(driver);
          HandleLoginPage.Login("admin@example.com", "");
          HandleLoginPage.verifyPasswordEmptyWarning();
    }
    @Test ()
    public void EmailWrong(){
        HandleLoginPage login = new HandleLoginPage(driver);
        HandleLoginPage.Login("admin1@exmample.com","123456");
        HandleLoginPage.verifyEmailWrong();
    }

    @Test ()
    public void PassWrong(){
        HandleLoginPage loign = new HandleLoginPage(driver);
        HandleLoginPage.Login("admin@example.com", "abcdef");
        HandleLoginPage.verifyPasswordWrong();
    }
    @Test ()
    public void emailFormatWrong(){
        HandleLoginPage login = new HandleLoginPage(driver);
        HandleLoginPage.Login("abc", "123456");
        HandleLoginPage.verifyEmailFormat();
    }
}


