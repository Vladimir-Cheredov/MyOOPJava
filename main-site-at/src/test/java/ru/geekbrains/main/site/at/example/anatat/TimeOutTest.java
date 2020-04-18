package ru.geekbrains.main.site.at.example.anatat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.lang.Thread.sleep;

public class TimeOutTest {
    @Timeout(5)
    @Test
    void checkEquals() throws InterruptedException {
        Assertions.assertEquals(3, 1 + 1);
        sleep(5000);
    }
}
