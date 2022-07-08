package com.QA.objects;

import com.QA.objects.Components.CalendarComponents;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPageObject {
    CalendarComponents calendar = new CalendarComponents();
    //locators
    SelenideElement firstNameInput = $("#firstName");

    //actions
    public RegistrationFormPageObject openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); //what for?
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");
        return this;
    }

    public RegistrationFormPageObject setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPageObject setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationFormPageObject setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationFormPageObject setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPageObject setPhoneNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPageObject setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPageObject setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPageObject setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPageObject setFile(String value) {
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        return this;
    }

    public RegistrationFormPageObject setCurrentAdress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPageObject setState(String value) {
        $("#state").scrollIntoView(true).doubleClick();
        return this;
    }

    public RegistrationFormPageObject setCity(String value) {
        $("#city").doubleClick();
        return this;
    }

    public RegistrationFormPageObject clickSubmit(String value) {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPageObject checkTableName(String value) {
        $(".modal-title").$(byText(value));
        return this;
    }

    public RegistrationFormPageObject checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
