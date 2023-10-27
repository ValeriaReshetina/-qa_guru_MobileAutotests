package guru.qa.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class AndroidSearchTests extends TestBase {
    @Test
    @Tag("android")
    @DisplayName("Checking search in Wikipedia")
    void successfulWikiSearchTest() {

        step("Click on the search input", () -> {
            $(accessibilityId("Search Wikipedia")).click();
        });

        step("Type in the search input Depeche Mode", () -> {
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Depeche Mode");
        });

        step("Checking for content in search results", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Open item from a search result", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container")).first().click());

        step("Checking for error in text", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible);
        });
    }
}
