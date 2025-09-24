package CustomerTest;

public class AddCustomerLocator {
    public static String menuCustomer = "//span[normalize-space()='Customers']";
    public static String btnNewCustomer = "//div[@class='_buttons']/descendant::a[normalize-space()='New Customer']";
    public static String inputCompany = "//input[@id = 'company']";
    public static String companyEmptyWarning = "//p[@id='company-error']";
    public static String inputVAT = "//input[@id = 'vat']";
    public static String inputPhone = "//input[@id = 'phonenumber']";
    public static String inputWebsite = "//input[@id = 'website']";
    public static String groupDropdown = "//button[@data-id='groups_in[]']";
    public static String inputSearchGroup = "//button[@data-id='groups_in[]']/following::input[@aria-controls='bs-select-1']";
    public static String btnSelectAllGroup = "//button[@data-id='groups_in[]']/following::button[normalize-space()='Select All']";
    public static String btDeselectAllGroup = "//button[@data-id='groups_in[]']/following::button[normalize-space()='Deselect All']";
    public static String optionGroup = "//div[@id='bs-select-1']/descendant::span[contains(normalize-space(),'java')]";
    public static String currencyDropdown = "//button[@data-id='default_currency']";
    public static String inputSearchCurrency="//input[@aria-controls='bs-select-2']";
    public static String currencyOptionUSD="//div[@id='bs-select-2']/descendant::span[contains(text(),'USD')]";
    public static String defaultLanguageDropdown = "//button[@data-id='default_language']";
    public static String defaultLanguageEnglish = "//div[@id = 'bs-select-3']/descendant::span[contains(text(),'English')]";
    public static String addressTextArea = "//textarea[@id = 'address']";
    public static String inputCity = "//input[@id = 'city']";
    public static String inputState = "//input[@id = 'state']";
    public static String inputZipCode = "//input[@id = 'zip']";
    public static String countryDropdown = "//button[@data-id='country']";
    public static String inputSearchCountry = "//button[@data-id='country']/following::input[@aria-controls='bs-select-4']";
    public static String countryOption = "//div[@id='bs-select-4']/descendant::span[contains(text(),'United States')]";
    public static String btnSaveAndCreateContract = "//button[contains(@class,'save-and-add-contact')]";
    public static String btnOnlySave = "//button[contains(@class,'only-save')]";
}
