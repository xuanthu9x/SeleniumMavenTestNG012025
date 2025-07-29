package bai10_Annotations;

import org.testng.annotations.*;

public class Demo_Annotations {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Chạy trước toàn bộ suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Chạy sau toàn bộ suite");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Chạy trước tất cả các test trong một thẻ <test>");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("Chạy sau tất cả các test trong một thẻ <test>");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Chạy trước tất cả các test trong class này");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("Chạy sau tất cả các test trong class này");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Chạy trước mỗi phương thức test");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Chạy sau mỗi phương thức test");
    }
    @BeforeGroups("login")
    public void beforeGroup() {
        System.out.println("Before group - Chạy trước nhóm test login");
    }
    @Test
    public void testLoginSuccess(){
        System.out.println("Kiểm thử login success");
    }
    @Test(groups = {"login"})
    public void testLoginUserNameWrong(){
        System.out.println("Kiểm thử login failed - sai username ");
    }
    @Test
    public void testLoginPassWordWrong(){
        System.out.println("Kiểm thử login failed - sai username ");
    }
    @Test
    public void testEmailNull(){
        System.out.println("Kiểm thử login failed - sai username ");
    }
    @Test
    public void testPwNull(){
        System.out.println("Kiểm thử login failed - sai username ");
    }


}
