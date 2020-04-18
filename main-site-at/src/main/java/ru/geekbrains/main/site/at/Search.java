package ru.geekbrains.main.site.at;

import org.hamcrest.Matcher;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;

public class Search extends PageObject{
    public Search enterSearchText(String text){
        waitElementDisplayed(inputSearch);
        inputSearch.sendKeys(text);
        return this;
    }

    public Search checkElement(String name, Matcher matcher) {
        Object actual = null;
        switch (name){
            case "Профессии": {
                actual = getElementTextToInt(labelProfessionsCount);
                break;
            }
            case "Курсы": {
                actual = getElementTextToInt(labelCoursesCount);
                break;
            }
            case "Вебинары": {
                actual = getElementTextToInt(labelWebinarsCount);
                break;
            }
            case "Блоги": {
                actual = getElementTextToInt(labelBlogsCount);
                break;
            }
            case "Форумы": {
                actual = getElementTextToInt(labelForumsCount);
                break;
            }
            case "Тесты": {
                actual = getElementTextToInt(labelTestsCount);
                break;
            }
            case "Geekbrains": {
                actual = waitElementDisplayed(buttonCompaniesGeekbrains);
                break;
            }
        }
        if (actual == null) {
            throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
        }
        assertThat(actual, matcher);
        return this;
    }
    public int getLabelCounter(String name) {
        int counter = -1;
        switch (name){
            case "Профессии": {
                counter = getElementTextToInt(labelProfessionsCount);
                break;
            }
            case "Курсы": {

                counter = getElementTextToInt(labelCoursesCount);
                break;
            }
            case "Вебинары": {

                counter = getElementTextToInt(labelWebinarsCount);
                break;
            }
            case "Блоги": {
                counter = getElementTextToInt(labelBlogsCount);
                break;
            }
            case "Форумы": {

                counter = getElementTextToInt(labelForumsCount);
                break;
            }
            case "Тесты": {

                counter = getElementTextToInt(labelTestsCount);
                break;
            }
        }
        if (counter == -1) {

            throw new NotFoundException("Элемент" + name + "нет в классе" + getClass().getName());
        }
        return counter;
    }

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    public WebElement inputSearch;

    @FindBy(css = "[class*=\"search-page-block\"] [class=\"company-item__pic\"] [alt*=\"GeekBrains\"]")
    public WebElement buttonCompaniesGeekbrains;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"tests\"] span")
    public WebElement labelTestsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"forums\"] span")
    public WebElement labelForumsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span")
    public WebElement labelBlogsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span")
    public WebElement labelWebinarsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"courses\"] span")
    public WebElement labelCoursesCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"professions\"] span")
    public WebElement labelProfessionsCount;

    public Search(WebDriver driver) {
        super(driver);
    }
}
