package diplomTests.testsUI;

import diplomTests.pages.CompanyInfoPage;
import diplomTests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CompanyInfoTests extends TestBase {

    CompanyInfoPage companyInfoPage = new CompanyInfoPage();

    @Test
    @DisplayName("Проверка, что в разделе о компании есть текст")
    void aboutCompanyShouldHaveText() {
        step("Открытие страницы 'О компании'", () ->
                companyInfoPage.openAboutCompany());
        step("Проверка, что на странице есть текст", () ->
                companyInfoPage.checkingAboutCompanyNoEmpty());
    }
}
