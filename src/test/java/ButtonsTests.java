import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ButtonsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void buttonsTests() {
        open("/buttons");
        $("#doubleClickBtn").click();
        $("#rightClickBtn").click();
        $("#Iew3M").click();

        $("#doubleClickMessage").scrollIntoView(true).shouldHave(text("You have done a double click"));
        $("#rightClickMessage").scrollIntoView(true).shouldHave(text("You have done a right click"));
        $("#dynamicClickMessage").scrollIntoView(true).shouldHave(text("You have done a dynamic click"));
    }

}
