package ru.geekbrains.lesson5_hw.command1;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.lesson5_hw.base.PageObject;

public class MainPage extends PageObject {
    private Header header;
    private Sidebar sidebar;

    public Header getHeader() {
        return header;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public MainPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        sidebar = new Sidebar(driver);
    }
}
