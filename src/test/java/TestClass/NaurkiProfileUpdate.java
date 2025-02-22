package TestClass;

import BaseClass.Base;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NaurkiProfileUpdate extends Base {

    @Test(priority = 1)
    public void SignInWithGoogle() throws InterruptedException {
        ChainTestListener.log("----------------------SignIn with google creds-----------------------");
        landingPage.ClickLoginBtn();
        landingPage.ClickSignInWithGoogleBtn();
    }

    @Test(priority = 2)
    public void switchToGoogleSingIn(){
        SwitchToGoogleSingin();
    }

    @Test(priority = 3)
    public void enterEmailAndPassword() throws InterruptedException {
        ChainTestListener.log("----------------------Enter Login Creds-----------------------");
        googleLoginPage.LoginAsGmailUser(property.getProperty("mailId"),property.getProperty("password"));
    }

    @Test(priority = 4)
    public void switchToMainPage() throws InterruptedException {
        SwitchToMainPage();
    }

    @Test(priority = 5)
    public void gotoResumeUploadPage() throws InterruptedException {
        ChainTestListener.log("----------------------Navigate to Update Resume Page-----------------------");
        loggedInPage.GotoUpdateResumePage();
    }

    @Test(priority = 6)
    public void updateResume() throws InterruptedException, AWTException {
        ChainTestListener.log("----------------------Upload Latest Resume-----------------------");
        updateNaukriDetailsPage.uploadLatestResume();
    }

    @Test(priority = 7)
    public void checkIfResumeIsUpdated(){
        ChainTestListener.log("----------------------Check If Resume is updated-----------------------");
        String dateLabel = updateNaukriDetailsPage.getUpdatedDateLabel();

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String formattedDate = currentDate.format(formatter);

        Assert.assertTrue(dateLabel.contains(formattedDate));
    }
}
