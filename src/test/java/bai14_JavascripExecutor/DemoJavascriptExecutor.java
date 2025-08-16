package bai14_JavascripExecutor;

import bai12_ActionsClass.BaseTest12;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest12 {
    @Test
    public void demoClickByJE() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        // Khai báo đối tượng javascript executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));

        // demo highligh an element's border
        js.executeScript("arguments[0].style.border='3px dotted green'", inputEmail);
        js.executeScript("arguments[0].style.border='3px dotted blue'", inputPassword);
        Thread.sleep(2000);

        // demo input value for an element
        js.executeScript("arguments[0].setAttribute('value','admin@example.com');", inputEmail);
        js.executeScript("arguments[0].setAttribute('value','123456');",inputPassword);
        Thread.sleep(2000);

        //demo handle checkbox
        js.executeScript("document.getElementById('remember').checked = true;");
        Thread.sleep(2000);

        // demo click on an element by javascript executor in selenium
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].click();",btnLogin);
        Thread.sleep(1000);

        // demo refresh page
        js.executeScript("history.go(0)");
        Thread.sleep(1000);

        // get title of web page
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Web page's title is: "+titleText);

        // get domain
        String domainName= js.executeScript("return document.domain;").toString();
        System.out.println("Domain name is: "+ domainName);

        // get URL
        String url= js.executeScript("return document.URL;").toString();
        System.out.println(url);

        // get high and width
        String high = js.executeScript("return window.innerHeight;").toString();
        String width = js.executeScript("return window.innerWidth;").toString();
        System.out.println("High: " + high+ " Width: " + width);

        // demo click on an element is hidden
        WebElement subMenuSales = driver.findElement(By.xpath("//a[@href='https://crm.anhtester.com/admin/reports/sales']"));
        js.executeScript("arguments[0].click();",subMenuSales);
        Thread.sleep(1000);

        // demo scroll to an element by javascript executor in selenium
        WebElement subMenuKBArticles = driver.findElement(By.xpath("//span[normalize-space() = 'KB Articles']"));
        js.executeScript("arguments[0].scrollIntoView(false);",subMenuKBArticles);
        Thread.sleep(2000);
    }
}
