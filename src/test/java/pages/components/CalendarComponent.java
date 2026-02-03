package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement
            dateInput = $("#dateOfBirthInput"),
            datepickerMonth = $(".react-datepicker__month-select"),
            datepickerYear = $(".react-datepicker__year-select"),
            datepickerDay = $(".react-datepicker__month");

    public void setDate(String day, String month, String year) {
        dateInput.click();
        datepickerMonth.$(byText(month)).click();
        datepickerYear.$(byText(year)).click();
        datepickerDay.$(byText(day)).click();
    }
}
