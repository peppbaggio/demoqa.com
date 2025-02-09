import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTablesTests {

        @BeforeAll
        static void beforeAll() {
            Configuration.pageLoadStrategy = "eager";
            Configuration.baseUrl = "https://demoqa.com";
        }


        @Test
        void checkBoxParentTests() {
            open("/webtables");
            $("#addNewRecordButton").click();
            $(".modal-content #firstName").setValue("Alex");
            $(".modal-content #lastName").setValue("Groovy");
            $(".modal-content #userEmail").setValue("groovy@mail.ru");
            $(".modal-content #age").setValue("42");
            $(".modal-content #salary").setValue("500");
            $(".modal-content #department").setValue("any");
            $(".modal-content #submit").scrollIntoView(true).click();


            $(".rt-tbody").shouldHave(text("Alex")).scrollIntoView(true).shouldHave(text("Groovy"))
                    .scrollIntoView(true).shouldHave(text("groovy@mail.ru")).scrollIntoView(true)
                    .shouldHave(text("42")).scrollIntoView(true).shouldHave(text("500"))
                    .scrollIntoView(true).shouldHave(text("any"));
        }




}


