import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MyProfileTest {
    private static List<WebDriver> drivers;
    private final String myName = "Лиса";

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testCreatePost() {
        openSite();
        signIn();
        goToMyPage();
        checkMyPage();
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

    public void goToMyPage() {
        String xpath = "/html/body/div[1]/div/div[1]/div/header/div/div/div/div/div[2]/div/button";
        String xpathMy = "/html/body/div[3]/div/div/div/a[1]";
        drivers.forEach(driver -> {
            Helpers.findElement(driver, By.xpath(xpath)).click();
            Helpers.findElement(driver, By.xpath(xpathMy)).click();
        });
        Helpers.timeout();
    }

    public void checkMyPage() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div/h2/a";
        drivers.forEach(driver -> {
            String pageTitle = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals(myName, pageTitle);
        });
        Helpers.timeout();
    }
}
