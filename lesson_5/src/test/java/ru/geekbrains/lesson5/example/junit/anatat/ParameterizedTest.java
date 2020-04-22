package ru.geekbrains.main.site.at.example.anatat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParameterizedTest {
    //-------------------Простой пример
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = { "Курсы", "Вебинары" })
    void testWithStringParameter(String name) {
        assertNotNull(name);
    }

    //-------------------Пример с передачей 1 аргумента из метода
    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("stringProvider")
    public void test2(String name) {
        Assertions.assertNotNull(name);
    }
    public static Stream<String> stringProvider(){
        return Stream.of("Курсы", "Вебинары");
    }

    //-------------------Пример с передачей множество аргументов
    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("stringAndIntProvider2")
    public void test3(String name, int second) {
        Assertions.assertNotNull(name);
    }

    public static Stream<Arguments> stringAndIntProvider2() {
        return Stream.of(Arguments.of("Курсы", 123456), Arguments.of("Вебинары", 1232456));
    } //пример с передачей множество аргументов с названием

    @org.junit.jupiter.params.ParameterizedTest(name = "тему: {0} проходить {1} год")
    @MethodSource("stringProvider4")
    public void test4(String name, int age){
        Assertions.assertNotNull(name);
    }
public static Stream<Arguments>stringProvider4(){
   return Stream.of(
           Arguments.of("Курсы",2),
           Arguments.of("Вебинары",3));
}
}
