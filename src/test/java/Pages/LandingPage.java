package Pages;

import Common.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    By loginBtn = By.xpath(Locators.Landingpage.loginButtonXpath);

    By singInUsingGoogleBtn = By.xpath(Locators.Landingpage.singInWithGoogleButtonXpath);


    public void ClickLoginBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        element.click();
    }

    public void ClickSignInWithGoogleBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(singInUsingGoogleBtn));
        element.click();
    }
}
