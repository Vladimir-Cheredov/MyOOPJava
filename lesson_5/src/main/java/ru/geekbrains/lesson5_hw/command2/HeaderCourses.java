package ru.geekbrains.lesson5_hw.command2;

import org.openqa.selenium.WebDriver;

public class HeaderCourses extends ru.geekbrains.lesson5_hw.base.Header<CoursesPage> {
    public HeaderCourses(WebDriver driver) {
        super(driver, CoursesPage.class);
    }
}