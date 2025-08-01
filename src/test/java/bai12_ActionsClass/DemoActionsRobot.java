package bai12_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoActionsRobot extends BaseTest12 {

    @Test
    public void testSendKey() throws InterruptedException {
        Actions action = new Actions(driver);
    driver.get(LocatorLogin.url);

        WebElement inputEmail = driver.findElement(By.xpath(LocatorLogin.inputEmail));
        action.sendKeys(inputEmail, "admin@example.com").perform();
        Thread.sleep(1000);
        WebElement inputPassword = driver.findElement(By.xpath(LocatorLogin.inputPassword));
        action.sendKeys(inputPassword,"123456").perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        WebElement customerItem = driver.findElement(By.xpath(LocatorLogin.CustomerItem));
        action.click(customerItem).perform();
        Thread.sleep(1000);
    }
    @Test
    public void moveToElement() throws InterruptedException {
        Actions action = new Actions(driver);

        driver.get("https://anhtester.com/");
        WebElement tatCaKhoaHocBtn = driver.findElement(By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]"));
        action.moveToElement(tatCaKhoaHocBtn).perform();
        Thread.sleep(1000);

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        Actions action = new Actions(driver);
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement from = driver.findElement(By.xpath("//span[normalize-space()='Draggable 1']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='mydropzone']"));
        action.dragAndDrop(from, to).perform();
        Thread.sleep(1000);
    }
    @Test
    public void keyUpAndKeyDown() throws InterruptedException {
        driver.get("https://anhtester.com/");
        // Khai báo class actions
        Actions action = new Actions(driver);
        WebElement search = driver.findElement(By.xpath("(//input[@placeholder='Tìm kiếm khóa học . . .'])"));
        // gọi action để nhấn ship và nhập chuỗi => chuỗi được viết hoa
        action.keyDown(search, Keys.SHIFT).sendKeys("Tester").keyUp(Keys.SHIFT).sendKeys(" abc").build().perform();
        Thread.sleep(1000);
        // clear ô search
        search.clear();
        Thread.sleep(1000);
        // Nhập lại ô search
        search.sendKeys("Test");
        // gọi action nhấn Control A để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        // gọi action nhấn control c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        WebElement search2 = driver.findElement(By.xpath("//input[@placeholder='Bạn muốn học gì?']"));
        // move to ô search khóa học
        action.moveToElement(search2);
        // click lên ô search khóa học
        search2.click();
        // gọi action để control v
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(3000);
    }
    @Test
    public void keyUpKeyDown() throws InterruptedException {
        Actions action = new Actions(driver);
        driver.get("https://anhtester.com/");
        action.keyDown(Keys.ARROW_DOWN).perform();
        action.keyUp(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
    }
}
