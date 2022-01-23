package np.qa.lesson5.tests;

import np.qa.lesson5.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static np.qa.lesson5.tests.TestData.*;

public class AutomationPracticeFormTestWithFaker extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void practiceFormTest() {
        registrationFormPage.openPage()
                .setFirstName((firstName))
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setUserNumber(Integer.parseInt(number))
                .calendarComponent.setDate(1991, "July", 1);

        registrationFormPage.setSubject("Hindi")
                .setHobbies("Sports")
                .uploadFile("src/test/resources/scale_1200.jpg")
                .setAddress(address)
                .setState("Uttar")
                .setCity("Agra");

        $("#submit").click();

        checkTable();

    }

    void checkTable() {
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email),
                text("Male"), text(number),
                text("01 July,1991"),
                text("Hindi"), text("Sports"),
                text("scale_1200.jpg"), text(address),
                text("Uttar Pradesh Agra"));

    }
}
