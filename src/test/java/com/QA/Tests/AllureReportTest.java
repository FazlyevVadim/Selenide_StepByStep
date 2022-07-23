package com.QA.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class AllureReportTest {

    @BeforeAll
    static void browserOpen() {
        Configuration.holdBrowserOpen = true;
    }


    @Test
    public void testGitHub() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("FazlyevVadim/Selenide_StepByStep");
        $(".header-search-input").submit();

        $(linkText("FazlyevVadim/Selenide_StepByStep")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.visible);
    }
}
