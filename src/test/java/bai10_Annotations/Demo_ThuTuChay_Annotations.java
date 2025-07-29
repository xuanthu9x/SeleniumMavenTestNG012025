package bai10_Annotations;

import org.testng.annotations.*;

public class Demo_ThuTuChay_Annotations extends BaseTest{

        @BeforeSuite(alwaysRun=true)
        public void beforeSuite() {
            System.out.println("Before Suite");
        }

        @AfterSuite(alwaysRun=true)
        public void afterSuite() {
            System.out.println("After Suite");
        }

        @BeforeTest(alwaysRun=true)
        public void beforeTest() {
            System.out.println("Before Test");
        }

        @AfterTest(alwaysRun=true)
        public void afterTest() {
            System.out.println("After Test");
        }

        @BeforeClass(alwaysRun=true)
        public void beforeClass() {
            System.out.println("Before Class");
        }

        @AfterClass(alwaysRun=true)
        public void afterClass() {
            System.out.println("After Class");
        }

        @BeforeGroups(groups = {"testOne"})
        public void beforeGroupOne() {
            System.out.println("Before Group testOne");
        }

        @AfterGroups(groups = {"testOne"})
        public void afterGroupOne() {
            System.out.println("After Group testOne");
        }

        @BeforeGroups(groups = {"testTwo"})
        public void beforeGroupTwo() {
            System.out.println("Before Group testTwo");
        }

        @AfterGroups(groups = {"testTwo"})
        public void afterGroupTwo() {
            System.out.println("After Group testTwo");
        }

        @BeforeMethod
        public void beforeMethod() {
            System.out.println("Before Method");
        }

        @AfterMethod
        public void afterMethod() {
            System.out.println("After Method");
        }

        @Test(groups = {"testOne"}, priority = 2)
        public void testOneMethod() {
            System.out.println("Test method 1");
        }
        @Test(groups = {"testOne"}, priority = 1)
        public void testThirdMethod() {
            System.out.println("Test method 2 group 1");
        }

        @Test(groups = {"testOne"}, enabled = false)
        public void testFourthMethod() {
            System.out.println("Test method 3 group 1");
        }

        @Test(groups = {"testTwo"})
        public void testTwoMethod() {
            System.out.println("Test method 2");
        }
}
