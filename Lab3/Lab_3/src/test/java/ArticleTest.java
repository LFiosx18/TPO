import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ArticleTest {
    private static List<WebDriver> drivers;

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testArticle() {
        openSite();
        signIn();
        goToCooing();
        checkCooking();
    }

    @AfterAll
    public static void close() {
        Helpers.closeDrivers(drivers);
    }

    public void openSite() {
        Helpers.openSite(drivers);
        Helpers.timeout();
    }

    public void signIn() {
        drivers.forEach(Helpers::signInToSite);
        Helpers.timeout();
    }

    public void goToCooing(){
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[1]/div/div/div[1]/div[1]/a[1]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkCooking() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/h1";
        drivers.forEach(driver-> {
            String quizTitle = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals("Кулинария", quizTitle);
        });
    }
}
