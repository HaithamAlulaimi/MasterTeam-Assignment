package tests;


import helper.ActionsAssertion;
import helper.WebDriverHelper;
import common.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest {
    WebDriver driver;
    ContactUsPage contactUsPage;
    WebDriverHelper webDriverHelper;
    SoftAssert softAssert;
    ActionsAssertion actionsAssertion;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        webDriverHelper = new WebDriverHelper(driver);
        actionsAssertion = new ActionsAssertion(driver);

    }

    @BeforeMethod
    public void beforeMethod() {
        contactUsPage = new ContactUsPage(driver);
        softAssert = new SoftAssert();
        CommonMethods.invokeBrowser(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Fill the contact us with valid data.", priority = 1)
    public void testContactUsFormSubmissionWithValidData() {

        webDriverHelper.findElementByID("Name").sendKeys("HaithamAlulaimi");
        webDriverHelper.findElementByID("Email").sendKeys("Email@Email.com");
        webDriverHelper.findElementByID("Phone").sendKeys("00962785247276");
        webDriverHelper.findElementByID("Contact-Message-Field-02").sendKeys("Test");

        actionsAssertion.click(webDriverHelper.findElementByXpath("//*[@id=\"Contact-Checkbox-03\"]"));
        webDriverHelper.findElementByXpath("//*[@id=\"wf-form-Contact-Form-3\"]/input").click();
        Assert.assertTrue(webDriverHelper.findElementClassName("f-success-message").getText().equals("Thank you! Your submission has been received!"), "Expected success message was not found");
        Assert.assertTrue(webDriverHelper.findElementClassName("f-success-message").isDisplayed(), "The success message display is failed !!");
        softAssert.assertAll();
    }
}



