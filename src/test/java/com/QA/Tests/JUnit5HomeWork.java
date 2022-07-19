package com.QA.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JUnit5HomeWork {

    @BeforeAll
    static void openChromePetrovich() {
        Configuration.holdBrowserOpen = true;
    }
    @DisplayName("Петрович поисковик")
    @Test
    void homeWorkPetrovich() {

        Selenide.open("https://petrovich.ru/");

        $(".header-search-input").setValue("Саморез").pressEnter();

        $$(".details").find(Condition.text("Саморезы кровельные с буром")).shouldBe(visible);
    }

    @ValueSource(strings = {
            "Саморез",
            "Брус"
    })
    @ParameterizedTest(name = "Петрович тест с {0}")
    void homeWorkPetrovichParametrizedTest(String testData) {

        Selenide.open("https://petrovich.ru/");

        $(".header-search-input").setValue(testData).pressEnter();

        $$(".details")
                .find(Condition.text(testData))
                .shouldBe(visible);
    }
    @CsvSource({
            "Саморез, Саморезы кровельные с буром",
            "Брус, Брус сухой строганый"
    })
    @ParameterizedTest(name = "Петрович тест с параметрами {0}, результат {1}")
    void homeWorkPetrovichParametrizedHardTest(String testData, String expectedResult) {

        Selenide.open("https://petrovich.ru/");

        $(".header-search-input").setValue(testData).pressEnter();

        $$(".details")
                .find(Condition.text(expectedResult))
                .shouldBe(visible);
    }
}


