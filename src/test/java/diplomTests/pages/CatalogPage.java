package diplomTests.pages;

import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {
    public CatalogPage openSection() {
        open("/catalog/17aa280216404e77/akkumulyatory-dlya-elektroinstrumentov/");
        return this;
    }
}
