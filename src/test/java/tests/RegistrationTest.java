package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest extends TestBase{

    @Test
    void autoTest() {
        String firstName = "Alex";
        String lastName = "Arut";
        String userEmail = "alex@gmail.com";
        String userNumber = "1234567890";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName()
                .setEmail(userEmail)
                .setGender("Male")
                .setPhone("1234567890")
                .setBirthDate("30","April","2024");


        $("#subjectsInput").setValue("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultModalAppers()
                .verifyResult("Student Name", firstName + " Arut")
                .verifyResult("Student Email", "alex@gmail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890");
//                .verifyResult("Date of birth", "30 April,2024");


        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber));
    }

    @Test
    void autoTest1() {
        String firstName = "Alex";
        String userEmail = "alex@gmail.com";

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