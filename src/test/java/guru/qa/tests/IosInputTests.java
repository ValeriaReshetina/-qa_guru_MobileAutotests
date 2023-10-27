package guru.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class IosInputTests extends TestBase {
    @Test
    @Tag("ios")
    @DisplayName("Checking text input and display in UI Elements")
    void enterTextTest() {

        step("Click on button Text", () -> {
            $(id("Text Button")).click();
        });

        step("Click on field Enter a text", () -> {
            $(id("Text Input")).click();
        });

        step("Input in field 'Enter a text' text 'I want to learn Java quite good' and press Enter", () -> {
            $(id("Text Input")).sendKeys("I want to learn Java quite good");
            $(id("Text Input")).pressEnter();
        });

        step("Checking the display of the result with the specified text", () -> {
            assertThat($(id("Text Output")).getText())
                    .isEqualTo("I want to learn Java quite good");
        });
    }
}
