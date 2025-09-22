package CustomerTest;

import LoginTest.BassTest;
import LoginTest.Common;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends BassTest {
    @Test
    public void AddCustomerWithOnlyRequiredField() throws InterruptedException {
        Common common = new Common(driver);

        Common.Login();
        Common.click(By.xpath(AddCustomerLocator.menuCustomer));
        Common.click(By.xpath(AddCustomerLocator.btnNewCustomer));
        Common.sendKey(By.xpath(AddCustomerLocator.inputCompany),"T_Test_2209");
        Common.click(By.xpath(AddCustomerLocator.btnOnlySave));
        Thread.sleep(3000);
        Boolean companyNameDisplay = driver.findElement(By.xpath("//span[contains(text(),'T_Test_2209')]")).isDisplayed();
        Assert.assertTrue(companyNameDisplay,"Add customer not successfully");
    }
    @Test
    public void AddCustomerWithFullInfor(){

    }

    @Test
    public void AddCustomerAndCreateContactWithOnlyRequiredField(){

    }
    @Test
    public void AddCustomerAndCreateContactWithFullInfo(){

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
