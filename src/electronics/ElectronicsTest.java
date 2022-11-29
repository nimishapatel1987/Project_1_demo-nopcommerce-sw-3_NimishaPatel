package electronics;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //1.3 Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //2.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //2.3 Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.product-list div.item-grid div.item-box:nth-child(3) div.product-item div.details h2.product-title > a:nth-child(1)"));

        //2.6 Verify the text “Nokia Lumia 1020”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        //2.7 Verify the price “$349.00”
        verifyExpectedAndActual(By.xpath("//span[@id='price-value-20']"), "$349.00");

        //2.8 Change quantity to 2
        clearText(By.cssSelector("#product_enteredQuantity_20")); //  2.8 Change quantity to 2
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green bar
        verifyExpectedAndActual(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        Thread.sleep(3000);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));


        //2.12 Verify the message "Shopping cart"
        verifyExpectedAndActual(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.shopping-cart-page div.page-title > h1:nth-child(1)"), "Shopping cart");

        //2.13 Verify the quantity is 2
        verifyMessage("(2)", getTextFromElement(By.xpath("//span[contains(text(),'(2)')]")));

        //2.14 Verify the Total $698.00
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$698.00");

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        Thread.sleep(1000);
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id = 'FirstName']"), "Pari");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Patel");
        sendTextToElement(By.xpath("//input[@id='Email']"), "nppatel123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "123456");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "123456");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.cssSelector("#register-button"));

        //2.22 Verify the message “Your registration completed”
        verifyExpectedAndActual(By.xpath("//div[@class='result']"), "Your registration completed");

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping card”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill all mandatory field
        Thread.sleep(4000);
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("//input[@id='BillingNewAddress_FirstName']"), "Pari");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_LastName']"), "Patel");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_Email']"), "nppatel123@gmail.com");
        sendTextToElement(By.id("//select[@id='BillingNewAddress_CountryId']"), "United Kindom");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_City']"), "Cambridge");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_Address1']"), "Cambridge");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_ZipPostalCode']"), "CB4 3NB");
        sendTextToElement(By.id("//input[@id='BillingNewAddress_PhoneNumber']"), "+44 9876543210");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //2.32 Select “Visa” From Select credit card dropdown
        Select card = new Select(driver.findElement(By.xpath("//label[contains(text(),'Select credit card:')]")));
        card.selectByVisibleText("Master card");

        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Pari");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");

        Select month = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        month.selectByVisibleText("11");

        Select year = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        year.selectByVisibleText("2023");

        sendTextToElement(By.xpath("//input[@id='CardCode']"), "777");

        // 2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyExpectedAndActual(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "2nd Day Air");

        //2.37 Verify Total is “$698.00”
        verifyExpectedAndActual(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"), "$698.00");

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        verifyExpectedAndActual(By.xpath("https://demo.nopcommerce.com/"), "https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
