import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    @Test
    void SelenideTest() {

        Selenide.open("https://github.com/");
        $("[data-test-selector=nav-search-input]")
                .setValue("selenide")
                .pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h2").shouldHave(text("selenide / selenide"));
        $("ul.UnderlineNav-body").$("#wiki-tab").click();
        $(".filter-bar").$("#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").shouldHave(exactText("SoftAssertions"));
        $(".filterable-active").click();
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:"))
                .scrollTo()
                .$(".anchor").hover();



    }
}
