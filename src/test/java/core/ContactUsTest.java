package core;


import pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTest {
    WebDriver driver;
    ContactUsPage contactUsPage;
Actions actions;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        contactUsPage = new ContactUsPage(driver);
        actions=new Actions(driver);
        CommonMethods.invokeBrowser(driver);
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

    @Test(description = "Fill the contact us with valid data.", priority = 1)
    public void FillTheContactUsWithValidData() {

        actions.findElementByID("Name").sendKeys("HaithamAlulaimi");
        actions.findElementByID("Email").sendKeys("Email@Email.com");
        actions.findElementByID("Phone").sendKeys("00962785247276");
        actions.findElementByID("Contact-Message-Field-02").sendKeys("Test");
        actions.findElementByXpath("//*[@id=\"Contact-Checkbox-02\"]/div").click();
        actions.findElementByXpath("//*[@id=\"wf-form-Contact-Form-3\"]/input").click();

    }
}



