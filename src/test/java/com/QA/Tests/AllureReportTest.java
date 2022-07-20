package com.QA.Tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


public class AllureReportTest {
    @Test
    public void testGitHub() {


        open("https://github.com");

        $("").click();
        $("").sendKeys("");
        $("").click();

        $(linkText("")).click();
        $(partialLinkText("")).click();
        $(withText("")).click();
    }

}
