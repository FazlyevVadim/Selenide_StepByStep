package com.QA.Tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Selenide_1GitHubTest {

    @Test
    void ShouldFindSelenideAsFirstRepository() {
        open("https://github.com");
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h2").shouldNotHave(Condition.text("selenide / selenide"));
    }
}
//Arrange - подготовка  - Given
//Act - действие        - When
//Assert - проверка     - Then