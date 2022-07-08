package com.QA.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class StudentRegistrationForm1LessonFaker {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.address().country();
    String fullName = format("%s %s", firstName, lastName);

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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
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
        $("#currentAddress").setValue(currentAddress); // Current Address
        $("#state").scrollIntoView(true).doubleClick(); //state
        $("#city").doubleClick(); //city
        Selenide.executeJavaScript("$('footer').remove()");
        Selenide.executeJavaScript("$('#close-fixedban').remove()");
        $(byText("Submit")).click();

        //TableCheckResults
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text(fullName), text(email), text("Male"), text("9196112576"), text("12 April,1987"),
                text("English"), text("Sports"), text("1.png"), text(currentAddress), text("Haryana Karnal"));


    }
}
