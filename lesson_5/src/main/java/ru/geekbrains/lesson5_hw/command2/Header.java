package ru.geekbrains.lesson5_hw.command2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends ru.geekbrains.lesson5_hw.base.Header<CareerPage> {

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/login\"]")
    private WebElement buttonLogin;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/register\"]")
    private WebElement buttonRegister;

    public Header(WebDriver driver) {
        super(driver, CareerPage.class);
    }

    public CareerPage checkSection() {
        checkElementsDisplayed(new WebElement[]{
                section,
                buttonSearch,
                buttonLogin,
                buttonRegister
        });
        return PageFactory.initElements(driver, CareerPage.class);
    }
}
