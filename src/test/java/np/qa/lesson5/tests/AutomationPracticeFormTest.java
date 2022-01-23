package np.qa.lesson5.tests;

import com.codeborne.selenide.Configuration;
import np.qa.lesson5.pages.RegistrationFormPage;
import np.qa.lesson5.pages.components.CalendarComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void practiceFormTest() {
        registrationFormPage.openPage()
                .setFirstName(("Ololo"))
                .setLastName("Pyshpysh")
                .setEmail("realne@chake.com")
                .setGender("Male")
                .setUserNumber(1234567890)
                .calendarComponent.setDate(1991, "July", 1);

        registrationFormPage.setSubject("Hindi")
                .setHobbies("Sports")
                .uploadFile("src/test/resources/scale_1200.jpg")
                .setAddress("voruyubivay")
                .setState("Uttar")
                .setCity("Agra");

        $("#submit").click();

        checkTable();

    }

    void checkTable() {
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Ololo"), text("Pyshpysh"), text("realne@chake.com"),
                text("Male"), text("1234567890"),
                text("01 July,1991"),
                text("Hindi"), text("Sports"),
                text("scale_1200.jpg"), text("voruyubivay"),
                text("Uttar Pradesh Agra"));

    }
}
