package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.Utilities;

public class LaptopsAndNotebooksTest extends Utilities {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
      //  1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

     //  1.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));


     //   1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

     //   1.4 Verify the Product price will arrange in High to Low order.

    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
      //  2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

      //  2.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

      //  2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

      //  2.4 Select Product “MacBook”
        clickOnElement(By.linkText("MacBook"));

     //   2.5 Verify the text “MacBook”
        assertVerifyText(By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");

     //   2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

     //   2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertVerifyText(By.xpath("//div[contains(text(),'Success: You have added ')]"), "Success: You have added MacBook to your shopping cart!\n" +
                "×" );

     //   2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

    //    2.9 Verify the text "Shopping Cart"
        assertVerifyText(By.xpath("//a[contains(text(),'Shopping Cart')]"), "Shopping Cart");

     //   2.10 Verify the Product name "MacBook"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");

        Actions actions= new Actions(driver);

     //   2.11 Change Quantity "2"
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        Thread.sleep(1000);
        actions.sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(Keys.DELETE).perform();
        Thread.sleep(1000);
        actions.sendKeys("2").perform();

     //   2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

     //   2.13 Verify the message “Success: You have modified your shopping cart!”
        assertVerifyText(By.xpath("//body/div[@id='checkout-cart']/div[1]"), " Success: You have modified your shopping cart!\n" +
                "×" );

     //   2.14 Verify the Total £737.45
        assertVerifyText(By.xpath("//td[contains(text(),'£737.45')]"), "£737.45");

     //   2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

    //    2.16 Verify the text “Checkout”
        Thread.sleep(1000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");

    //    2.17 Verify the Text “New Customer”
        Thread.sleep(1000);
        assertVerifyText(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");

    //    2.18 Click on “Guest Checkout” radio button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

      //  2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

    //    2.20 Fill the mandatory fields
        sendTextToElement(By.name("firstname"), "ABCD");
        Thread.sleep(1000);
        sendTextToElement(By.name("lastname"), "WXYZ");
        Thread.sleep(1000);
        sendTextToElement(By.id("input-payment-email"),"Abcdwxyz@gmail.com");
        Thread.sleep(1000);
        sendTextToElement(By.name("telephone"),"01234567890");
        Thread.sleep(1000);
        sendTextToElement(By.name("address_1"),"420 Roop Mahal");
        Thread.sleep(1000);
        sendTextToElement(By.name("city"),"London");
        Thread.sleep(1000);
        sendTextToElement(By.name("postcode"),"NW12TT");
        Thread.sleep(1000);
        clickOnElement(By.id("input-payment-country"));
        clickOnElement(By.xpath("//option[contains(text(),'United Kingdom')]"));
        Thread.sleep(1000);
        clickOnElement(By.id("input-payment-zone"));
        clickOnElement(By.xpath("//option[contains(text(),'Greater London')]"));
        Thread.sleep(1000);

     //  2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-register']"));

     ///  2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"),"Thank you");

        //    2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));

     //   2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

     //  2.25 Verify the message “Warning: Payment method required!
        assertVerifyText(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"), "Warning: Payment method required!");

    }
    @After
    public void tearDown() {

       closeBrowser();
    }
}
