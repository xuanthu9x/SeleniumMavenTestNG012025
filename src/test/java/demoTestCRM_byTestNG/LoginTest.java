package demoTestCRM_byTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends BaseTest {

    @Test
    public void LoginPassed() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        // Cách 1 - kiểm tra dựa vào dashboard item trên menu dashboard
        //List<WebElement> dashboardItem = driver.findElements(By.xpath(LocatorLogin.dashboardItem));
        //Assert.assertTrue(dashboardItem.size() > 0, " login failed - dashboard item is not shown");
        // Cách 2 - kiểm tra dựa vào thông báo lỗi có tồn tại hay không
        List<WebElement> errorMessageDisplay = driver.findElements(By.xpath(LocatorLogin.errorMessage));
        Assert.assertFalse(errorMessageDisplay.size() > 0, " login successfully -error message is not shown");
        System.out.println("Login successfully");
    }
    @Test()
    public void LoginWithoutEmail() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        //  Kiểm tra error message có tồn tại không
        List<WebElement> errorMessageDisplay = driver.findElements(By.xpath(LocatorLogin.errorMessage));
        Assert.assertTrue(errorMessageDisplay.size() > 0, " login successfully -error message is not shown");
        System.out.println("Login failed");
        // Kiểm tra error message có chính xác không
        String errorMessage = driver.findElement(By.xpath(LocatorLogin.errorMessage)).getText();
        Assert.assertEquals(errorMessage, "The Email Address field is required.");
        System.out.println("Error message is correctly");
    }

    @Test
    public void LoginWithoutPassword() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        //  Kiểm tra error message có tồn tại không
        List<WebElement> errorMessageDisplay = driver.findElements(By.xpath(LocatorLogin.errorMessage));
        Assert.assertTrue(errorMessageDisplay.size() > 0, " login successfully -error message is not shown");
        System.out.println("Login failed");
        // Kiểm tra error message có chính xác không
        String errorMessage = driver.findElement(By.xpath(LocatorLogin.errorMessage)).getText();
        Assert.assertEquals(errorMessage, "The Password field is required.");
        System.out.println("Error message is correctly");
    }
    @Test
    public void LoginWithEmailWrong() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin123@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        //  Kiểm tra error message có tồn tại không
        List<WebElement> errorMessageDisplay = driver.findElements(By.xpath(LocatorLogin.errorMessage));
        Assert.assertTrue(errorMessageDisplay.size() > 0, " login successfully -error message is not shown");
        System.out.println("Login failed");
        // Kiểm tra error message có chính xác không
        String errorMessage = driver.findElement(By.xpath(LocatorLogin.errorMessage)).getText();
        Assert.assertEquals(errorMessage, "Invalid email or password");
        System.out.println("Error message is correctly");
    }
    @Test
    public void LoginWithPasswordWrong() throws InterruptedException {
        driver.get(LocatorLogin.url);
        driver.findElement(By.xpath(LocatorLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorLogin.inputPassword)).sendKeys("123456789");
        driver.findElement(By.xpath(LocatorLogin.loginButton)).click();
        Thread.sleep(1000);
        //  Kiểm tra error message có tồn tại không
        List<WebElement> errorMessageDisplay = driver.findElements(By.xpath(LocatorLogin.errorMessage));
        Assert.assertTrue(errorMessageDisplay.size() > 0, " login successfully -error message is not shown");
        System.out.println("Login failed");
        // Kiểm tra error message có chính xác không
        String errorMessage = driver.findElement(By.xpath(LocatorLogin.errorMessage)).getText();
        Assert.assertEquals(errorMessage, "Invalid email or password");
        System.out.println("Error message is correctly");
    }


}
