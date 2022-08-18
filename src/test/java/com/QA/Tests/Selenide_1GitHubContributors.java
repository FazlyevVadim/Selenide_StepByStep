package com.QA.Tests;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Selenide_1GitHubContributors {

    @Test
    void firstContributorIsSolntsev() {
        open("https://github.com/selenide/se");
        $(".Layout-sidebar").$(Selectors.byText("Contributors"))
    }
}
