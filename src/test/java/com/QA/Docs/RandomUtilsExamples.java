package com.QA.Docs;

import static com.QA.Utils.RandomUtils.*;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        System.out.println("Random string of 10 letters:" + getRandomString(10));
        System.out.println("Random int min - max:" + getRandomInt(1, 9999));
        System.out.println("Random email:" + getRandomEmail());
    }
}
