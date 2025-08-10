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
        // Set time chờ để check alert có được bấm hay không
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Click to opent the alert
        driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[2]")).click();
        Thread.sleep(1000);
        // Cờ để check đã có action trên alert hay chưa
        boolean hasAction = false;
        boolean accept = true;
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
            Assert.assertTrue(accept, "You click OK on alert");
        } else if (dismiss) {
            System.out.println("You click Cancel on alert");
            Assert.assertFalse(dismiss, "You don't click Cancel on alert");
        }
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
    @Test()
    public void handleAlertSendKey() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        // Set time chờ để check alert có được bấm hay không
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Click to opent the alert
        driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[3]")).click();
        Thread.sleep(1000);
        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("Thư test");
        alert1.accept();
        String inputtedText = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        Assert.assertEquals(inputtedText, "You have entered 'Thư test' !");
    }
    @Test
    public void alertGetText(){
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[3]")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Please enter your name");
    }
}
