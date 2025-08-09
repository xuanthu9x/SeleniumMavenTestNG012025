package bai13_Alert_Popup_iFrame;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class DemoHandleAlert extends BaseTest13{
    @Test
    public void handleAlertAccept() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        // click to opent the alert
        driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[1]")).click();
        Thread.sleep(1000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        Thread.sleep(1000);
    }
    @Test
    public void handleAlertDismiss() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        // Set time chờ để check alert có được bấm hay không
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Click to opent the alert
        driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[2]")).click();
        Thread.sleep(1000);
        // Cờ để check đã có action trên alert hay chưa
        boolean hasAction = false;
        boolean accept = false;
        boolean dismiss = true;
        try {
            Alert alert1 = driver.switchTo().alert();
            if (accept) {
                dismiss = false;
                alert1.accept();
                hasAction = true;
                accept = true;
                Thread.sleep(1000);
            } else if (dismiss) {
                accept = false;
                alert1.dismiss();
                hasAction = true;
                dismiss = true;
                Thread.sleep(1000);
            }
        } catch (TimeoutException e) {
            hasAction = false;
        }

        if (!hasAction) {
            System.out.printf("No action on alert");
            Assert.assertTrue(hasAction, "No action on alert");
        } else if (accept) {
            System.out.println("You click OK on alert");
            Assert.assertFalse(accept, "You click OK on alert");
        } else if (dismiss) {
            System.out.println("You click Cancel on alert");
            Assert.assertTrue(dismiss, "You don't click Cancel on alert");
        }
    }
}
