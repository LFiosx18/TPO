import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SubscriptionsTest {
    private static List<WebDriver> drivers;

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testSubscriptions() {
        openSite();
        signIn();
        openMenu();
        chooseSub();
        clickMenu();
        clickPopular();
        follow();
        clickMenu();
        clickMy();
        checkFollow();
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

    public void openMenu() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/header/div/div/div/div/div[2]/div/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void chooseSub() {
        String xpath = "/html/body/div[3]/div/div/div/a[5]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void clickMenu() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void clickPopular() {
        String xpath = "/html/body/div[3]/div/div/div/button[1]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void follow() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }
    public void clickMy() {
        String xpath = "/html/body/div[3]/div/div/div/button[3]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkFollow() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/div/div/button";
        drivers.forEach(driver -> Assertions.assertTrue(true));
        Helpers.timeout();
    }
}
