package diplomTests.testAPI;

import models.ResponseLombokModel;
import models.ResponsePojoModel;
import models.UserLombokModel;
import models.UserPojoModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static diplomTests.specs.ApiSpecs.*;
import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;


public class RequestInTests {
    @Test
    @DisplayName("Получение информации о пользователе")
    void singleUserTest() {
        given()
                .spec(testRequestSpec)
                .when()
                .get("/users/7")
                .then()
                .spec(testResponseSpec200)
                .body("data.first_name", is("Michael"))
                .body("data.last_name", is("Lawson"));
    }


    @Test
    @DisplayName("Пользователь не найден")
    void userNotFoundTest() {

        given()
                .spec(testRequestSpec)
                .when()
                .get("/users/45")
                .then()
                .spec(testResponseSpec404);
    }

    @Test
    @DisplayName("Создание нового пользователя")
    void createUserTest() {
        UserPojoModel body = new UserPojoModel();
        body.setName("Jack");
        body.setJob("teacher");
        ResponsePojoModel response = given()
                .spec(testRequestSpec)
                .body(body)
                .when()
                .post("/users")
                .then()
                .spec(testResponseSpec201)
                .extract()
                .as(ResponsePojoModel.class);
        Assertions.assertEquals("Jack", response.getName());
    }

    @Disabled
    @Test
    @DisplayName("Создание пустого пользователя" +
            "Тут я ожидала, что возникнет какая-нибудь ошибка, но пустой пользователь сохранился." +
            "Думаю это полезный тест, чтобы понять, что в базу сохраняются пустые пользователи, " +
            "и нужно это исправлять")
    void createEmptyUserTest() {
        String body = "{}";
        given()
                .spec(testRequestSpec)
                .body(body)
                .when()
                .post("/users")
                .then()
                .spec(testResponseSpec400);
    }

    @Test
    @DisplayName("Изменение существующего пользователя")
    void changeUserTest() {
        UserLombokModel body1 = new UserLombokModel();
        UserLombokModel body2 = new UserLombokModel();
        body1.setName1("Jack");
        body1.setJob1("teacher");
        body2.setName2("Jim");
        body2.setJob2("driver");
        ResponseLombokModel response = given()
                .spec(testRequestSpec)
                .body(body1)
                .when()
                .post("/users")
                .then()
                .spec(testResponseSpec201)
                .extract()
                .as(ResponseLombokModel.class);
        assertThat(response.getName1()).isEqualTo(body1.getName1());
        assertThat(response.getJob1()).isEqualTo(body1.getJob1());
        ResponseLombokModel response2 = given()
                .spec(testRequestSpec)
                .body(body2)
                .when()
                .put("/user/" + response.getId())
                .then()
                .spec(testResponseSpec200)
                .extract()
                .as(ResponseLombokModel.class);
        assertThat(response2.getName2()).isEqualTo(body2.getName2());
        assertThat(response2.getJob2()).isEqualTo(body2.getJob2());
    }

    @Test
    @DisplayName("Удаление пользователя")
    void deleteUserTest() {
        UserPojoModel body = new UserPojoModel();
        body.setName("Jack");
        body.setJob("teacher");
        ResponsePojoModel response = given()
                .spec(testRequestSpec)
                .body(body)
                .when()
                .post("/users")
                .then()
                .spec(testResponseSpec201)
                .extract()
                .as(ResponsePojoModel.class);
        given()
                .spec(testRequestSpec)
                .when()
                .delete("/users/" + response.getId())
                .then()
                .spec(testResponseSpec204);
        given()
                .spec(testRequestSpec)
                .when()
                .get("/users/" + response.getId())
                .then()
                .spec(testResponseSpec404);
    }

}