package bai10_Annotations;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass
    public void beforeClassParent() {
        System.out.println(" Parent - Before Class");
    }

    @AfterClass
    public void afterClassParent() {
        System.out.println("Parent - After Class");
    }
    @BeforeMethod
    public void beforeMethodParent() {
        System.out.println("Parent - Before Method");
    }

    @AfterMethod
    public void afterMethodParent() {
        System.out.println("Parent - After Method");
    }
}
