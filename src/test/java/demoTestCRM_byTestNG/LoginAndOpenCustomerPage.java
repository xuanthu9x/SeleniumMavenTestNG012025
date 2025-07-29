package demoTestCRM_byTestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginAndOpenCustomerPage extends BaseTest_BeforeClass{
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
    public void OpenCustomerPage() throws InterruptedException {
        driver.findElement(By.xpath(LocatorLogin.CustomerItem)).click();
        Thread.sleep(1000);
        System.out.println("Open customer page");
    }

}
