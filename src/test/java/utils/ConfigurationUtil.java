package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

 public class ConfigurationUtil {

   @BeforeMethod
    public static void setupBrowser() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
        Configuration.clickViaJs = false;
    }

    @AfterMethod(alwaysRun = true)
    public static void closeBrowser() {
        getWebDriver().quit();
    }

    public static void getConfigurations() {
       setupBrowser();
       closeBrowser();
    }
}
