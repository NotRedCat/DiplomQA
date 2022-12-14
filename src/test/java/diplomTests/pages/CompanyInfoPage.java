package diplomTests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CompanyInfoPage {
    public CompanyInfoPage openAboutCompany() {
        open("/about/about/");
        return this;
    }

    public CompanyInfoPage checkingAboutCompanyNoEmpty(String aboutCompanyText) {
        $(".about-dns__top-title")
                .shouldHave(text(aboutCompanyText));
        return this;
    }

}
