package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsive {
    private final SelenideElement tableResponsiveInput = $(".table-responsive");

    @Step("Check that field \"{key}\" has result \"{value}\"")
    public void setTable (String key, String value){
        tableResponsiveInput.$(byText(key)).parent().shouldHave(text(value));
    }
}
