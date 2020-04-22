package ru.geekbrains.lesson5_hw.command2;

import org.openqa.selenium.WebDriver;

public class Sidebar extends ru.geekbrains.lesson5_hw.base.Sidebar<CareerPage> {
    protected Sidebar(WebDriver driver) {
        super(driver, CareerPage.class);
    }
}
