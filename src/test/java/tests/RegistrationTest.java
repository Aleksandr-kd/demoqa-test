package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void autoTest() {
        String firstName = "Alex";
        String lastName = "Arut";
        String userEmail = "alex@gmail.com";
        String userNumber = "1234567890";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setFirstName(firstName)
                .setLastName()
                .setEmail(userEmail)
                .setGender("Male")
                .setPhone("1234567890");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1986");

        $(".react-datepicker__day--030:not(.react-datepicker__day--day--outside-month)").click();
        $("#subjectsInput").setValue("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber));
    }

    @Test
    void autoTest1() {
        String firstName = "Alex";
        String lastName = "Arut";
        String userEmail = "alex@gmail.com";
        String userNumber = "1234567890";

        registrationPage.openPage();

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName();
        registrationPage.setEmail(userEmail);
        registrationPage.setGender("Male");
        registrationPage.setPhone("1234567890");


        $("#dateOfBirthInput").click();
        // ...
    }

}