import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MomentsViewTest {
    private static List<WebDriver> drivers;

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testMomentsView() {
        openSite();
        signIn();
        goToMoments();
        checkMoment();
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

    public void goToMoments() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/button[2]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    private final String lastAuthor = "Марина Ок";
    public void checkMoment() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/article/div[1]/div/div/div/a[1]/div/span";
        drivers.forEach(driver -> {
            String lastPost = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals(lastAuthor, lastPost);
        });
        Helpers.timeout();
    }
}
