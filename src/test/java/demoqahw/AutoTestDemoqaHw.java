package demoqahw;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutoTestDemoqaHw {

    @BeforeAll
    static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Устанавливаем стратегию EAGER

        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
}


    @Test
    void autoTest() {
        String firstName = "Alex";
        String lastName = "Arut";
        String userEmail = "alex@gmail.com";

        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $$(".custom-radio").get(1).click();
        $("#userNumber").setValue("1234567890");
//        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
//        $("#dateOfBirthInput").sendKeys(Keys.DELETE);
//        $("#dateOfBirthInput").setValue("19 Dec 1996");
//        $(".subjects-auto-complete__placeholder css-1wa3eu0-placeholder").click();
        $("#subjectsInput").setValue("m").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        sleep(4000);

        $("#closeLargeModal").click();


        // col-md-9 col-sm-12  subjects-auto-complete__value-container subjects-auto-complete__placeholder css-1wa3eu0-placeholder

        sleep(8000);


    }
}
