package com.QA.Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String name = "Vadim Fazlyev"; // todo did it on all lines

        open("/text-box");

        $("[id=userName]").setValue("name");
        $("[id=userEmail]").setValue("FazlyevVR@yandex.ru");
        $("[id=currentAddress]").setValue("City Kydrovo near Saint-Petersburg");
        $("[id=permanentAddress]").setValue("City Ufa");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("name"), text("FazlyevVR@yandex.ru"),
                text("City Kydrovo near Saint-Petersburg"), text("City Ufa"));
//        $("[id=output] [id=name]").shouldHave(text("name"));
//        $("[id=output]").$("[id=name]").shouldHave(text("name"));

//        $("p[id=permanentAddress]").shouldHave(text("Permanent Address :City Ufa")); // If have 2 same ids
    }
}

