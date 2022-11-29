package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void varifyProductArrangeInAlphaBaticalOrder() {
        //click on computer Menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]']"));
        //Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//div[@class = 'product-sorting']"));
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        sortBy.selectByVisibleText("Name: Z to A");
        // Verify the product will arrange in Descending order
        String expectedMessage = "Name: Z to A";
        String actualMessage = getTextFromElement(By.xpath("//select[@aria-label = 'Select product sort order']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //click on computer Menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //Select Sort By position "Name: A to Z"
        Select sortBy = new
                Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        sortBy.selectByVisibleText("Name: A to Z");
        Thread.sleep(3000);
        //Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //This is from requirement
        String expectedMessage = "Build your own computer";
        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String actualMessage = actualTextMessageElement.getText();
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using select class
        // select processor
        Thread.sleep(3000);
        Select sortProcessor = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
        sortProcessor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(3000);

        //2.7 Select"8GB [+$60.00]"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB[+$60.00]");

        //2.8 Select HDD radio "400 GB[+$100.00]
        Thread.sleep(3000);
        clickOnElement(By.cssSelector("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.cssSelector("product_attribute_4_9"));

        //2.10 Check Two Check boxes"Microsoft office[+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//label[contains(text(),'Microsoft Office [+$50.00]//label[contains(text(),'Total Commander [+$5.00]"));

        //2.11 Verify the price "$1,475.00"
        verifyExpectedAndActual(By.xpath("//span[@id = 'price-value-1']"), "$1,475.00");

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green bar
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart on Top green Bar");

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions = new Actions(driver);
        WebElement cart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement cartItem = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(cart).moveToElement(cartItem).click().build().perform();

        //2.15 Verify the message "Shopping cart"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$2,940.00");

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//strong[contains(text(),'Checkout as a guest or register')]"));

        Thread.sleep(3000);
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("//input[@id='BillingNewAddress_FirstName']"), "Pari");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_LastName']"), "Patel");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_Email']"), "paripatel123@gmail.com");
        sendTextToElement(By.id("//select[@id='BillingNewAddress_CountryId']"), "United Kindom");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_City']"), "Cambridge");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_Address1']"), "Cambridge");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_ZipPostalCode']"), "CB4 3NB");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_PhoneNumber']"), "+44 9876543210");


        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("2.23 Click on “CONTINUE”"));

        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("2.24 Click on Radio Button “Next Day Air($0.00)”"));

        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        // 2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //  2.27 Select “Master card” From Select credit card dropdown
        Select card = new Select(driver.findElement(By.xpath("//label[contains(text(),'Select credit card:')]")));
        card.selectByVisibleText("Master card");

        // 2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Pari");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");

        Select month = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        month.selectByVisibleText("11");

        Select year = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        year.selectByVisibleText("2023");

        sendTextToElement(By.xpath("//input[@id='CardCode']"), "777");

        // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        // 2.32 Verify “Shipping Method” is “Next Day Air”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "Next Day Air");

        // 2.33 Verify Total is “$2,950.00”
       verifyExpectedAndActual(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"), "$2,980.00");

        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        // 2.35 Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("2.35 Verify the Text “Thank You”"), "“Thank You”");

        // 2.36 Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("2.36 Verify the message “Your order has been successfully processed!”"), "“Your order has been successfully processed!”");

        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // 2.37 Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
