package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResponsive;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailNameInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),
            closeModal = $("#closeLargeModal");


    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponsive tableResponsive = new TableResponsive();

    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("Remove banner")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }
    @Step("Type first name \"{value}\"")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Type last name \"{value}\"")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Type email \"{value}\"")
    public RegistrationPage setEmaiName(String value) {
        emailNameInput.setValue(value);
        return this;

    }

    @Step("Type gender \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Type number \"{value}\"")
    public RegistrationPage setNumberName(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Type calendar \"{day, month, year}\"")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Type subjects \"{value}\"")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Type hobbies \"{value}\"")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Type picture \"{value}\"")
    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Type current \"{value}\"")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Type state \"{value}\"")
    public RegistrationPage setState(String value) {
        state.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Type city \"{value}\"")
    public RegistrationPage setCity(String value) {
        city.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Submit click")
    public RegistrationPage setSubmit() {
        submit.click();
        return this;
    }

    @Step("Table responsive")
    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.setTable(key, value);
        return this;
    }
    @Step("Close Modal")
    public RegistrationPage closeModal() {
        closeModal.click();
        return this;
    }

}