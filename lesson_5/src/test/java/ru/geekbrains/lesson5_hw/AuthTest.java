package ru.geekbrains.lesson5_hw;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.lesson5_hw.command1.AuthPage;

@DisplayName("Проверка авторизации на странице https://geekbrains.ru/login")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthTest extends BaseTest {

    @BeforeAll
    protected void SetUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/login");
    }

    @DisplayName("Проверка отображения страницы \"Главная\"")
    @Test
    void checkMain(){
        PageFactory.initElements(driver, AuthPage.class)
                .loginAsCustomer("hao17583@bcaoo.com", "hao17583")
                .getHeader().checkTitle("Главная");
    }

    @AfterAll
    protected void tearDown(){
        super.tearDown();
    }
}