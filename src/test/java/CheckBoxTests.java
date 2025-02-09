import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void checkBoxParentTests() {
        open("/checkbox");
        $("[for=tree-node-home]").click();

        $("#result").shouldHave(text("home"));
    }

    @Test
    void checkBoxChildLevelTests() {
        open("/checkbox");
        $(".rct-collapse-btn").click();
        $("[for=tree-node-documents]").click();

        $("#result").shouldHave(text("documents")).shouldNotHave(text("home"));
    }

    @Test
    void checkBoxLastChildTests() {
        open("/checkbox");
        $(".rct-collapse-btn").click();
        $(".rct-collapse-btn", 3).click();
        $("[for=tree-node-excelFile]").click();

        $("#result").shouldHave(text("excelFile")).shouldNotHave(text("downloads"))
                .shouldNotHave(text("home"));
    }


}
