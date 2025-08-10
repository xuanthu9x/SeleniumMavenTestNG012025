package bai13_Alert_Popup_iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class DemoHandleiFrame extends BaseTest13{
    @Test
    public void handleiFrame() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
        //driver.manage().window().setSize(new Dimension(1920,1080));
        Thread.sleep(1000);
        // count tổng số iFrame trên trang
        System.out.println("iFrame total: "+driver.findElements(By.tagName("iframe")).size());

        // Switch to frame đầu tiên, đi tới thẻ div chưa content và getText
        driver.switchTo().frame(0);
        System.out.println("Message in the first iFrame: "+driver.findElement(By.xpath("//div[@class='rsw-ce']")).getText());

        // Switch out the frame, về page chính
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("iFrame2"))).perform();
        Thread.sleep(1000);

        //Switch to the second frame by Id, click on a button in the frame
        driver.switchTo().frame("iFrame2");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='API Reference']")))
                .click();
        driver.findElement(By.xpath("//a[normalize-space()='API Reference']")).click();
        Thread.sleep(1000);
        // Switch out the frame, về page chính
        driver.switchTo().parentFrame();
    }
}
