package LoginTest.HandlePage;

import LoginTest.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleLoginPage {
    private static WebDriver driver;
    public static String url = "https://crm.anhtester.com/admin/authentication";
    //public static String inputEmail = "//input[@id='email']";
    private static By inputEmail = By.xpath("//input[@id='email']");
    //public static String inputPassword = "//input[@id='password']";
    private static By inputPassword = By.xpath("//input[@id='password']");
    //public static String checkboxRememberMe = "//label[normalize-space()='Remember me']";
    private static By checkboxRememberMe = By.xpath("//label[normalize-space()='Remember me']");
    //public static String buttonLogin = "//button[normalize-space()='Login']";
    private static By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    //public static String emailEmptyWarning = "//div[normalize-space()='The Email Address field is required.']";
    private  static By emailEmptyWarning = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    //public static String passwordEmptyWarning = "//div[normalize-space()='The Password field is required.']";
    private  static By passwordEmptyWarning = By.xpath("//div[normalize-space()='The Password field is required.']");
    //public static String email_pwWrongWarning = "//div[@class='text-center alert alert-danger']";
    private  static By email_pwWrongWarning = By.xpath("//div[@class='text-center alert alert-danger']");

    public HandleLoginPage(WebDriver driver){
        this.driver = driver;
    }
    public static void Login(String email, String password){
        driver.get(url);
        Common common = new Common( driver);
        Common.sendKey(inputEmail,email);
        Common.sendKey(inputPassword, password);
        Common.click(buttonLogin);
    }

    public static void LoginWithRememberMe(String email, String password){
        driver.get(url);
        Common common = new Common(driver);
        Common.sendKey(inputEmail, email);
        Common.sendKey(inputPassword, password);
        boolean checkedRememberMe = driver.findElement(checkboxRememberMe).isSelected();
        if (!checkedRememberMe){
            Common.click(checkboxRememberMe);
        }
        Common.click(buttonLogin);
    }

    public static void verifyLoginSuccess(){
        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed());
    }

    public static void verifyEmailEmptyWarning(){
        String emailEmptyWarning = Common.getText(HandleLoginPage.emailEmptyWarning);
        Common.softAssertEqual(emailEmptyWarning,"The Email Address field is required.");
    }

    public  static void verifyPasswordEmptyWarning(){
        String passwordEmptyWarning = Common.getText(HandleLoginPage.passwordEmptyWarning);
        Common.softAssertEqual(passwordEmptyWarning, "The Password field is required.");
    }

    public static void verifyEmailWrong(){
        String emailWrongWarning = Common.getText(HandleLoginPage.email_pwWrongWarning);
        Common.softAssertEqual(emailWrongWarning,"Invalid email or password");
    }

    public static void verifyPasswordWrong(){
        String passwordWrongWarning = Common.getText(HandleLoginPage.email_pwWrongWarning);
        Common.softAssertEqual(passwordWrongWarning,"Invalid email or password");
    }

    public static void verifyEmailFormat(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualMessage = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(HandleLoginPage.inputEmail));
        Common.softAssertEqual(actualMessage, "Please include an '@' in the email address. 'abc' is missing an '@'.");
    }
}
