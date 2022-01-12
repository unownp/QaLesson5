package np.qa.lesson5.pages.components;

import com.codeborne.selenide.SelenideElement;
import np.qa.lesson5.pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class FixedBanComponent {
    SelenideElement closingFixedBanButton=$("#close-fixedban");
    public FixedBanComponent closeFixedBan() {
        closingFixedBanButton.click();
        return this;
    }
}
