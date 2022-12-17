package diplomTests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WishlistPage {
    public WishlistPage openWishList() {
        open("/profile/wishlist/");
        return this;
    }

    public WishlistPage checkWishlistIsEmpty(String text) {
        $(".profile-wishlist__empty-text").shouldHave(text(text));
        return this;
    }

    public WishlistPage addProductInWishlist() {
        open("/catalog/17a8a05316404e77/planshety/");
        sleep(1500);
        $(".wishlist-btn").hover().click();
        return this;
    }

    public WishlistPage checkWishlistIsNotEmpty() {
        $(".wishlist-link-counter__badge").shouldHave(text("1"));
        return this;
    }
}
