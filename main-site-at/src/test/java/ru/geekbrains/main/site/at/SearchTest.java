package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTest extends BaseTest {




    @Test
    void name() throws InterruptedException {
        driver.get("https://geekbrains.ru/career");

        CoursesPage coursesPage = new CoursesPage(driver);

        WebElement buttonSearch = driver.findElement(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");

        WebElement textProfession = driver.findElement(By.xpath("//header/h2[text()='Профессии']"));
        WebElement textCourses = driver.findElement(By.xpath("//header/h2[text()='Курсы']"));
        WebElement textWebinars = driver.findElement(By.xpath("//header/h2[text()='Вебинары']"));
        WebElement textBlogs = driver.findElement(By.xpath("//header/h2[text()='Блоги']"));
        WebElement textForum = driver.findElement(By.xpath("//header/h2[text()='Форум']"));
        WebElement textTests = driver.findElement(By.xpath("//header/h2[text()='Тесты']"));
        WebElement textProjectsAndCompanies = driver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));


        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(textProfession, "Профессии"));
        wait.until(ExpectedConditions.textToBePresentInElement(textCourses, "Курсы"));
        wait.until(ExpectedConditions.textToBePresentInElement(textWebinars, "Вебинары"));
        wait.until(ExpectedConditions.textToBePresentInElement(textBlogs, "Блоги"));
        wait.until(ExpectedConditions.textToBePresentInElement(textForum, "Форум"));
        wait.until(ExpectedConditions.textToBePresentInElement(textTests, "Тесты"));
        wait.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies, "Проекты и компании"));

        assertThat(coursesPage.search.getLabelCounter("Профессии"), greaterThanOrEqualTo(2));
        assertThat(coursesPage.search.getLabelCounter("Курсы"), greaterThan(15));
        assertThat(coursesPage.search.getLabelCounter("Вебинары"), allOf(
                greaterThan(180),
                lessThan(300))
        );
        assertThat(coursesPage.search.getLabelCounter("Блоги"), greaterThan(300));
        assertThat(coursesPage.search.getLabelCounter("Форумы"), not(350));
        assertThat(coursesPage.search.getLabelCounter("Тесты"), not(0));
        assertThat(coursesPage.waitElementDisplayed(coursesPage.search.buttonCompaniesGeekbrains), is(true));

    }
}