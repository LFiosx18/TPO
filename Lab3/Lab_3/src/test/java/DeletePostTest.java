import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DeletePostTest {
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
        goToMyPage();
        if (clickPostOptions()) {
            changeDelete();
            confirmDelete();
            checkDelete();
        }
        else noPost();
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

    public boolean clickPostOptions() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/article/div[3]/div/div[2]/button";
        try {
            drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        } catch (Exception e) {
            System.out.println("Post not found");
            return false;
        }
        Helpers.timeout();
        return true;
    }

    public void changeDelete() {
        String xpath = "/html/body/div[3]/div/div/div/ul/li[2]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void confirmDelete() {
        String xpath = "/html/body/div[3]/div/div/div[2]/button[1]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkDelete() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/article/div[4]/button";
        drivers.forEach(driver -> {
            String postText = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals("Восстановить", postText);
        });
        Helpers.timeout();
    }

    public void noPost() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/article";
        drivers.forEach(driver -> {
            String postText = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals("Здесь пока ничего нет", postText);
        });
        Helpers.timeout();
    }
}
