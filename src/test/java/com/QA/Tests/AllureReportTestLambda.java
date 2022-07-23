package com.QA.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class AllureReportTestLambda {

    //@BeforeAll
    //static void browserOpen () {Configuration.holdBrowserOpen = true;}
    private static final String REPOSITORY = "FazlyevVadim/Selenide_StepByStep";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testGitHubWithLambda() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу пользователя", () -> {
            open("https://github.com");     // Это лямбда, у нее 1 метод |void run() trows|
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем, что существует Issue с номером" + ISSUE_NUMBER, () -> {
            $(withText("#1")).should(Condition.visible);
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы Лямбда",
                    "text/html",
                    "html",
                    WebDriverRunner.getAndCheckWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
