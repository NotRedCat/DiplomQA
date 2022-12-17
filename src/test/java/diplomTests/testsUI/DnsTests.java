package diplomTests.testsUI;

import com.codeborne.selenide.Configuration;
import diplomTests.config.DriverConfig;
import diplomTests.pages.MainPage;
import org.aeonbits.owner.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.management.DescriptorRead;
import java.util.stream.Stream;

import static diplomTests.testsUI.TestData.*;
import static io.qameta.allure.Allure.step;

public class DnsTests extends TestBase {

    MainPage mainPage = new MainPage();
    @Test
    @DisplayName("Проверка, что при добавлении товара в избранное, счётчик меняется")
    void checkAddProductToWishlist() {
        step("Проверка, что в избранном пусто", () ->
                mainPage
                        .openWishList()
                        .checkWishlistIsEmpty());
        step("Добавление товара в избранное", () ->
                mainPage.addProductInWishlist());
        step("Проверка, что в избранном появился товар", () ->
                mainPage.checkWishlistIsNotEmpty());
    }

    @Test
    @DisplayName("Проверка, что при авторизии с неверными емейлом, возникает ошибка")
    void checkAuthWithWrongEmail() {
        step("Переход к форме авторизации", () ->
                mainPage.openMainPage()
                        .goToAuth());
        step("Ввод некорректного емайла", () ->
                mainPage.setEmail());
        step("Проверка, что появилось сообщение об ошибке", () ->
                mainPage.checkingAuthError());
    }

    @Test
    @DisplayName("Проверка, что в разделе о компании есть текст")
    void aboutCompanyShouldHaveText() {
        step("Открытие страницы 'О компании'", () ->
                mainPage.openAboutCompany());
        step("Проверка, что на странице есть текст", () ->
                mainPage.checkingAboutCompanyNoEmpty());
    }

    @Test
    @DisplayName("Проверка умного поиска")
    void checkSmartSearch() {
        step("Открытие главной страницы", () ->
                mainPage.openMainPage());
        step("Поиск по названию с ошибками", () ->
                mainPage.searchInvalidModelName());
        step("Результатов поиска больше нуля", () ->
                mainPage.listNoEmpty());
    }

    @Test
    @DisplayName("Проверка, что при клике на логотип, открывается начальная страница")
    void checkClickLogo() {
        step("Открытие раздела", () ->
                mainPage.openSection());
        step("Нажатие на логотип", () ->
                mainPage.clickOnTheLogo());
        step("Проверка, что произошел переход на главную страницы", () ->
                mainPage.checkingGoToMainPage());
    }

    @Test
    @DisplayName("Проверка, что при переходе в ВК, открывается официальная страница DNS")
    void checkTheTransitionToVk() {
        step("Открытие главной страницы", () ->
                mainPage.openMainPage());
        step("Переход в ВК", () ->
                mainPage.openVk());
        step("Проверка, что открылась официальная страница DNS", () ->
                mainPage.checkingGoToVkDnsPage());

    }
}

