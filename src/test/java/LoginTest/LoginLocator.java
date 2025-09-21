package LoginTest;

public class LoginLocator {
    public static String url = "https://crm.anhtester.com/admin/authentication";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String checkboxRememberMe = "//label[normalize-space()='Remember me']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String emailEmptyWarning = "//div[normalize-space()='The Email Address field is required.']";
    public static String passwordEmptyWarning = "//div[normalize-space()='The Password field is required.']";
    public static String email_pwWrongWarning = "//div[@class='text-center alert alert-danger']";
}
