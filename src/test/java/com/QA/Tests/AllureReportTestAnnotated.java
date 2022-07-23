package com.QA.Tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class AllureReportTestAnnotated {

    //@BeforeAll
    //static void browserOpen () {Configuration.holdBrowserOpen = true;}
    private static final String REPOSITORY = "FazlyevVadim/Selenide_StepByStep";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testGitHubWithLambda() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        AllureReportWebTests steps = new AllureReportWebTests();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.ShouldSeeIssueNumber(ISSUE_NUMBER);
    }
}
