package ru.geekbrains.lesson5_hw.command1;

import org.openqa.selenium.WebDriver;

public class Header extends ru.geekbrains.lesson5_hw.base.Header<MainPage> {
    public Header(WebDriver driver) {
        super(driver, MainPage.class);
    }
}
