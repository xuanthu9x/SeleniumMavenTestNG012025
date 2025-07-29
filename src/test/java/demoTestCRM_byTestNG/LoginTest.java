package demoTestCRM_byTestNG;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void LoginPassed() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        System.out.println("Verify login successfully");
    }
    @Test
    public void LoginWithoutEmail() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        System.out.println("Verify login without email");
    }

    @Test
    public void LoginWithoutPassword() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        System.out.println("Verify login without password");
    }
    @Test
    public void LoginWithEmailWrong() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin123@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        System.out.println("Verify login wrong email");
    }
    @Test
    public void LoginWithPasswordWrong() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456789");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        System.out.println("Verify login wrong password");
    }
}
