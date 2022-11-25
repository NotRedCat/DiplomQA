package diplomTests.testsUI;

import com.codeborne.selenide.CollectionCondition;
import diplomTests.pages.DNSPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static diplomTests.testsUI.TestData.noEmail;
import static io.qameta.allure.Allure.step;

public class DnsTests {

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
        step("Переход к форме авторизации", () ->
                mainPage.openMainPage()
                        .goToAuth());

        step("Ввод некорректного емайла", () ->
                mainPage.enterInvalidEmail());

        step("Проверка, что появилось сообщение об ошибке", () ->
                mainPage.checkingAuthError());
    }

    @Test
    void aboutCompanyShouldHaveText() {
        step("Открытие страницы 'О компании'", () ->
                mainPage.openAboutCompany());

        step("Проверка, что на странице есть текст", () ->
                mainPage.checkingAboutCompanyNoEmpty());
    }

    @Test
    void checkSmartSearch() {
        step("Открытие главной страницы", () ->
        mainPage.openMainPage());
        step("Поиск по названию с ошибками", () ->
        mainPage.searchInvalidModelName());
        step("Результатов поиска больше нуля", () ->
        mainPage.listNoEmpty());
    }

    @Test
    void checkClickLogo() {
        step("Открытие раздела", () ->
        mainPage.openSection());
        step("Нажатие на логотип", () ->
        mainPage.clickOnTheLogo());
        step("Переход на главную страницы'", () ->
        mainPage.checkingGoToMainPage());
    }

    @Test
    void checkTheTransitionToVk() {
        step("Открытие главной страницы", () ->
        mainPage.openMainPage());

        step("Переход в ВК", () ->
        mainPage.openVk());

        step("Проверка, что открылась официальная страница DNS", () ->
        mainPage.checkingGoToVkDnsPage());

    }
}

