package diplomTests.testsUI;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();
    public static String
            email = faker.name().firstName(),
            errAuthText = "E-mail/телефон указан неверно";


}

