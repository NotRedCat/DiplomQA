package diplomTests.testsUI;

import diplomTests.pages.WishlistPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class WishlistTests extends TestBase {
    WishlistPage wishlistPage = new WishlistPage();

    @Test
    @DisplayName("Проверка, что при добавлении товара в избранное, счётчик меняется")
    void checkAddProductToWishlist() {
        step("Проверка, что в избранном пусто", () ->
                wishlistPage
                        .openWishList()
                        .checkWishlistIsEmpty(emptyWishlistText));
        step("Добавление товара в избранное", () ->
                wishlistPage.addProductInWishlist());
        step("Проверка, что в избранном появился товар", () ->
                wishlistPage.checkWishlistIsNotEmpty());
    }

}
