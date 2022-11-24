package diplomTests.testsUI;

import com.codeborne.selenide.CollectionCondition;
import diplomTests.pages.DNSPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static diplomTests.testsUI.TestData.noEmail;
import static io.qameta.allure.Allure.step;

public class DnsTests{

    DNSPage mainPage = new DNSPage();

    @Test
    void checkAddProductToWishlist() {

        step("Проверка, что в избранном пусто", () ->
                mainPage
                .openWishList()
                .checkWishlistIsEmpty());
        step("Добавление товара в избранное", () ->
        mainPage
                .addProductInWishlist());
                step("Проверка, что в избранном появился товар", () ->
        mainPage
                .checkWishlistIsNotEmpty());
    }

    @Test
    void checkAuthWithWrongEmail() {
        mainPage.openMainPage();
        $(".user-profile__login").click();
        $(".user-profile__login-icon").hover();
        $(".user-profile__wrapper button").click();
        $(".auth-modal input").click();
        $(".auth-modal input").sendKeys(noEmail);
        $$(".auth-modal button").find(text("Получить код")).click();
        $(".error-message-block").shouldHave(text("E-mail/телефон указан неверно"));
    }

    @Test
    void aboutCompanyShouldHaveText() {
        open("https://www.dns-shop.ru/about/about/");
        $(".about-dns__top-title")
                .shouldHave(text("DNS – один из лидеров рынка по продаже цифровой и бытовой техники в России"));
    }

    @Test
    void checkSmartSearch() {
        mainPage.openMainPage();
        $("#header-search input").hover().click();
        $("#header-search input").setValue("Sumsang");
        $$(".ui-input-search a").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    void checkClickLogo() {
        open("https://www.dns-shop.ru/catalog/17aa280216404e77/akkumulyatory-dlya-elektroinstrumentov/");
        executeJavaScript("$('.v-confirm-city').remove()");
        $(".logo").click();
        $(".homepage-actual-offers-main__title").shouldHave(text("Актуальные предложения"));
    }

    @Test
    void checkTheTransitionToVk() {
        mainPage.openMainPage();
        $(".social__vkontakte").click();
        switchTo().window(1);
        $(".page_name").shouldHave(text("Сеть магазинов DNS"));
    }
}

