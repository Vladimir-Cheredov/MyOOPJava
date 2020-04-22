package ru.geekbrains.lesson5_hw.command2;

import org.openqa.selenium.WebDriver;

public class Footer extends ru.geekbrains.lesson5_hw.base.Footer<CareerPage> {
    public Footer(WebDriver driver) {
        super(driver, CareerPage.class);
    }
}
