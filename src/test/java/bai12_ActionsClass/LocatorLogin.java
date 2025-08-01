package bai12_ActionsClass;

public class LocatorLogin {
    public static String url = "https://crm.anhtester.com/admin/authentication";
    public static String loginTitle = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String loginButton = "//button[@type='submit']";
    public static String errorMessage = "//div[contains(@class , 'alert-danger')]";

    public static String CustomerItem = "//span[normalize-space()='Customers']";
    public static String dashboardItem = "//span[normalize-space()='Dashboard']";
}
