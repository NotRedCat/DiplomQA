package diplomTests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class SocialMediaPage {
    public SocialMediaPage openVk() {
        $(".social__vkontakte").click();
        switchTo().window(1);
        return this;
    }

    public SocialMediaPage checkingGoToVkDnsPage() {
        $(".page_name").shouldHave(text("Сеть магазинов DNS"));
        return this;
    }
}
