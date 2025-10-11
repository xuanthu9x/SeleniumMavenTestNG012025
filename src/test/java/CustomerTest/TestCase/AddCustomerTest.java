package CustomerTest.TestCase;

import CustomerTest.CustomerPage.AddCustomerPage;
import LoginTest.HandlePage.BassTest;
import LoginTest.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends BassTest {
    @Test
    public void AddCustomerWithOnlyRequiredField() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        AddCustomerPage.InputAddCustomerWithOnlyRequireField("T_Test_111025");
        AddCustomerPage.AddCustomerOnlySave();
        Thread.sleep(3000);
        AddCustomerPage.verifyAddCustomerSuccessfully("T_Test_111025");
    }
    @Test
    public void AddCustomerWithFullInfor() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        AddCustomerPage.InputFullCustomerInfor("T_Test2_111025","VAT123","0336775288","google.com","java", "8414 Martin Luther King Jr Way South Seattle Washington 98118","Washington","Seattle","98118");
        AddCustomerPage.AddCustomerOnlySave();
        Thread.sleep(3000);
        AddCustomerPage.verifyAddCustomerSuccessfully("T_Test2_111025");
    }

    @Test
    public void AddCustomerAndCreateContactWithOnlyRequiredField() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        AddCustomerPage.InputAddCustomerWithOnlyRequireField("T_Test3_111025");
        AddCustomerPage.AddCustomerAndContact();
        Thread.sleep(2000);
        AddCustomerPage.verifyAddCustomerWithContact("T_Test3_111025");
    }
    @Test
    public void AddCustomerAndCreateContactWithFullInfo() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        AddCustomerPage.InputFullCustomerInfor("T_Test4_111025","VAT123","0336775288","google.com","java", "8414 Martin Luther King Jr Way South Seattle Washington 98118","Washington","Seattle","98118");
        AddCustomerPage.AddCustomerAndContact();
        Thread.sleep(3000);
        AddCustomerPage.verifyAddCustomerWithContact("T_Test4_111025");
    }

    @Test
    public void ValidateRequireField(){
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        AddCustomerPage.InputAddCustomerWithOnlyRequireField("");
        AddCustomerPage.AddCustomerOnlySave();

        AddCustomerPage.verifyRequireFieldWarning();
    }
}
