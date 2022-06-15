package com.QA.Docs;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerExamples {
    public static void main(String[] args) {

        Faker faker = new Faker();

        System.out.println(faker.aquaTeenHungerForce().character());
        System.out.println(faker.backToTheFuture().quote());
        System.out.println(faker.ancient().titan());

        Faker fakerDe = new Faker(new Locale("de"));
        System.out.println(fakerDe.address().fullAddress());

        Faker fakerJa = new Faker(new Locale("ja"));
        System.out.println(fakerJa.animal().name());
        System.out.println(fakerJa.artist().name());

        Faker fakerRu = new Faker(new Locale("ru"));
        System.out.println(fakerRu.book().author());

    }
}
