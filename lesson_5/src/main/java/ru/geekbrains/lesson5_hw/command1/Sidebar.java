package ru.geekbrains.lesson5_hw.command1;

import org.openqa.selenium.WebDriver;

public class Sidebar extends ru.geekbrains.lesson5_hw.base.Sidebar<MainPage>{
    public Sidebar(WebDriver driver) {
        super(driver, MainPage.class);
    }
}
