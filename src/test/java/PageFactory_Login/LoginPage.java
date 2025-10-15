package PageFactory_Login;

import LoginTest.HandlePage.HandleLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage {
    private static WebDriver driver;

    public static String url = "https://crm.anhtester.com/admin/authentication";

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//label[normalize-space()='Remember me']")
    WebElement checkboxRememberMe;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement buttonLogin;

    @FindBy(xpath = "//div[normalize-space()='The Email Address field is required.']")
    WebElement emailEmptyWarning;

    @FindBy(xpath = "//div[normalize-space()='The Password field is required.']")
    WebElement passwordEmptyWarning;

    @FindBy(xpath = "//div[@class='text-center alert alert-danger']")
    WebElement email_pwWrongWarning;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }

    public  void Login(String email, String password){
        driver.get(url);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public void LoginWithRememberMe(String email, String password){
        driver.get(url);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        boolean checkedRememberMe = checkboxRememberMe.isSelected();
        if (!checkedRememberMe){
            checkboxRememberMe.click();
        }
       buttonLogin.click();
    }

    public  void verifyLoginSuccess(){
        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed());
    }

    public void verifyEmailEmptyWarning(){
        String emailEmptyWarningMg = emailEmptyWarning.getText();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(emailEmptyWarningMg,"The Email Address field is required.");
    }

    public void verifyPasswordEmptyWarning(){
        String passwordEmptyWarningMg = passwordEmptyWarning.getText();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(passwordEmptyWarningMg,"The Password field is required.");
    }

    public  void verifyEmailWrong(){
        String emailWrongWarning = email_pwWrongWarning.getText();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(emailWrongWarning,"Invalid email or password");
    }

    public  void verifyPasswordWrong(){
        String passwordWrongWarning = email_pwWrongWarning.getText();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(passwordWrongWarning,"Invalid email or password");
    }

    public  void verifyEmailFormat(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualMessage = (String) js.executeScript(
                "return arguments[0].validationMessage;", inputEmail);
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualMessage,"Please include an '@' in the email address. 'abc' is missing an '@'.");
    }
}
