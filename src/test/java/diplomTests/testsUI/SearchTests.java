package diplomTests.testsUI;

import diplomTests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    MainPage mainPage = new MainPage();

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
}
