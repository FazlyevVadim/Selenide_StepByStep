package com.QA.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    @BeforeAll
    static void setUp() {

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2560x1600";

    }

    @Test
    void fillForm() {

        open("/automation-practice-form");
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Fazlyev");
        $("#userEmail").setValue("FazlyevVR@yandex.ru");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("9196112576");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionContainingText("April"); //month
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").click(); //year
        $(".react-datepicker__year-select").selectOption(87);//how click on my year - 1987?
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--012").click(); //day
        $(".subjects-auto-complete__value-container").click(); //container
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-1").parent().click(); //hobbies  parent()???   $(new ByText("Sports")).click()
        $("input#uploadPicture").uploadFile(new File("TestFile.txt"));
        $("#currentAddress").setValue("City Kydrovo near Saint-Petersburg, Street Angliskaya 2"); // Current Address
        $("#state").scrollIntoView(true).doubleClick(); //state
        $("#city").doubleClick(); //city
        Selenide.executeJavaScript("$('footer').remove()");


        //$(byName("Submit")).shouldBe(visible);


    }
}
