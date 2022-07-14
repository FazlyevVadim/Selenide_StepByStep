package com.QA.Tests;

import com.QA.Domain.MenuYandexItems;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JUnit5WEBtest {
    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("first string", List.of(43, 13)),
                Arguments.of("second string", List.of(1, 2))
        );
    }

    //@ValueSource - работа с 1 параметром
    @CsvSource(value = {
            "Selenide| is an open source library for test",
            "JUnit | Support JUnit"
    },
            delimiter = '|'   //меняем разделитель в массиве тестовых данных, по дефолту ЗАПЯТАЯ является разделителем
    )
    @DisplayName("Проверка поиска в ya.ru testData") //название теста
    @ParameterizedTest(name = "Проверка поиска в ya.ru {0}, ожидаем результат: {1} ")
    void yaSearchTest(String testData, String expectedResult) {
        Selenide.open("https://ya.ru"); // предусловие

        $("#text ").setValue(testData); //step 1
        $("button[type='submit']").click();  //step 2

        $$(".serp-item")
                .find(Condition.text(expectedResult))
                .shouldBe(visible);
    }

    @MethodSource("methodSourceExampleTest")
    void methodSourceExampleTest(String first, List<Integer> second) {
        System.out.println(first + "and list: " + second);
    }

    @EnumSource(MenuYandexItems.class)
    @ParameterizedTest
    void yaSearchMenuTest(MenuYandexItems testData) {
        Selenide.open("https://ya.ru"); // предусловие

        $("#text ").setValue("Allure TestOps"); //step 1
        $("button[type='submit']").click();  //step 2

        $$(".navigation__item")
                .find(Condition.text(testData.rusName))
                .click();
        Assertions.assertEquals(
                2,
                WebDriverRunner.getWebDriver().getWindowHandles().size()
        );
    }

    @AfterEach
    void close() {
        Selenide.closeWebDriver();
    }
}
