package Pages;

import Common.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedInPage {
    WebDriver driver;

    public LoggedInPage(WebDriver driver){
        this.driver = driver;
    }

    By sideMenuDrawerButton = By.xpath(Locators.LoggedInPage.sideMenuDrawerButtonXpath);
    By viewAndUpdateProfileButton = By.xpath(Locators.LoggedInPage.viewAndUpdateProfileButtonXpath);

    public void GotoUpdateResumePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sideMenuDrawerButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewAndUpdateProfileButton)).click();
    }
}
