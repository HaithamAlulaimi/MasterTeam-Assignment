package common;

import core.CorePage;
import enums.ConfigKey;
import org.openqa.selenium.WebDriver;

public class CommonMethods extends CorePage {
     WebDriver driver;

    public CommonMethods(WebDriver driver) {
        super(driver);
    }

    public static void invokeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
        driver.navigate().to(ConfigKey.BaseUrl.getKey());
    }
}
