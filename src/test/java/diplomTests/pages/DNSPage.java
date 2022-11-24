package diplomTests.pages;

import diplomTests.testsUI.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DNSPage extends TestBase {

    private final static String TITLE_TEXT = "Актуальные предложения";



    public DNSPage openMainPage() {
        open("https://www.dns-shop.ru");
        $(".homepage-actual-offers-main__title").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('.v-confirm-city').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public DNSPage openWishList() {
        open("https://www.dns-shop.ru/profile/wishlist/");
        return this;
    }
    public DNSPage clickWishlist() {
        $(".wishlist-link__lbl").click();
        return this;
    }
    public DNSPage checkWishlistIsEmpty() {
        String emptyWishlistText = "В списке пока нет ни одного избранного товара";
        $(".profile-wishlist__empty-text").shouldHave(text(emptyWishlistText));
        return this;
    }
    public DNSPage addProductInWishlist() {
        open("https://www.dns-shop.ru/catalog/17a8a05316404e77/planshety/");
        $$(".catalog-product__name").first().click();
        $$(".wishlist-btn").first().click();
        return this;
    }
    public DNSPage checkWishlistIsNotEmpty() {
        $(".wishlist-link__badge").shouldHave(text("1"));
        return this;
    }

}
