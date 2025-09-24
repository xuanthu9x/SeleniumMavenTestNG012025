package CustomerTest;

import LoginTest.BassTest;
import LoginTest.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends BassTest {
    @Test
    public void AddCustomerWithOnlyRequiredField() throws InterruptedException {
        Common common = new Common(driver);

        Common.Login();
        Common.click(By.xpath(AddCustomerLocator.menuCustomer));
        Common.click(By.xpath(AddCustomerLocator.btnNewCustomer));
        String companyName ="T_Test1_2409";
        Common.sendKey(By.xpath(AddCustomerLocator.inputCompany),companyName);
        Common.click(By.xpath(AddCustomerLocator.btnOnlySave));
        Thread.sleep(3000);
        Boolean companyNameDisplay = driver.findElement(By.xpath("//span[contains(text(),'"+companyName+"')]")).isDisplayed();
        Assert.assertTrue(companyNameDisplay,"Add customer not successfully");
    }
    @Test
    public void AddCustomerWithFullInfor() throws InterruptedException {
        Common common = new Common(driver);
        Common.Login();
        Common.click(By.xpath(AddCustomerLocator.menuCustomer));
        Common.click(By.xpath(AddCustomerLocator.btnNewCustomer));

        String companyname = "T_Test2_2409";
        Common.sendKey(By.xpath(AddCustomerLocator.inputCompany),companyname);
        Common.sendKey(By.xpath(AddCustomerLocator.inputVAT),"VAT123");
        Common.sendKey(By.xpath(AddCustomerLocator.inputPhone),"0336775288");
        Common.sendKey(By.xpath(AddCustomerLocator.inputWebsite),"google.com");
        Common.click(By.xpath(AddCustomerLocator.groupDropdown));
        String group = "java";
        Common.sendKey(By.xpath(AddCustomerLocator.inputSearchGroup),group);
        Thread.sleep(1000);
        Common.click(By.xpath("//div[@id='bs-select-1']/descendant::span[contains(normalize-space(),'"+group+"')]"));
        driver.findElement(By.xpath("//body")).click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(AddCustomerLocator.countryDropdown))).perform();

        Common.click(By.xpath(AddCustomerLocator.currencyDropdown));
        Common.click(By.xpath(AddCustomerLocator.currencyOptionUSD));
        Common.click(By.xpath(AddCustomerLocator.defaultLanguageDropdown));
        Common.click(By.xpath(AddCustomerLocator.defaultLanguageEnglish));
        Common.sendKey(By.xpath(AddCustomerLocator.addressTextArea),"8414 Martin Luther King Jr Way South Seattle Washington 98118");
        Common.sendKey(By.xpath(AddCustomerLocator.inputCity),"Washington ");
        Common.sendKey(By.xpath(AddCustomerLocator.inputState),"Seattle ");
        Common.sendKey(By.xpath(AddCustomerLocator.inputZipCode),"98118");
        Common.click(By.xpath(AddCustomerLocator.countryDropdown));
        Common.click(By.xpath(AddCustomerLocator.countryOption));

        action.moveToElement(driver.findElement(By.xpath(AddCustomerLocator.btnOnlySave))).perform();
        Common.click(By.xpath(AddCustomerLocator.btnOnlySave));
        Thread.sleep(3000);
        Boolean companyNameDisplay = driver.findElement(By.xpath("//span[contains(text(),'"+companyname+"')]")).isDisplayed();
        Assert.assertTrue(companyNameDisplay,"Add customer not successfully");
    }

    @Test
    public void AddCustomerAndCreateContactWithOnlyRequiredField() throws InterruptedException {
        Common common = new Common(driver);

        Common.Login();
        Common.click(By.xpath(AddCustomerLocator.menuCustomer));
        Common.click(By.xpath(AddCustomerLocator.btnNewCustomer));
        String companyName = "T_Test3_2409";
        Common.sendKey(By.xpath(AddCustomerLocator.inputCompany),companyName);
        Common.click(By.xpath(AddCustomerLocator.btnSaveAndCreateContract));
        Thread.sleep(2000);
        Boolean newContactPopup = driver.findElement(By.xpath("//div[@id='contact']")).isDisplayed();
        Assert.assertTrue(newContactPopup,"Add new contact pop-up is not shown");
        Common.click(By.xpath("//button[normalize-space() = 'Close']"));
        Boolean companyNameDisplay = driver.findElement(By.xpath("//span[contains(text(),'"+companyName+"')]")).isDisplayed();
        Assert.assertTrue(companyNameDisplay,"Add customer not successfully");
    }
    @Test
    public void AddCustomerAndCreateContactWithFullInfo() throws InterruptedException {
        Common common = new Common(driver);
        Common.Login();
        Common.click(By.xpath(AddCustomerLocator.menuCustomer));
        Common.click(By.xpath(AddCustomerLocator.btnNewCustomer));

        String companyname = "T_Test4_2409";
        Common.sendKey(By.xpath(AddCustomerLocator.inputCompany),companyname);
        Common.sendKey(By.xpath(AddCustomerLocator.inputVAT),"VAT123");
        Common.sendKey(By.xpath(AddCustomerLocator.inputPhone),"0336775288");
        Common.sendKey(By.xpath(AddCustomerLocator.inputWebsite),"google.com");
        Common.click(By.xpath(AddCustomerLocator.groupDropdown));
        String group = "java";
        Common.sendKey(By.xpath(AddCustomerLocator.inputSearchGroup),group);
        Thread.sleep(1000);
        Common.click(By.xpath("//div[@id='bs-select-1']/descendant::span[contains(normalize-space(),'"+group+"')]"));
        driver.findElement(By.xpath("//body")).click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(AddCustomerLocator.countryDropdown))).perform();

        Common.click(By.xpath(AddCustomerLocator.currencyDropdown));
        Common.click(By.xpath(AddCustomerLocator.currencyOptionUSD));
        Common.click(By.xpath(AddCustomerLocator.defaultLanguageDropdown));
        Common.click(By.xpath(AddCustomerLocator.defaultLanguageEnglish));
        Common.sendKey(By.xpath(AddCustomerLocator.addressTextArea),"8414 Martin Luther King Jr Way South Seattle Washington 98118");
        Common.sendKey(By.xpath(AddCustomerLocator.inputCity),"Washington ");
        Common.sendKey(By.xpath(AddCustomerLocator.inputState),"Seattle ");
        Common.sendKey(By.xpath(AddCustomerLocator.inputZipCode),"98118");
        Common.click(By.xpath(AddCustomerLocator.countryDropdown));
        Common.click(By.xpath(AddCustomerLocator.countryOption));

        action.moveToElement(driver.findElement(By.xpath(AddCustomerLocator.btnOnlySave))).perform();
        Common.click(By.xpath(AddCustomerLocator.btnSaveAndCreateContract));
        Thread.sleep(3000);
        Boolean newContactPopup = driver.findElement(By.xpath("//div[@id='contact']")).isDisplayed();
        Assert.assertTrue(newContactPopup,"Add new contact pop-up is not shown");
        Common.click(By.xpath("//button[normalize-space() = 'Close']"));
        Boolean companyNameDisplay = driver.findElement(By.xpath("//span[contains(text(),'"+companyname+"')]")).isDisplayed();
        Assert.assertTrue(companyNameDisplay,"Add customer not successfully");
    }

    @Test
    public void ValidateRequireField(){
        Common common = new Common(driver);

        Common.Login();
        Common.click(By.xpath(AddCustomerLocator.menuCustomer));
        Common.click(By.xpath(AddCustomerLocator.btnNewCustomer));
        Common.clearText(By.xpath(AddCustomerLocator.inputCompany));
        Common.click(By.xpath(AddCustomerLocator.btnOnlySave));

        Boolean warningDisplay = driver.findElement(By.xpath(AddCustomerLocator.companyEmptyWarning)).isDisplayed();
        Assert.assertTrue(warningDisplay,"Validate company empty is not shown");
        String warningMessage = driver.findElement(By.xpath(AddCustomerLocator.companyEmptyWarning)).getText();
        Common.softAssertEqual(warningMessage,"This field is required.");
    }
}
