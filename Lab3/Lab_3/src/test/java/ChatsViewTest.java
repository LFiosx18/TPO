import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ChatsViewTest {
    private static List<WebDriver> drivers;

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testChatsView() {
        openSite();
        signIn();
        goToChats();
        checkChats();
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

    public void goToChats() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[1]/div/div/div[1]/div[2]/a[1]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkChats() {
        String expButton = "Создать свой чат";

        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div[1]/a";
        drivers.forEach(driver -> {
            String buttonName = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals(expButton, buttonName);
        });
        Helpers.timeout();
    }
}
