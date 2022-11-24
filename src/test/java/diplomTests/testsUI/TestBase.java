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
        String properties = System.getProperty("properties");
        if (properties.equals("remote")) {
            System.setProperty("properties", "remote");
            DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

            if (config != null) {
                Configuration.remote = config.getRemoteURL();
            }
            capabilities.setCapability("browserName", config.getBrowser());
            capabilities.setCapability("baseURI", config.getBaseURI());
            Configuration.browserSize = config.getBrowserSize();
            Configuration.baseUrl = config.getBaseUrl();
            Configuration.browserVersion = config.getBrowserVersion();
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