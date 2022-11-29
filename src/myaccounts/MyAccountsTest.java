package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class MyAccountsTest extends Utilities {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before

    public void setUp() {

          openBrowser(baseUrl);
    }

public void selectMyAccountOptions(String option) throws InterruptedException {



        if (option == "Register") {
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
            assertVerifyText(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");

        } else if (option == "Login") {
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[contains(text(),'Login')]"));
            assertVerifyText(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");

        } else if (option == "Logout") {
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[normalize-space()='Logout']"));

        } else {
            System.out.println("Please insert valid information");
        }
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
     //   1.1 Click on My Account Link.
    //    1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
   //     1.3 Verify the text “Register Account

        selectMyAccountOptions("Register");

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {

         // 2.1 Click on My Account Link.
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login”

        //2.3 Verify the text “Returning Customer”
        selectMyAccountOptions("Login");
    }
    @Test
    public void  verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        /*3.1 Click on My Account Link.
        3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”*/
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        sendTextToElement(By.name("firstname"), "ABCD");

        //3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "WXYZ");

        //3.5 Enter Email
        sendTextToElement(By.id("input-email"), "abcd@xyzw.com");

        //3.6 Enter Telephone
        sendTextToElement(By.name("telephone"), "01234567890");

        //3.7 Enter Password
        sendTextToElement(By.id("input-password"), "Abcd123456");

        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "Abcd123456");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //3.16 Verify the text “Account Logout”
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");

        //3.17 Click on Continue button
        clickOnElement(By.linkText("Continue"));

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "abcd@xyzw.com");

        //4.4 Enter Last Name
        sendTextToElement(By.id("input-password"), "Abcd123456");

        //4.5 Enter Password
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.6 Click on Login button
        assertVerifyText(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");

        //4.7 Verify text “My Account”
        assertVerifyText(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//h2[contains(text(),'My Account')]"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void tearDown() {

        closeBrowser();
    }

}
