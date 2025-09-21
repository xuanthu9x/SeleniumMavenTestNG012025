package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTC extends BassTest {

    @Test
    public void LoginSuccess(){
        driver.get(LoginLocator.url);
        Common common = new Common(driver);

        Common.sendKey(By.xpath(LoginLocator.inputEmail), "admin@example.com");
        Common.sendKey(By.xpath(LoginLocator.inputPassword),"123456");
        Common.click(By.xpath(LoginLocator.checkboxRememberMe));
        Common.click(By.xpath(LoginLocator.buttonLogin));


        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed());
    }

    @Test
    public void EmailEmpty(){
        driver.get(LoginLocator.url);
        Common common = new Common(driver);

        Common.clearText(By.xpath(LoginLocator.inputEmail));
        Common.sendKey(By.xpath(LoginLocator.inputPassword), "123456");
        Common.click(By.xpath(LoginLocator.buttonLogin));
        String emailEmptyWarning = Common.getText(By.xpath(LoginLocator.emailEmptyWarning));
        Common.softAssertEqual(emailEmptyWarning,"The Email Address field is required.");
    }

    @Test
    public void PasswordEmpty(){
        driver.get(LoginLocator.url);
        Common common = new Common(driver);

        Common.sendKey(By.xpath(LoginLocator.inputEmail), "admin@example.com");
        Common.clearText(By.xpath(LoginLocator.inputPassword));
        Common.click(By.xpath(LoginLocator.buttonLogin));
        String passwordEmptyWarning = Common.getText(By.xpath(LoginLocator.passwordEmptyWarning));
        Common.softAssertEqual(passwordEmptyWarning, "The Password field is required.");
    }
    @Test
    public void EmailWrong(){
        driver.get(LoginLocator.url);
        Common common = new Common(driver);

        Common.sendKey(By.xpath(LoginLocator.inputEmail), "admin1@example.com");
        Common.sendKey(By.xpath(LoginLocator.inputPassword), "123456");
        Common.click(By.xpath(LoginLocator.buttonLogin));
        String emailWrongWarning = Common.getText(By.xpath(LoginLocator.email_pwWrongWarning));
        Common.softAssertEqual(emailWrongWarning,"Invalid email or password");
    }

    @Test
    public void PassWrong(){
        driver.get(LoginLocator.url);
        Common common = new Common(driver);

        Common.sendKey(By.xpath(LoginLocator.inputEmail),"admin1@example.com");
        Common.sendKey(By.xpath(LoginLocator.inputPassword),"123456789");
        Common.click(By.xpath(LoginLocator.buttonLogin));
        String passwordWrongWarning = Common.getText(By.xpath(LoginLocator.email_pwWrongWarning));
        Common.softAssertEqual(passwordWrongWarning,"Invalid email or password");
    }
    @Test
    public void emailFormatWrong(){
        driver.get(LoginLocator.url);
        Common common = new Common(driver);

        Common.sendKey(By.xpath(LoginLocator.inputEmail), "abc");
        Common.sendKey(By.xpath(LoginLocator.inputPassword), "12345");
        Common.click(By.xpath(LoginLocator.buttonLogin));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualMessage = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(By.xpath(LoginLocator.inputEmail)));
        Common.softAssertEqual(actualMessage, "Please include an '@' in the email address. 'abc' is missing an '@'.");
    }
}


