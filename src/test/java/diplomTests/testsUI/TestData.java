package diplomTests.testsUI;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();
    public static String
            invalidEmail = faker.name().firstName(),
            errAuthText = "E-mail/телефон указан неверно",
            aboutCompanyText = "DNS – один из лидеров рынка по продаже цифровой и бытовой техники в России";


}

