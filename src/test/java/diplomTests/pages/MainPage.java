package diplomTests.pages;

import com.codeborne.selenide.CollectionCondition;
import diplomTests.testsUI.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static diplomTests.testsUI.TestData.email;
import static diplomTests.testsUI.TestData.errAuthText;

public class MainPage extends TestBase {

    private final static String TITLE_TEXT = "Актуальные предложения";


    public MainPage openMainPage() {
        open("https://www.dns-shop.ru");
        $(".homepage-actual-offers-main__title").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('.v-confirm-city').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public MainPage openWishList() {
        open("/profile/wishlist/");
        return this;
    }

    public MainPage clickWishlist() {
        $(".wishlist-link__lbl").click();
        return this;
    }

    public MainPage checkWishlistIsEmpty() {
        String emptyWishlistText = "В списке пока нет ни одного избранного товара";
        $(".profile-wishlist__empty-text").shouldHave(text(emptyWishlistText));
        return this;
    }

    public MainPage addProductInWishlist() {
        open("https://www.dns-shop.ru/catalog/17a8a05316404e77/planshety/");
        $$(".catalog-product__name").first().click();
        $$(".wishlist-btn").first().click();
        return this;
    }

    public MainPage checkWishlistIsNotEmpty() {
        $(".wishlist-link__badge").shouldHave(text("1"));
        return this;
    }

    public MainPage goToAuth() {
        $(".user-profile__login").click();
        $(".user-profile__login-icon").hover();
        $(".user-profile__wrapper button").click();
        return this;
    }

    public MainPage setEmail() {
        $(".auth-modal input").click();
        $(".auth-modal input").sendKeys(email);
        $$(".auth-modal button").find(text("Получить код")).click();
        return this;
    }

    public MainPage checkingAuthError() {
        $(".error-message-block").shouldHave(text(errAuthText));
        return this;
    }

    public MainPage openAboutCompany() {
        open("https://www.dns-shop.ru/about/about/");
        return this;
    }

    public MainPage checkingAboutCompanyNoEmpty() {
        $(".about-dns__top-title")
                .shouldHave(text("DNS – один из лидеров рынка по продаже цифровой и бытовой техники в России"));
        return this;
    }

    public MainPage searchInvalidModelName() {
        $("#header-search input").hover().click();
        $("#header-search input").setValue("Sumsang");
        return this;
    }

    public MainPage listNoEmpty() {
        $$(".ui-input-search a").shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public MainPage openSection() {
        open("https://www.dns-shop.ru/catalog/17aa280216404e77/akkumulyatory-dlya-elektroinstrumentov/");
        executeJavaScript("$('.v-confirm-city').remove()");
        return this;
    }

    public MainPage clickOnTheLogo() {
        $(".logo").click();
        return this;
    }

    public MainPage checkingGoToMainPage() {
        $(".homepage-actual-offers-main__title").shouldHave(text("Актуальные предложения"));
        return this;
    }

    public MainPage openVk() {
        $(".social__vkontakte").click();
        switchTo().window(1);
        return this;
    }

    public MainPage checkingGoToVkDnsPage() {
        $(".page_name").shouldHave(text("Сеть магазинов DNS"));
        return this;
    }
}