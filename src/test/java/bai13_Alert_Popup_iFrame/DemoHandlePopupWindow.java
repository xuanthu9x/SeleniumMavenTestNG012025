package bai13_Alert_Popup_iFrame;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DemoHandlePopupWindow extends BaseTest13{
    @Test
    public void openNewWindow() throws InterruptedException {
        // lấy id của mainwindown và gán vô biến mainWindow
        String mainWindow = driver.getWindowHandle();
        driver.get("https://anhtester.com");
        Thread.sleep(1000);

        // Mở new tab và chuyển driver tới tab đó
        driver.switchTo().newWindow(WindowType.TAB);
        // lấy id của this tab và gán vô biến firstWindow
        String firstWindow = driver.getWindowHandle();
        driver.get("https://google.com");
        Thread.sleep(1000);

        // Mở new window và chuyển driver tới window đó
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.lambdatest.com/");
        Thread.sleep(1000);
        //Close this window
        driver.close();

        // switch về first window và close tab đó
        driver.switchTo().window(firstWindow);
        Thread.sleep(1000);
        driver.close();

        // switch về main window
        driver.switchTo().window(mainWindow);
        Thread.sleep(1000);

    }
    @Test
    public void handleMultipleWindown() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().setSize(new Dimension(1920,1080));

        String mainWindow = driver.getWindowHandle();
        System.out.println("Main windown là: " + mainWindow);

        WebElement btnNewWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement btnNewTab = driver.findElement(By.xpath("//button[@id='tabButton']"));

        btnNewWindow.click();
        btnNewTab.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getWindowHandles().size() == 3);

        Set<String> windows = driver.getWindowHandles();

        for(String window : windows)
        {
            if(!window.equals(mainWindow)){
                    driver.switchTo().window(window);
                    Thread.sleep(1000);
                    System.out.println("-------------------------");
                    System.out.println("Đã switch to new windown");
                    System.out.println("Window ID:"+window);
                    System.out.println("Title of this window:"+driver.getTitle());
                    System.out.println("URL of this window: "+driver.getCurrentUrl());
                    System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
                    Thread.sleep(1000);
                    driver.close();
                    System.out.println("Đã close this window");
                }
        }
        driver.switchTo().window(mainWindow);
        System.out.println("Đã về main window");

    }
}
