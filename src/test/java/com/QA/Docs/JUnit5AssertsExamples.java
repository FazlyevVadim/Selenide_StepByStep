package com.QA.Docs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//@Disabled // отклчючит весь класс
@DisplayName("Класс с демонстрационными тестами")
public class JUnit5AssertsExamples {
    @DisplayName("Демонстрационный тест")
    // @Disabled("Коммент почему не работает или имя теста") // тест отключен
    @Test
    void fistTest() {
        Assertions.assertTrue(3 > 2, "Проверяем 3 больше 2"); // можно месседж добавлять
        Assertions.assertFalse(3 < 2);
        Assertions.assertEquals(1, 1);
        Assertions.assertAll(
                () -> Assertions.assertTrue(3 > 2),
                () -> Assertions.assertFalse(3 > 2)
        );  //Тут даже если 1 поле упало, то остальные будут дальше делать проверку и месседж добавляется в начало, потом массив
    }
}
