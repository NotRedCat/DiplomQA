package diplomTests.testsUI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import diplomTests.config.DriverConfig;
import diplomTests.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.Map;


public class TestBase {

    @BeforeAll
    static void configure() throws MalformedURLException {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

        String properties = System.getProperty("properties");
        if (properties.equals("remote"))
        {
            Configuration.browser = System.getProperty("browser_name");
            Configuration.browserVersion = System.getProperty("browser_version");
            Configuration.browserSize = System.getProperty("browser_size");
            Configuration.remote = config.getRemoteURL();
        }
        if (properties.equals("local"))
    {
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();

        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}