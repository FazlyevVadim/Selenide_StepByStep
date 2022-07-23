package com.QA.Tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AllureReportTestParameters {

    @Test
    @DisplayName("Мой тест")
    public void testParameters() {
        Allure.parameter("Регион", "Московская область");
        Allure.parameter("Город", "Москова");
    }
}

