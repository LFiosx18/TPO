import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LogOutTest {
    private static List<WebDriver> drivers;

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testCreatePost() {
        openSite();
        signIn();
        logOut();
        confirmLogOut();
        checkLogOut();
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

    public void logOut() {
        String xpath = "/html/body/div[1]/div/div[1]/div/header/div/div/div/div/div[2]/div/button";
        String xpathOut = "/html/body/div[3]/div/div/div/a[13]";
        drivers.forEach(driver -> {
            Helpers.findElement(driver, By.xpath(xpath)).click();
            Helpers.findElement(driver, By.xpath(xpathOut)).click();
        });
        Helpers.timeout();
    }

    public void confirmLogOut() {
        String xpath = "/html/body/div[3]/div/div/div/div[2]/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkLogOut() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/header/div/div/div/div/div[3]/ul/li[2]/button";
        drivers.forEach(driver -> {
            boolean isDisplay = Helpers.findElement(driver, By.xpath(xpath)).isDisplayed();
            Assertions.assertTrue(isDisplay);
        });
        Helpers.timeout();
    }
}
