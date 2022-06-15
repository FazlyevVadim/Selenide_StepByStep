package com.QA.Utils;

import java.util.Random;

public class RandomUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public static int getRandomInt(int min, int max) {   //Random number

        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomEmail() {  // Random Email

        String emailDomain = "@yandex.ru";

        return getRandomString(10) + emailDomain;
    }
}
