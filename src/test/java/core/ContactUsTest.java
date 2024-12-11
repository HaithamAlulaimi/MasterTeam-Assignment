package core;


import org.testng.Assert;
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
    Actions actions;
    SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        contactUsPage = new ContactUsPage(driver);
        actions = new Actions(driver);
        softAssert = new SoftAssert();

        CommonMethods.invokeBrowser(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Fill the contact us with valid data.", priority = 1)
    public void FillTheContactUsWithValidData() {

        actions.findElementByID("Name").sendKeys("HaithamAlulaimi");
        actions.findElementByID("Email").sendKeys("Email@Email.com");
        actions.findElementByID("Phone").sendKeys("00962785247276");
        actions.findElementByID("Contact-Message-Field-02").sendKeys("Test");
        actions.findElementByXpath("//*[@id=\"Contact-Checkbox-02\"]/div").click();
        actions.findElementByXpath("//*[@id=\"wf-form-Contact-Form-3\"]/input").click();
        Assert.assertTrue(actions.findElementClassName("f-success-message").getText().equals("Thank you! Your submission has been received!"),"The success message content assertion is failed !!");
        Assert.assertTrue(actions.findElementClassName("f-success-message").isDisplayed(),"The success message display is failed !!");
        softAssert.assertAll();
    }
}



