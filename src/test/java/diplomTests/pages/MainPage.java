package diplomTests.pages;

import com.codeborne.selenide.CollectionCondition;
import diplomTests.config.DriverConfig;
import diplomTests.testsUI.TestBase;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainPage extends TestBase {
    private final static String TITLE_TEXT = "Актуальные предложения";

    DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

    public MainPage openMainPage() {
        open(config.getBaseUrl());
        $(".homepage-actual-offers-main__title").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public MainPage searchInvalidModelName() {
        $("#header-search input").hover().click();
        $("#header-search input").setValue("Sumsang");
        return this;
    }

    public MainPage listNoEmpty() {
        $$(".suggests.presearch__suggests a").shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public MainPage clickOnTheLogo() {
        $("#header-logo").click();
        return this;
    }

    public MainPage checkingGoToMainPage() {
        $(".homepage-actual-offers-main__title").shouldHave(text("Актуальные предложения"));
        return this;
    }


}
