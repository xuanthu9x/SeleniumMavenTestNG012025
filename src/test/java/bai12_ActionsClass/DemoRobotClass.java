package bai12_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.Robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DemoRobotClass extends BaseTest12{
    @Test
    public void inputText() throws AWTException, InterruptedException {
        driver.get("https://anhtester.com/");
        WebElement inputSearch = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm khóa học . . .']"));
        inputSearch.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }
    @Test
    public void moveRobotTest() throws AWTException, InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(1000);
        Robot robot = new Robot();
        Actions action = new Actions(driver);
        //WebElement btnLogin = driver.findElement(By.xpath("//a[@id='btn-login']"));
        //action.moveToElement(btnLogin);
        robot.mouseMove(1030, 220);
        robot.delay(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(3000);
    }
    @Test
    public void createScreenCapture() throws InterruptedException, AWTException, IOException, IOException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        Robot robot = new Robot();

        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File("TestImageRobot.png");
        ImageIO.write(image, "png", file);

        Thread.sleep(1000);
    }
}
