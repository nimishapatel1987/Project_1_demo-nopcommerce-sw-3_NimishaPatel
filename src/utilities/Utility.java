package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /*
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText, expectedText);
    }

    public void verifyMessage(String expectedMessage,String actualMessage){
        Assert.assertEquals(expectedMessage,actualMessage);
    }




//********************************Alert Methods *******************************8

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    // Homework 4 Method acceptAlert, dismissAlert, String getTextFromAlert, sendTextToAlert(String text)

    //****************************Select Class Methods***************************************

    /**
     * This method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */

    /**
     * This method will select the option by index
     */

    /**
     * This method will select the option by contains text
     */

    //*********************************************Window Handle****************************************
    //*********************************************Action Class*****************************************

    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        actions.moveToElement(computer).build().perform();
    }
    //mouseHoverToElement(By by), mouseHoverToElementAndClick(By by)

    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement software = driver.findElement(by);
        actions.moveToElement(software).click().build().perform();
    }
    //clear text
    public void clearText(By by) {
        Actions actions = new Actions(driver);
        WebElement quantity = driver.findElement(by);
        quantity.clear();
    }

}
