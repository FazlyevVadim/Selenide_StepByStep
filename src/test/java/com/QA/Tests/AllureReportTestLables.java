package com.QA.Tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;


public class AllureReportTestLables {

    @Test
    @Owner("FazlyevVadim")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Возможность созданных задач в репозитории")
    @ShowIssue
    @DisplayName("Мой тест")
    @Link(value = "testing", url = "https://github.com")
    public void testAnnotated() {
    }

    @Test
    public void testCodeExample() {
        Allure.label("owner", "Fazlyev Vadim");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.step("Возможность созданных задач в репозитории");
        Allure.link("Тестинг", "https://github.com");
    }

    @Owner("FazlyevVadim")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Возможность созданных задач в репозитории")
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface ShowIssue {
    }
}
