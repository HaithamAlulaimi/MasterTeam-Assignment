// Importing necessary helper classes and Selenium libraries for test execution.

import helper.ActionsAssertion;
import helper.RetryAnalyzer;
import common.CommonMethods;
import helper.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsPage;

/**
 * This class contains automated test cases for verifying the Contact Us MasterTeam Web Page.
 */

public class ContactUsTest {
    WebDriver driver;
    ContactUsPage contactUsPage;
    WebDriverHelper webDriverHelper;
    SoftAssert softAssert;
    ActionsAssertion actionsAssertion;


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver(); // Initialize ChromeDriver.
        webDriverHelper = new WebDriverHelper(driver);
        actionsAssertion = new ActionsAssertion(driver);
        contactUsPage = new ContactUsPage(driver);
        softAssert = new SoftAssert();
        CommonMethods.invokeBrowser(driver);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit(); // Close the browser after the test.
    }


    @Test(description = "Fill the contact us with valid data.", priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void testContactUsFormSubmissionWithValidData() {
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Name"), "HaithamAlulaimi", softAssert);
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Email"), "Email@Email.com", softAssert);
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Phone"), "00962785247276", softAssert);
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Contact-Message-Field-02"), "test", softAssert);

        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"Contact-Checkbox-02\"]"), softAssert);
        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"wf-form-Contact-Form-3\"]/input"), softAssert);

        // Validating that the success message is displayed correctly.
        Assert.assertEquals(webDriverHelper.findElementClassName("f-success-message").getText(),
                "Thank you! Your submission has been received!", "Message mismatch!");
        Assert.assertTrue(webDriverHelper.findElementClassName("f-success-message").isDisplayed(),
                "The success message display has failed!");
        softAssert.assertAll();
    }


    @Test(description = "Fill the contact us with Invalid Email.", priority = 2)
    public void testContactUsFormSubmissionWithInValidEmail() {
        WebElement emailElement = webDriverHelper.findElementByID("Email");

        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Name"), "HaithamAlulaimi", softAssert);
        actionsAssertion.sendKeys(emailElement, "Email", softAssert); // Sending invalid email format.
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Phone"), "00962785247276", softAssert);
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Contact-Message-Field-02"), "test", softAssert);

        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"Contact-Checkbox-02\"]"), softAssert);
        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"wf-form-Contact-Form-3\"]/input"), softAssert);

        // Validating the browser's native validation message for invalid email.
        Assert.assertEquals(emailElement.getDomProperty("validationMessage"),
                "Please include an '@' in the email address. 'Email' is missing an '@'.", "Message mismatch!");
        softAssert.assertAll();
    }


    @Test(description = "Fill the contact us with Empty Name.", priority = 3)
    public void testContactUsFormSubmissionWithInValiName() {
        WebElement nameElement = webDriverHelper.findElementByID("Name");

        actionsAssertion.sendKeys(nameElement, "", softAssert); // Sending an empty name.
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Email"), "Email", softAssert);
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Phone"), "00962785247276", softAssert);
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Contact-Message-Field-02"), "test", softAssert);

        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"Contact-Checkbox-02\"]"), softAssert);
        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"wf-form-Contact-Form-3\"]/input"), softAssert);

        // Validating the browser's native validation message for empty name.
        Assert.assertEquals(nameElement.getDomProperty("validationMessage"), "Please fill out this field.", "Message mismatch!");
        softAssert.assertAll();
    }


    @Test(description = "Fill the contact us with Empty Email.", priority = 4)
    public void testContactUsFormSubmissionWithInEmptyEmail() {
        WebElement emailElement = webDriverHelper.findElementByID("Email");

        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Name"), "HaithamAlulaimi", softAssert);
        actionsAssertion.sendKeys(emailElement, "", softAssert); // Sending an empty email.
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Phone"), "00962785247276", softAssert);
        actionsAssertion.sendKeys(webDriverHelper.findElementByID("Contact-Message-Field-02"), "test", softAssert);

        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"Contact-Checkbox-02\"]"), softAssert);
        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"wf-form-Contact-Form-3\"]/input"), softAssert);

        // Validating the browser's native validation message for empty email.
        Assert.assertEquals(emailElement.getDomProperty("validationMessage"), "Please fill out this field.", "Message mismatch!");
        softAssert.assertAll();
    }
}
