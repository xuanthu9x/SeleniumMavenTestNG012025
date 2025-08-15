package bai14_JavascripExecutor;

import bai12_ActionsClass.BaseTest12;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest12 {
    @Test
    public void demoClickByJE() throws InterruptedException {
        driver.get("https://anhtester.com/");
        // Khai báo đối tượng javascript executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // demo click on an element by javascript executor in selenium
        js.executeScript("document.getElementById('btn-login').click();");
        Thread.sleep(1000);

        WebElement inputEmail = driver.findElement(By.xpath("//input[@name ='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name ='password']"));

        // demo scroll to an element by javascript executor in selenium
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='login']"));
        // cách 1 dùng arguments và truyền element đã xác định vào argument
        js.executeScript("arguments[0].scrollIntoView(false);",btnLogin);
        // cách 2: dùng document.getElement... để xác định element và . action
        //js.executeScript("document.getElementById('login').scrollIntoView(false);");
        Thread.sleep(2000);

        // demo highligh an element's border
        js.executeScript("arguments[0].style.border='3px dotted green'", inputEmail);
        js.executeScript("arguments[0].style.border='3px dotted blue'", inputPassword);
        Thread.sleep(2000);

        // demo input value for an element 
        js.executeScript("arguments[0].setAttribute('value','admin02@mailinator.com');", inputEmail);
        js.executeScript("arguments[0].setAttribute('value','123456');",inputPassword);
        Thread.sleep(2000);



    }
}
