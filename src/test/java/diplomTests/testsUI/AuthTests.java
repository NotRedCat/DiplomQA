package diplomTests.testsUI;

import diplomTests.pages.AuthPage;
import diplomTests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static diplomTests.testsUI.TestData.email;
import static diplomTests.testsUI.TestData.errAuthText;
import static io.qameta.allure.Allure.step;

public class AuthTests extends TestBase {
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка, что при авториции с неверными емейлом, возникает ошибка")
    void checkAuthWithWrongEmail() {

        step("Переход к форме авторизации", () ->
        {
            mainPage.openMainPage();
            authPage.goToAuth();
        });
        step("Ввод некорректного емайла", () ->
                authPage.setEmail(email));
        step("Проверка, что появилось сообщение об ошибке", () ->
                authPage.checkingAuthError(errAuthText));
    }
}
