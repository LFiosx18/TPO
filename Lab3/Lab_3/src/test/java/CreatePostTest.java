import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CreatePostTest {
    private static List<WebDriver> drivers;
    private final String myPost = "My test post send!";

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testCreatePost() {
        openSite();
        signIn();
        openWindowPost();
        changeAccess();
        chooseAccess();
        writePost();
        sendPost();
        checkPost();
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

    public void openWindowPost() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[1]/div/div/div[1]/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void changeAccess() {
        String xpath = "/html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[2]/div/div/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void chooseAccess() {
        String xpath = "/html/body/div[4]/div/div/div/div[1]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void writePost() {
        String xpath = "/html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[1]/div/div";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).sendKeys(myPost));
        Helpers.timeout();
    }


    public void sendPost() {
        String xpath = "/html/body/div[3]/div/div/div/div/div[3]/div/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkPost() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/article/div[2]/div/div/div/p";
        drivers.forEach(driver -> {
            String findText = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals(myPost, findText);
        });
        Helpers.timeout();
    }
}
