import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SignInTest {
    private static List<WebDriver> drivers;
    private final String username = Helpers.getUsername();
    private final String password = Helpers.getPassword();

    @BeforeAll
    public static void init() {
        Helpers.setupDrivers();
        drivers = Helpers.initDrivers();
    }

    @Test
    public void testSignInWithMyPage() {
        openSiteToSignIn();
        clickSignInOnTheMainPage();
        clickEnterByEmail();
        enterUsername();
        enterPassword();
        clickSignInButton();
        checkMyName();
//        goToMyPage();
//        checkUsernameInProfile();
    }

    @AfterAll
    public static void close() {
        Helpers.closeDrivers(drivers);
    }

    public void openSiteToSignIn() {
        Helpers.openSite(drivers);
        Helpers.timeout();
    }

    public void clickSignInOnTheMainPage(){
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/header/div/div/div/div/div[3]/ul/li[2]/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void clickEnterByEmail(){
        String xpath = "/html/body/div[3]/div/div/div/div/div/form/div[5]/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void enterUsername() {
        String xpath = "/html/body/div[3]/div/div/div/div/div/form/div[1]/div/input";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).sendKeys(username));
        Helpers.timeout();
    }

    public void enterPassword() {
        String xpath = "/html/body/div[3]/div/div/div/div/div/form/div[2]/div/input";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).sendKeys(password));
        Helpers.timeout();
    }

    public void clickSignInButton() {
        String xpath = "/html/body/div[3]/div/div/div/div/div/form/div[3]/button";
        drivers.forEach(driver -> Helpers.findElement(driver, By.xpath(xpath)).click());
        Helpers.timeout();
    }

    public void checkMyName() {
        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/button";
        drivers.forEach(driver-> {
            String screenName = Helpers.findElement(driver, By.xpath(xpath)).getText();
            String name = screenName.substring(18, 22);
            Assertions.assertEquals("Лиса", name);
        });
    }

//    public void goToMyPage() {
//        String xpath = "/html/body/div[1]/div/div[1]/div/header/div/div/div/div/div[2]/div/button";
//        String xpathMy = "/html/body/div[3]/div/div/div/a[1]";
//        drivers.forEach(driver -> {
//            Helpers.findElement(driver, By.xpath(xpath)).click();
//            Helpers.findElement(driver, By.xpath(xpathMy)).click();
//        });
//        Helpers.timeout();
//    }

//    public void checkUsernameInProfile() {
//        String xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div/h2/a";
//        drivers.forEach(driver -> {
//            String actualScreenName = Helpers.findElement(driver, By.xpath(xpath)).getText();
//            Assertions.assertEquals("Лиса", actualScreenName);
//        });
//        Helpers.timeout();
//    }
}
