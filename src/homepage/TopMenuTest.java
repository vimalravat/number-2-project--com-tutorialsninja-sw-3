package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class TopMenuTest extends Utilities {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

public void selectMenu (String menu) {

        if (menu == "Desktops") {

            mouseHoverToElement(By.linkText("Desktops"));
            clickOnElement(By.linkText("Show All Desktops"));
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "Desktops", title);

        } else if (menu == "Laptops & Notebooks") {

            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
            clickOnElement(By.linkText("Show All Laptops & Notebooks"));
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "Laptops & Notebooks", title);

        } else if (menu == "Components") {

            mouseHoverToElement(By.linkText("Components"));
            clickOnElement(By.linkText("Show All Components"));
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "Components", title);


        } else {
            System.out.println("Please insert valid data");
        }

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        //1.3 Verify the text ‘Desktops’
        selectMenu("Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //   2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        //   2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        //   2.3 Verify the text ‘Laptops & Notebooks’
        selectMenu("Laptops & Notebooks");


    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        //3.3 Verify the text ‘Components’
        selectMenu("Components");
    }

    @After
    public void tearDown() {

         closeBrowser();
    }
}
