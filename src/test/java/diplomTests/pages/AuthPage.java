package diplomTests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class AuthPage {
    public AuthPage goToAuth() {
        $(".user-profile__login").click();
        $(".user-profile__login-icon").hover();
        $(".user-profile__wrapper button").click();
        return this;
    }

    public AuthPage setEmail(String email) {
        $(".auth-modal input").click();
        $(".auth-modal input").sendKeys(email);
        return this;
    }

    public AuthPage checkingAuthError(String errText) {
        $$(".auth-modal button").find(text("Получить код")).click();
        $(".error-message-block").shouldHave(text(errText));
        return this;
    }
}
