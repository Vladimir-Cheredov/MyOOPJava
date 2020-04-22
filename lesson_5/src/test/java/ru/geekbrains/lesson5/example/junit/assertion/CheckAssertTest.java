package ru.geekbrains.main.site.at.example.assertion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class CheckAssertTest {
    @Test
    public void assertEquals() {
        Assertions.assertEquals(2, 1 + 1);
    }

    @Test
    public void name() {
        Assertions.assertTrue(2 >= 1 + 1);

    }

    @Test
    public void False() {
        Assertions.assertFalse(2 > 1 + 1);

    }

    @Test
    public void assertNull() {
        String name = "null";
        Assertions.assertNull(name);
    }

    @Test
    public void assertNotNull() {
        String name = "null";
        Assertions.assertNotNull(name);
    }

    @Test
    public void assertEquals2() {
        RuntimeException runtimeException = new RuntimeException("Hi");
        Assertions.assertEquals("Hi", runtimeException.getMessage());
    }

    @Test
    public void assertAll() {
        String name = "Cat";
        Assertions.assertAll(
                "Проверка числа",
                () -> Assertions.assertEquals("Кот", "Cat"),
                () -> Assertions.assertEquals("Собака", "Cat"),
                () -> Assertions.assertEquals("Птица", "Cat"));
    }

    @Timeout(1)
    @Test()
    void Time() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofSeconds(2), () -> {
            sleep(5000);
        });
    }
}

