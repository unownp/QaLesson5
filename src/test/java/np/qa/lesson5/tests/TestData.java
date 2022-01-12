package np.qa.lesson5.tests;

import com.github.javafaker.Faker;

public class TestData {

    private static Faker fakeData = new Faker();

    public static String firstName = fakeData.name().firstName(),
            lastName = fakeData.name().lastName(),
            email = fakeData.internet().emailAddress(),
            address = fakeData.address().fullAddress(),
            number = fakeData.phoneNumber().subscriberNumber(10);

}