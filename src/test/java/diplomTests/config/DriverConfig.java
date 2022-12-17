package diplomTests.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${properties}.properties"
})

public interface DriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.dns-shop.ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1500x300")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteURL();

    @Key("baseURI")
    @DefaultValue("https://reqres.in/api/")
    String getBaseURI();

}
