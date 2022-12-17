package diplomTests.testsUI;

import diplomTests.pages.MainPage;
import diplomTests.pages.SocialMediaPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ShareButtonTests {
    MainPage mainPage = new MainPage();
    SocialMediaPage socialMediaPage = new SocialMediaPage();

    @Test
    @DisplayName("Проверка, что при переходе в ВК, открывается официальная страница DNS")
    void checkTheTransitionToVk() {
        step("Открытие главной страницы", () ->
                mainPage.openMainPage());
        step("Переход в ВК", () ->
                socialMediaPage.openVk());
        step("Проверка, что открылась официальная страница DNS", () ->
                socialMediaPage.checkingGoToVkDnsPage());
    }
}
