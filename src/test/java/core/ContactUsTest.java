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

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

    @Test(description = "Fill the contact us with valid data.", priority = 1)
    public void FillTheContactUsWithValidData() {
        driver.navigate();

    }
}



