package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTestWithComments {

    @BeforeAll
    static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Устанавливаем стратегию EAGER

        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;   // держит браузер открытым
    }


    @Test
    void autoTest() {
        String firstName = "Alex";
        String lastName = "Arut";
        String userEmail = "alex@gmail.com";
        String userNumber = "1234567890";

        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()"); // удаляет юаннер. селеинд выполнит код в консоле браузера ремове
        executeJavaScript("$('footer').remove()"); // удаляет футера

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click(); // хорошой способ; $$(".custom-radio").get(1).click(); // плохой способ0
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");    // selectOption("August") выбирает месяц
        $(".react-datepicker__year-select").selectOption("1986");    // selectOption("2020") выбирает год")
        $("#userNumber").setValue(userNumber);
        //$(".react-datepicker__day--008").click();  // если 1 дата видна в календаре
        $(".react-datepicker__day--030:not(.react-datepicker__day--day--outside-month)").click(); // если 2 даты видны в календаре
        $("#subjectsInput").setValue("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click(); // хорошой способ;
//        $("[for='hobbies-checkbox-1']").click();    // плохой способ
//        $("#uploadPicture").uploadFile(new File("src\test\java\resources\1.png")); // 1 способ
        $("#uploadPicture").uploadFromClasspath("img/1.png"); // 2 сп. путь нужно прям скопировать в в ввиде img/1.png"
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear); // проверка наличия модального окна
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber));
    }
}
