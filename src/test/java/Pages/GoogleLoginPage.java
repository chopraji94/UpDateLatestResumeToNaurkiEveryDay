package Pages;

import Common.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleLoginPage {
    WebDriver driver;

    public GoogleLoginPage(WebDriver driver){
        this.driver = driver;
    }

    By emailTxtField = By.xpath(Locators.googleSignIn.emailFieldXpath);
    By passwordTxtField = By.xpath(Locators.googleSignIn.passwordFieldXpath);
    By nextBtn = By.xpath(Locators.googleSignIn.nextButtonXpath);

    public void EnterEmail(String email) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTxtField));
        element.sendKeys(email);
    }

    public void EnterPassword(String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxtField));
        element.sendKeys(password);
    }

    public void ClickNextButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        element.click();
    }

    public void LoginAsGmailUser(String email,String password) throws InterruptedException {
        EnterEmail(email);
        ClickNextButton();
        EnterPassword(password);
        ClickNextButton();

    }
}
