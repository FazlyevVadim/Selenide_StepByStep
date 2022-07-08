package com.QA.Docs;

import static java.lang.String.format;

public class FormatExamples {
    public static void main(String[] args) {
        String user = "username",
                subject = "you";
        System.out.println("Hello," + " " + user + "!" + " " + "How are" + " " + subject + "?");

        System.out.println("Hello," + " " + "username" + "!" + " " + "How are" + " " + "you" + "?");
        System.out.println(format("Hello, %s! How are %s?", "username", "you"));

    }
}
