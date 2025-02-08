import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        // не ждать полной загрузки страницы
        Configuration.pageLoadStrategy = "eager";
        // не закрывать браузер после теста
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulFillFromTests () {
        open("/text-box");
        $("#userName").setValue("Alex");
        // 2 вариант той же записи
        $("[id=userEmail]").setValue("fully@mail.com");
        // 3 вариант той же записи
        $(by("id", "currentAddress")).setValue("Street 1");
        // 4 вариант той же записи (есть еще byName, byText, withText
        $(byId("permanentAddress")).setValue("Town 1 Street 2");
        // пролистываем до элемента, чтобы был виден
        $("#submit").scrollIntoView(true).click();

        $("#output").$("#name").shouldHave(text("Alex"));
        //  вариант той же записи
        $("#output #email").shouldHave(text("fully@mail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Street 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Town 1 Street 2"));
    }




}
