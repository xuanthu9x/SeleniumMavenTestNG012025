package bai15_Wait;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class DemoExplicitWait {
    public WebDriver driver;
    @Test
    public void demoExplicitWait(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hrm.anhtester.com/");

        // get title of page
        System.out.println(driver.getTitle());

        // Khởi tạo Object cho class WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //titleIs() – Điều kiện mong đợi là chờ một trang có tiêu đề cụ thể.
        wait.until(ExpectedConditions.titleIs("HRM | Anh Tester Demo | Log in"));

        //textToBePresentInElement() – Điều kiện mong đợi là chờ một phần tử chứa đoạn text được chỉ định.
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@class = 'text-left']")),"Welcome to HRM | Anh Tester Demo"));

        WebElement inputName = driver.findElement(By.xpath("//input[@id='iusername']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ipassword']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        // visibilityOf() - được sử dụng để kiểm tra xem một phần tử hiện diện trên DOM của một trang có hiển thị hay không.
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys("admin_example");

        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys("123456");

        //elementToBeClickable() – Điều kiện mong đợi là chờ một phần tử có thể click được,
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        btnLogin.click();
        driver.quit();
    }

    @Test
    public void demoExplicitWait_Alert(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickMeBtn = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));

        wait.until(ExpectedConditions.elementToBeClickable(clickMeBtn));
        WebElement openAlert = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",openAlert);

        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert is opened");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.quit();
    }

    @Test
    public void demoExplicitWait_iFrame(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        System.out.println(driver.findElement(By.xpath("(//h1[normalize-space()='This is a sample page'])[1]")).getText());
        driver.quit();
    }
}
