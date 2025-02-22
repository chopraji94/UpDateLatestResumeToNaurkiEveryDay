package BaseClass;

import Pages.GoogleLoginPage;
import Pages.LandingPage;
import Pages.LoggedInPage;
import Pages.UpdateNaukriDetailsPage;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class Base {

    WebDriver driver;
    public LandingPage landingPage;
    public GoogleLoginPage googleLoginPage;
    public LoggedInPage loggedInPage;
    public UpdateNaukriDetailsPage updateNaukriDetailsPage;
    public Properties property;

    @BeforeClass
    public void IntialDriver() throws IOException {

        FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        property = new Properties();
        property.load(file);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        IntializeDriverToEachClass();
    }

    private void IntializeDriverToEachClass(){
        if(landingPage == null)
            landingPage = new LandingPage(driver);
        if(googleLoginPage == null)
            googleLoginPage = new GoogleLoginPage(driver);
        if(loggedInPage == null)
            loggedInPage = new LoggedInPage(driver);
        if(updateNaukriDetailsPage == null)
            updateNaukriDetailsPage = new UpdateNaukriDetailsPage(driver);
    }

    private void AgainInitializeDrivers(){
        landingPage = new LandingPage(driver);
        googleLoginPage = new GoogleLoginPage(driver);
        loggedInPage = new LoggedInPage(driver);
        updateNaukriDetailsPage = new UpdateNaukriDetailsPage(driver);
    }

    public void SwitchToGoogleSingin(){
        Set<String> windowHandles = driver.getWindowHandles();
        driver = driver.switchTo().window(windowHandles.stream().toList().getLast());
        AgainInitializeDrivers();
    }

    public void SwitchToMainPage(){
        Set<String> windowHandles = driver.getWindowHandles();
        driver = driver.switchTo().window(windowHandles.stream().toList().getFirst());
        AgainInitializeDrivers();
    }

/*
    @AfterMethod
    public void attachScreenShotOnFailure(ITestResult testResult){
        if(!testResult.isSuccess()){
            ChainTestListener.embed(takeScreenShot(),"image/png");
        }
    }

    */
    /*Get Screen Shot*//*

    public byte[] takeScreenShot(){
        return ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BYTES);
    }
*/

    @AfterClass
    public void CloseDriver(){
        driver.quit();
    }

}
