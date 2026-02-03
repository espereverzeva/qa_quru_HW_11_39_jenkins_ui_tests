package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static io.qameta.allure.Allure.step;

@Story("Registration form")
public class RegistrationWithPageObjectTests extends TestBase {



    @Test
    @DisplayName("Successful Registration")
    void fillFormTest() {
        step("Open registration page", () ->
                registrationPage.openPage());
        step("Fill registration form", () -> {
            registrationPage
                    .removeBanner()
                    .setFirstName("Anna")
                    .setLastName("Big")
                    .setEmaiName("Big@mai.ru")
                    .setGender("Female")
                    .setNumberName("9638527441")
                    .setDateOfBirth("19", "March", "1991")
                    .setSubject("Chemistry")
                    .setHobbies("Sports")
                    .setUploadPicture("zxc.png")
                    .setCurrentAddress("Russia, Novosibirsk")
                    .setState("Haryana")
                    .setCity("Karnal")
                    .setSubmit();
        });
        step("Check registration form results data", () -> {

                registrationPage
                .checkResult("Student Name", "Anna Big")
                .checkResult("Student Email", "Big@mai.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9638527441")
                .checkResult("Date of Birth", "19 March,1991")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "zxc.png")
                .checkResult("Address", "Russia, Novosibirsk")
                .checkResult("State and City", "Haryana Karnal")
                .closeModal();
            });
        }
    @Test
    @DisplayName("Broken Registration")
    void brokenRegistrationTest() {
        step("Open registration page", () ->
                registrationPage.openPage());
        step("Fill registration form", () -> {
            registrationPage
                    .removeBanner()
                    .setFirstName("Anna")
                    .setLastName("Big")
                    .setEmaiName("Big@mai.ru")
                    .setGender("Female")
                    .setNumberName("9638527441")
                    .setSubmit();
        });

        step("Check registration form results data", () -> {

            registrationPage
                    .checkResult("Student Name", "Anna Big")
                    .checkResult("Student Email", "B1111ig@mai.ru")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "9638527441")
                    .closeModal();
        });
    }
}

