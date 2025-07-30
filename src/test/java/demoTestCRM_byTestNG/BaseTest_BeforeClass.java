package demoTestCRM_byTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest_BeforeClass {
    public WebDriver driver;
    public SoftAssert softAssert;
    @BeforeClass
    public void createDriver(){
        System.out.println("Khởi tạo trình duyệt");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
    }
    @AfterClass
    public void closeDriver(){
        if(driver!=null)
        {
            driver.quit();
            softAssert.assertAll();
        }
        System.out.println("Đóng trình duyệt");

    }
}
