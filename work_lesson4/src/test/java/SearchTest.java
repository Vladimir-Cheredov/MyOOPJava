import base.BaseTest;
import org.junit.jupiter.api.*;
import ru.geekbrains.work.lesson4.CoursesPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DisplayName("Results from the word \"java\\")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest extends BaseTest {
    @BeforeAll
    protected void setUp() {
        super.setUp();
        coursesPage = new CoursesPage(driver);
        driver.get("https://geekbrains.ru/courses");
        coursesPage.buttonClick(coursesPage.header.buttonSearch);
        coursesPage.search.inputSearch.sendKeys("Java");
    }
    @DisplayName("Passed Test 1, Profession >=2")
    @Test
    void checkProfessions() {
        assertThat(coursesPage.search.getLabelCounter("Профессии"), greaterThanOrEqualTo(2));
    }
    @DisplayName("Passed Test 2, Course >15")
    @Test
    void checkCourses() {
        assertThat(coursesPage.search.getLabelCounter("Курсы"), greaterThan(15));
    }
    @DisplayName("Passed Test 3, Webinars >180 but <300")
    @Test
    void checkWebinars() {
        assertThat(coursesPage.search.getLabelCounter("Вебинары"), allOf(
                greaterThan(180),
                lessThan(300)));
    }
    @DisplayName("Passed Test 4, Blogs >300")
    @Test
    void checkBlogs() {
        assertThat(coursesPage.search.getLabelCounter("Блоги"), greaterThan(300));
    }
    @DisplayName("Passed Test 5, Forums not 350")
    @Test
    void checkPosts() {
        assertThat(coursesPage.search.getLabelCounter("Форумы"), not(350));
    }
    @DisplayName("Passed Test 6, Tests not 0")
    @Test
    void checkTest() {
        assertThat(coursesPage.search.getLabelCounter("Тесты"), not(0));
    }
    @DisplayName("Passed Test 7, The company projects display GeekBrains")
    @Test
    void checkGrainsLogoExist() {
        assertThat(coursesPage.waitElementDisplayed(coursesPage.search.buttonCompaniesGeekbrains), is(true));
    }
}
