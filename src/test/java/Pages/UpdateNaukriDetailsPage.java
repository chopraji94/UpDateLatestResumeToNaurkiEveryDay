package Pages;

import Common.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UpdateNaukriDetailsPage {
    WebDriver driver;

    public UpdateNaukriDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    By updateResumeButton = By.xpath(Locators.UpdateNaurkiDetailsPage.updateResumeButtonXpath);
    By updatedDateLabelXpath = By.xpath(Locators.UpdateNaurkiDetailsPage.updatedDateLabelXpath);

    public void uploadLatestResume() throws InterruptedException, AWTException {
        driver.findElement(updateResumeButton).click();
        Thread.sleep(Duration.ofSeconds(10));

        StringSelection s = new StringSelection(System.getProperty("user.dir")+"\\ResumeFile\\Resume.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(java.awt.event.KeyEvent.VK_V);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String getUpdatedDateLabel(){
        return driver.findElement(updatedDateLabelXpath).getText();
    }
}
