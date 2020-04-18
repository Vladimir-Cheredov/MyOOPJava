import base.BaseTest;
import junit.runner.BaseTestRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.work.lesson4.CoursesPage;
import java.util.stream.Stream;

@DisplayName("Results from the word https://geekbrains.ru/courses")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class NavigationTest extends BaseTest{
    @BeforeAll
    protected void setUp(){
        super.setUp();
        coursesPage = new CoursesPage(driver);
        driver.get("https://geekbrains.ru/courses");
        coursesPage.popUpClose();
    }
    @ParameterizedTest(name = "{index} => перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkSideBarNavigation(String navElementName){
        coursesPage.buttonClick(coursesPage.sidebar.getButton(navElementName));
        checkHeader(navElementName);
        checkFooter();
    }
    Stream<String> stringProvider(){
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }
    private void checkFooter(){
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.footer.section));
        Assertions.assertTrue(coursesPage.footer.socialLinksExists());
        Assertions.assertEquals("Отзывы", coursesPage.getElementText(coursesPage.footer.buttonFeedbacks));
        Assertions.assertEquals("Помощь", coursesPage.getElementText(coursesPage.footer.buttonHelp));
        Assertions.assertEquals("О проекте", coursesPage.getElementText(coursesPage.footer.buttonAbout));
        Assertions.assertEquals("Лицензия", coursesPage.getElementText(coursesPage.footer.buttonLiscense));
        Assertions.assertEquals("Вакансии", coursesPage.getElementText(coursesPage.footer.buttonCareer));
        Assertions.assertEquals("Компаниям", coursesPage.getElementText(coursesPage.footer.buttonForBusiness));
        Assertions.assertEquals("8 800 700-68-41", coursesPage.getElementText(coursesPage.footer.buttonPhone));
    }
    private void checkHeader(String headerText){
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.section));
        Assertions.assertEquals(headerText, coursesPage.getElementText(coursesPage.header.labelHeader));
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.buttonSearch));
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.buttonLogin));
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.buttonRegister));
    }
}
