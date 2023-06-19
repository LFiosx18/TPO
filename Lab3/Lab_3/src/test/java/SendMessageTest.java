import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SendMessageTest {
    private static List<WebDriver> drivers;
    String myMsg = "Привет мой друг :)";

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testSendMessage() {
        openSite();
        signIn();
        goToChats();
        clickNewChat();
        clickPersonChat();
        enterMessage();
        sendMessage();
        checkMessage();
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

    public void clickNewChat() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div[1]/a";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void clickPersonChat() {
        String xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[1]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void enterMessage() {
        String xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[1]/div[3]/div/div[2]/div/div[2]";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).sendKeys(myMsg));
        Helpers.timeout();
    }

    public void sendMessage() {
        String xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[1]/div[3]/div/div[2]/div/div[4]/div";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkMessage() {
        String xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/div[17]/div[2]/div[1]";
        drivers.forEach(driver -> {
            String findText = Helpers.findElement(driver, By.xpath(xpath)).getText();
            Assertions.assertEquals(myMsg, findText);

        });
        Helpers.timeout();
    }


}
