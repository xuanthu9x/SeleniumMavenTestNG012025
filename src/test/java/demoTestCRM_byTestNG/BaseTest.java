package demoTestCRM_byTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeMethod
    public void createDriver(){
        System.out.println("Khởi tạo trình duyệt");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void closeDriver(){
        if(driver!=null)
        {
            driver.quit();
        }
        System.out.println("Đóng trình duyệt");

    }
    }

