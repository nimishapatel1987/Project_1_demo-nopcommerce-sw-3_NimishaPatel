package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu, By by) {
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }

    //Computer menu
    @Test
    public void verifyUserCanNavigateToComputerMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        selectMenu("Computers", By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Computers')]"), "Computers");
    }

    //Electronics Menu
    @Test
    public void verifyUserCanNavigateToElectronicsMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        selectMenu("Electronics", By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Electronics')]"), "Electronics");
    }

    //Apparel Menu
    @Test
    public void verifyUserCanNavigateToApparelMenu() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        selectMenu("Apparel", By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Apparel')]"), "Apparel");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
