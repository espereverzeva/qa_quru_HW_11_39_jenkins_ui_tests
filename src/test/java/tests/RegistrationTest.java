package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.pageLoadStrategy = "eager";
        //Configuration.browserVersion = "128.0";
        //Configuration.browserVersion = "130.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Big");
        $("#userEmail").setValue("Big@mai.ru");
        //Gender
        //$("[for=gender-radio-2]").click();
        $("#genterWrapper").$(byText("Female")).click();
        //Mobile
        $("#userNumber").setValue("89638527441");
        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__month").$(byText("19")).click();
        //Subjects
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //Picture
        $("#uploadPicture").uploadFromClasspath("zxc.png");
        //Current Address
        $("#currentAddress").setValue("Russia, Novosibirsk");
        //State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        //$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        //$(byText("Karnal")).click();

        $("#submit").click();


        $(".table-responsive").shouldHave(text("Anna Big"));
        $(".table-responsive").shouldHave(text("Big@mai.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8963852744"));
        $(".table-responsive").shouldHave(text("19 March,1991"));
        $(".table-responsive").shouldHave(text("Chemistry"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("zxc.png"));
        $(".table-responsive").shouldHave(text("Russia, Novosibirsk"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}