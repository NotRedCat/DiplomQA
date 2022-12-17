package diplomTests.testsUI;

import diplomTests.pages.CatalogPage;
import diplomTests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    @Test
    @DisplayName("Проверка, что при клике на логотип, открывается начальная страница")
    void checkClickLogo() {
        step("Открытие раздела", () ->
                catalogPage.openSection());
        step("Нажатие на логотип", () ->
                mainPage.clickOnTheLogo());
        step("Проверка, что произошел переход на главную страницы", () ->
                mainPage.checkingGoToMainPage());
    }
}

