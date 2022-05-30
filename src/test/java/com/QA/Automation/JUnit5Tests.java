package com.QA.Automation;

import org.junit.jupiter.api.*;

public class JUnit5Tests {
    @BeforeAll
    static void initDB() {
        System.out.println("### BeforeAll");
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("### AfterAll");
    }

    @BeforeEach
    void openYaPage() {
        System.out.println("###         BeforeEach");
        // Selenide.open("https://ya.ru");
    }

    @AfterEach
    void closeYaPage() {
        System.out.println("###         AfterEach");
        // WebDriverRunner.closeWindow();

    }

    @Test
    void assertTest1() {
        System.out.println("###     Test1");
        //...поиск в новостях
    }

    @Test
    void assertTest2() {
        System.out.println("###     Test2");
        //...поиск в картинках
    }

    @Test
    void assertTest3() {
        System.out.println("###     Test3");
        //...поиск в чем-то
    }
}

