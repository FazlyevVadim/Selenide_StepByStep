package com.QA.Tests;

import com.QA.objects.RegistrationFormPageObject;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class StudentRegistrationForm2LessonPageObject {
    RegistrationFormPageObject registrationFormPageObject = new RegistrationFormPageObject();
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            eMail = faker.internet().emailAddress(),
            currentAddress = faker.address().country(),
            phoneNumber = faker.numerify("##########");
    ;
    String fullName = format("%s %s", firstName, lastName);


    @BeforeAll
    static void setUp() {

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";


    }

    @Test
    void fillForm() {

        registrationFormPageObject.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(eMail)
                .setGender("Other")
                .setPhoneNumber(phoneNumber)
                .setBirthDate("12", "April", "1987")
                .setSubjects("English")
                .setHobbies("Sports")
                .setFile("1.png")
                .setCurrentAdress(currentAddress)
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit("Submit");


        //TableCheckResults
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


        registrationFormPageObject.checkTableName("Thanks for submitting the form");

        registrationFormPageObject.checkResult("Student Name", fullName)
                .checkResult("Student Email", eMail)
                .checkResult("Gender", "Other")
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", "12 April,1987")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", "Haryana Karnal");


    }
}
