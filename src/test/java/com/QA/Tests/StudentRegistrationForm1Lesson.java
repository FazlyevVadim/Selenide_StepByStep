package com.QA.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm1Lesson {


    @BeforeAll
    static void setUp() {

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";


    }

    @Test
    void fillForm() {


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); //what for?
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
        $("#hobbies-checkbox-1").parent().click(); //hobbies  parent()???  - клик на уровень выше   $(new ByText("Sports")).click()
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("City Kydrovo near Saint-Petersburg, Street Angliskaya 2"); // Current Address
        $("#state").scrollIntoView(true).doubleClick(); //state
        $("#city").doubleClick(); //city
        Selenide.executeJavaScript("$('footer').remove()");
        Selenide.executeJavaScript("$('#close-fixedban').remove()");
        $(byText("Submit")).click();

        //TableCheckResults
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Vadim" + " " + "Fazlyev"), text("FazlyevVR@yandex.ru"), text("Male"), text("9196112576"), text("12 April,1987"),
                text("English"), text("Sports"), text("1.png"), text("City Kydrovo near Saint-Petersburg, Street Angliskaya 2"), text("Haryana Karnal"));


    }
}
